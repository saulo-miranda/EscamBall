package main.java.Communication;

import main.java.Controllers.Persistencia;
import main.java.Models.*;
import main.java.generated.*;

import io.grpc.stub.StreamObserver;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class EscamballService extends escamballGrpc.escamballImplBase{

    private final Persistencia persistencia;

    public EscamballService(Persistencia persistencia) {
        this.persistencia = persistencia;
    }
    @Override
    public void cadastro(CadastroRequest request, StreamObserver<APIResponse> responseObserver) {
        String nomeDono = request.getNomeDono();
        String nomeTime = request.getNomeTime();
        String login = request.getLogin();
        String senha = request.getSenha();
        APIResponse.Builder response = APIResponse.newBuilder();

        TimeModel t = new TimeModel(nomeDono,nomeTime,login,senha);
        int idTime = persistencia.inserirTime(t);

        if(idTime != -1 && idTime != 0){
            response.setResponseMessage("Time criado. Id: "+idTime).setResponseCode(200).setIdCadastrado(idTime);
        }else{
            response.setResponseMessage("Falha ao inserir o time").setResponseCode(400);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void cadastroJogador(CadastroJogadorRequest request, StreamObserver<APIResponse> responseObserver) {
        String nomeJogador = request.getNomeJogador();
        int idadeJogador = request.getIdadeJogador();
        long precoJogador = request.getPreco();
        Posicao posicaoJogador = request.getPosicao();
        Pontuacao pontuacaoJogador = request.getPontuacao();
        int idTime = request.getIdTime();
        APIResponse.Builder response = APIResponse.newBuilder();

        if(idTime == 0 || idTime == -1){
            response.setResponseMessage("Erro ao inserir jogador, id do time invalido!").setResponseCode(400).setIdCadastrado(0);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }

        PosicaoModel posicaoModel = new PosicaoModel(posicaoJogador.getGoleiro(), posicaoJogador.getDefensor(), posicaoJogador.getMeia(), posicaoJogador.getAtacante());
        PontuacaoModel pontuacaoModel = new PontuacaoModel(pontuacaoJogador.getAtaque(), pontuacaoJogador.getDefesa(), pontuacaoJogador.getFisico());
        JogadorModel jogadorModel = new JogadorModel(idTime, nomeJogador, idadeJogador, posicaoModel, precoJogador, pontuacaoModel);

        int idJogador = persistencia.inserirJogador(jogadorModel);

        if(idJogador != 0 && idJogador != -1){
            response.setResponseMessage("Jogador inserido com sucesso! Id: "+idJogador).setResponseCode(200).setIdCadastrado(idJogador);
        }else{
            response.setResponseMessage("Falha ao inserir jogador!").setResponseCode(400);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void novaTransacao(TransacaoRequest request, StreamObserver<APIResponse> responseObserver) {
        int idTimeProposta = request.getIdTimeProposta();
        int idTimeReceptor = request.getIdTimeReceptor();
        int idJogadorProposto = request.getIdJogadorProposto();
        int idJogadorDesejado = request.getIdJogadorDesejado();

        APIResponse.Builder response = APIResponse.newBuilder();

        JogadorModel jogadorProposto = persistencia.recuperarJogador(idJogadorProposto);
        JogadorModel jogadorDesejado = persistencia.recuperarJogador(idJogadorDesejado);

        TransacaoModel transacaoModel = new TransacaoModel(idTimeProposta,idTimeReceptor,jogadorProposto,jogadorDesejado);

        int idTransacao = persistencia.inserirTransacao(transacaoModel);

        if(idTransacao != 0 && idTransacao != -1){
            response.setResponseMessage("Transacao inserido com sucesso! Id: "+idTransacao).setResponseCode(200).setIdCadastrado(idTransacao);
        }
        else{
            response.setResponseMessage("Falha ao inserir transacao!").setResponseCode(400);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void responderTransacao(RespostaTransacaoRequest request, StreamObserver<APIResponse> responseObserver) {
        int idTransacao = request.getIdTransacao();
        boolean aceite = request.getAceite();

        APIResponse.Builder response = APIResponse.newBuilder();

        TransacaoModel transacaoModel = persistencia.recuperarTransacao(idTransacao);

        if(transacaoModel==null){
            response.setResponseMessage("Transacao nao encontrada!").setResponseCode(404);
        } else if (transacaoModel.isFinalizada()) {
            response.setResponseMessage("Transacao ja finalizada!").setResponseCode(400);
        } else{
            transacaoModel.setAceita(aceite);
            boolean resposta = persistencia.alterarTransacao(transacaoModel);
            if(resposta){
                response.setResponseMessage("Transacao respondida com sucesso!").setResponseCode(200);
            }else{
                response.setResponseMessage("Falha ao responder transacao!").setResponseCode(400);
            }
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void login(LoginRequest request, StreamObserver<TimeResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        TimeResponse.Builder response = TimeResponse.newBuilder();

        LoginModel loginModel = new LoginModel(username, password);
        TimeModel timeModel;
        try {
            timeModel = persistencia.recuperarTimePorLogin(username);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        CadastroRequest cadastroRequest = CadastroRequest.newBuilder().setNomeDono(timeModel.getNomeDono()).setNomeTime(timeModel.getNomeTime()).setLogin(timeModel.getLogin()).setSenha(password).build();

        Time time = Time.newBuilder().setTime(cadastroRequest).setIdTime(timeModel.getIdTime()).build();

        if(timeModel.getSenha().equals(loginModel.getPassword())){
            response.setTime(time).setResponseMessage("Equipe Encontrada com sucesso");
        }else{
            response.setResponseMessage("Equipe nao encontrada");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    @Override
    public void recuperaTimePeloId(PesquisaPorIdTimeRequest request, StreamObserver<TimeResponse> responseObserver) {
        int idTime = request.getIdTime();
        TimeResponse.Builder response = TimeResponse.newBuilder();

        TimeModel timeModel = persistencia.recuperarTime(idTime);
        if(timeModel.getNomeTime().isEmpty()){
            response.setResponseMessage("Equipe nao encontrada");
        }
        else{
            CadastroRequest timeEncontrado = CadastroRequest.newBuilder().
                    setNomeTime(timeModel.getNomeTime()).
                    setNomeDono(timeModel.getNomeDono()).
                    //Nao podemos passar o login e a senha nesse caso
                    //para que quem tenha o id não consiga essas informacoes
                    setLogin("").
                    setSenha("").
                    build();
            Time time = Time.newBuilder().
                    setTime(timeEncontrado).
                    setIdTime(idTime).
                    build();
            response.setTime(time).setResponseMessage("Equipe Encontrada com sucesso");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void recuperaJogadorPeloId(PesquisaPorIdJogadorRequest request, StreamObserver<JogadorResponse> responseObserver) {
        int idJogador = request.getIdJogador();
        JogadorResponse.Builder response = JogadorResponse.newBuilder();

        JogadorModel jogadorModel = persistencia.recuperarJogador(idJogador);

        if(jogadorModel == null){
            response.setResponseMessage("Jogador não encontrado");
        }
        else{
            Jogador jogador = ConstroiJogador(jogadorModel);
            response.setResponseMessage("Jogador encontrado").setJogador(jogador);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    @Override
    public void recuperaTransacaoPeloId(PesquisaPorIdTransacaoRequest request, StreamObserver<TransacaoResponse> responseObserver) {
        int idTransacao = request.getIdTransacao();
        TransacaoResponse.Builder response = TransacaoResponse.newBuilder();

        TransacaoModel transacao = persistencia.recuperarTransacao(idTransacao);

        if(transacao == null){
            response.setResponseMessage("Transacao nao encontrada");
        }
        else{
            Jogador jogadorProposto = ConstroiJogador(transacao.getJogadorProposto());
            Jogador jogadorDesejado = ConstroiJogador(transacao.getJogadorDesejado());
            TransacaoJogador transacaoJogador = TransacaoJogador.newBuilder().
                    setIdTransacao(transacao.getIdTransacao()).
                    setIdTimeProposto(transacao.getIdTimeProposta()).
                    setIdTimeReceptor(transacao.getIdTimeReceptor()).
                    setJogadorProposto(jogadorProposto).
                    setJogadorDesejado(jogadorDesejado).
                    build();
            response.setResponseMessage("Transacao encontrada").setTransacao(transacaoJogador);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void buscaJogadoresNome(BuscaJogadoresRequest request, StreamObserver<ListaJogadoresResponse> responseObserver) {
        String nomeJogador = request.getNomeJogador();

        ListaJogadoresResponse.Builder response = ListaJogadoresResponse.newBuilder();

        List<JogadorModel> jogadorModelList = persistencia.recuperarJogadorPeloNome(nomeJogador);
        if(jogadorModelList.isEmpty()){
            response.setResponseMessage("Nenhum jogador encontrado");
        }
        else{
            List<Jogador> jogadorList = new ArrayList<>(jogadorModelList.size());
            for(JogadorModel j: jogadorModelList){
                Jogador jogador = ConstroiJogador(j);
                jogadorList.add(jogador);
            }
            response.setResponseMessage("Lista de Jogadores").addAllJogadores(jogadorList);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void buscaJogadoresPosicao(BuscaJogadoresPosicaoRequest request, StreamObserver<ListaJogadoresResponse> responseObserver) {
        Posicao posicao = request.getPosicao();

        ListaJogadoresResponse.Builder response = ListaJogadoresResponse.newBuilder();

        String posicaoString = posicao.getGoleiro() ?
                "GOLEIRO": posicao.getDefensor() ?
                "DEFENSOR" : posicao.getMeia() ?
                "MEIA": posicao.getAtacante() ?
                "ATACANTE" : "";

        List<JogadorModel> jogadorModelList = persistencia.recuperarJogadorPelaPosicao(posicaoString);
        if(jogadorModelList == null){
            response.setResponseMessage("Nenhum jogador encontrado");
        }else{
            List<Jogador> jogadorList = new ArrayList<>(jogadorModelList.size());
            for(JogadorModel j: jogadorModelList){
                Jogador jogador = ConstroiJogador(j);
                jogadorList.add(jogador);
            }
            response.setResponseMessage("Lista de Jogadores").addAllJogadores(jogadorList);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void exibeListaJogadores(PesquisaPorIdTimeRequest request, StreamObserver<ListaJogadoresResponse> responseObserver) {
        int idTime = request.getIdTime();
        ListaJogadoresResponse.Builder response = ListaJogadoresResponse.newBuilder();

        TimeModel t = persistencia.recuperarTime(idTime);
        if(t==null){
            response.setResponseMessage("Time nao encontrado");
        }
        else{
            persistencia.recuperarElenco(t);
            List<Jogador> jogadorList = new ArrayList<>(t.getElenco().size());
            for(JogadorModel j: t.getElenco()){
                Jogador jogador = ConstroiJogador(j);
                jogadorList.add(jogador);
            }
            response.setResponseMessage("Lista de Jogadores").addAllJogadores(jogadorList);
        }



        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void historicoTransacoes(PesquisaPorIdTimeRequest request, StreamObserver<ListaTransacaoResponse> responseObserver) {
        int idTime = request.getIdTime();
        ListaTransacaoResponse.Builder response = ListaTransacaoResponse.newBuilder();
        TimeModel timeModel = persistencia.recuperarTime(idTime);
        if(timeModel.getNomeTime().isEmpty()){
            response.setResponseMessage("Erro! Time nao encontrado!");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }
        List<TransacaoModel> transacaoModelList = persistencia.historicoTransacoes(timeModel);
        if(transacaoModelList.isEmpty()){
            response.setResponseMessage("Nenhuma transacao encontrada!");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }
        List<TransacaoJogador> transacaoList = new ArrayList<>(transacaoModelList.size());
        for (TransacaoModel model: transacaoModelList) {
            Jogador jogadorProposto = ConstroiJogador(model.getJogadorProposto());
            Jogador jogadorDesejado = ConstroiJogador(model.getJogadorDesejado());
            TransacaoJogador transacaoJogador = TransacaoJogador.newBuilder().
                    setIdTransacao(model.getIdTransacao()).
                    setIdTimeProposto(model.getIdTimeProposta()).
                    setIdTimeReceptor(model.getIdTimeReceptor()).
                    setJogadorProposto(jogadorProposto).
                    setJogadorDesejado(jogadorDesejado).
                    build();
            transacaoList.add(transacaoJogador);
        }
        response.setResponseMessage("Lista de transacoes").addAllTransacoes(transacaoList);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private Jogador ConstroiJogador(JogadorModel j){
        Posicao pos = Posicao.newBuilder().setGoleiro(j.getPosicao().isGoleiro()).setDefensor(j.getPosicao().isZagueiro()).setMeia(j.getPosicao().isMeioCampista()).setAtacante(j.getPosicao().isAtacante()).build();
        Pontuacao pon = Pontuacao.newBuilder().setAtaque(j.getPontos().getAtaque()).setDefesa(j.getPontos().getDefesa()).setFisico(j.getPontos().getFisico()).build();

        CadastroJogadorRequest jog = CadastroJogadorRequest.newBuilder().
                setIdTime(j.getIdTime()).
                setNomeJogador(j.getNome()).
                setIdadeJogador(j.getIdade()).
                setPosicao(pos).
                setPreco(j.getPreco()).
                setPontuacao(pon).
                build();

        return Jogador.newBuilder().setIdJogador(j.getIdJogador()).setJogador(jog).build();
    }
}