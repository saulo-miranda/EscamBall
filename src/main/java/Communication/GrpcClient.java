package main.java.Communication;

import main.java.Models.*;
import main.java.generated.*;
import main.java.generated.escamballGrpc.escamballStub;
import io.grpc.Channel;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class GrpcClient {
    private final Channel channel;
    private int idCadastrado;
    private TimeModel timeModel;
    private List<JogadorModel> jogadores;
    private List<TransacaoModel> transacoes;
    private JogadorModel jogador;
    private TransacaoModel transacao;

    public GrpcClient(int port){
        this.channel = NettyChannelBuilder.forAddress("localhost", port).negotiationType(NegotiationType.PLAINTEXT).build();
    }

    public void CadastroTime(String nomeTime, String nomeDono, String login, String senha){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CadastroRequest cadastroRequest = CadastroRequest.newBuilder().
                setNomeDono(nomeDono).
                setNomeTime(nomeTime).
                setLogin(login).
                setSenha(senha).
                build();
        StreamObserver<APIResponse> apiResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(APIResponse apiResponse) {
                System.out.println("Response " + apiResponse.toString());
                setIdCadastrado(apiResponse.getIdCadastrado());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.cadastro(cadastroRequest, apiResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void CadastroJogador(JogadorModel jogador){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Posicao posicao = Posicao.newBuilder().
                setGoleiro(jogador.getPosicao().isGoleiro()).
                setDefensor(jogador.getPosicao().isZagueiro()).
                setMeia(jogador.getPosicao().isMeioCampista()).
                setAtacante(jogador.getPosicao().isAtacante()).
                build();
        Pontuacao pontuacao = Pontuacao.newBuilder().
                setAtaque(jogador.getPontos().getAtaque()).
                setDefesa(jogador.getPontos().getDefesa()).
                setFisico(jogador.getPontos().getFisico()).
                build();
        CadastroJogadorRequest cadastroJogadorRequest = CadastroJogadorRequest.newBuilder().
                setIdTime(jogador.getIdTime()).
                setNomeJogador(jogador.getNome()).
                setIdadeJogador(jogador.getIdade()).
                setPreco(jogador.getPreco()).
                setPosicao(posicao).
                setPontuacao(pontuacao).
                build();

        StreamObserver<APIResponse> apiResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(APIResponse apiResponse) {
                System.out.println("Response " + apiResponse.toString());
                setIdCadastrado(apiResponse.getIdCadastrado());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };

        stub.cadastroJogador(cadastroJogadorRequest, apiResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void CadastroTransacao(int idTimeProposta, int idTimeReceptor, int idJogadorProposto, int idJogadorDesejado){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        TransacaoRequest transacaoRequest = TransacaoRequest.newBuilder().
                setIdTimeProposta(idTimeProposta).
                setIdTimeReceptor(idTimeReceptor).
                setIdJogadorProposto(idJogadorProposto).
                setIdJogadorDesejado(idJogadorDesejado).
                build();
        StreamObserver<APIResponse> apiResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(APIResponse apiResponse) {
                System.out.println("Response " + apiResponse.toString());
                setIdCadastrado(apiResponse.getIdCadastrado());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.novaTransacao(transacaoRequest,apiResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void RespostaTransacao(int idTransacao, boolean aceite){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RespostaTransacaoRequest resposta = RespostaTransacaoRequest.newBuilder().setIdTransacao(idTransacao).setAceite(aceite).build();
        StreamObserver<APIResponse> apiResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(APIResponse apiResponse) {
                System.out.println("Response " + apiResponse.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.responderTransacao(resposta,apiResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void RecuperaTransacaoPeloId(int idTransacao){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        PesquisaPorIdTransacaoRequest request = PesquisaPorIdTransacaoRequest.newBuilder().
                setIdTransacao(idTransacao).
                build();
        StreamObserver<TransacaoResponse> respose = new StreamObserver<>() {
            @Override
            public void onNext(TransacaoResponse transacaoResponse) {
                System.out.println("Response: "+transacaoResponse.toString());
                if(transacaoResponse.hasTransacao()){
                    JogadorModel jP = ConstroiJogadorModel(transacaoResponse.getTransacao().getJogadorProposto());
                    JogadorModel jD = ConstroiJogadorModel(transacaoResponse.getTransacao().getJogadorDesejado());
                    TransacaoModel t = new TransacaoModel(transacaoResponse.getTransacao().getIdTimeProposto(), transacaoResponse.getTransacao().getIdTimeReceptor(),jP,jD);
                    t.setIdTransacao(transacaoResponse.getTransacao().getIdTransacao());
                    setTransacao(t);
                }
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.recuperaTransacaoPeloId(request,respose);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void RealizaLogin(String username, String password){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        LoginRequest loginRequest = LoginRequest.newBuilder().
                setUsername(username).
                setPassword(password).
                build();
        StreamObserver<TimeResponse> timeResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(TimeResponse timeResponse) {
                System.out.println("Response: "+timeResponse.toString());
                if(timeResponse.getTime().hasTime()){
                    String nomeDono = timeResponse.getTime().getTime().getNomeDono();
                    String nomeTime = timeResponse.getTime().getTime().getNomeTime();
                    String login = timeResponse.getTime().getTime().getLogin();
                    String senha = timeResponse.getTime().getTime().getSenha();
                    TimeModel t = new TimeModel(nomeDono, nomeTime, login, senha);
                    t.setIdTime(timeResponse.getTime().getIdTime());
                    setTimeModel(t);
                }
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.login(loginRequest, timeResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void BuscaTimePeloId(int idTime){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        PesquisaPorIdTimeRequest request = PesquisaPorIdTimeRequest.newBuilder().setIdTime(idTime).build();
        StreamObserver<TimeResponse> timeResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(TimeResponse timeResponse) {
                System.out.println("Response: "+timeResponse.toString());
                if(timeResponse.getTime().hasTime()){
                    String nomeDono = timeResponse.getTime().getTime().getNomeDono();
                    String nomeTime = timeResponse.getTime().getTime().getNomeTime();
                    String login = timeResponse.getTime().getTime().getLogin();
                    String senha = timeResponse.getTime().getTime().getSenha();
                    TimeModel t = new TimeModel(nomeDono, nomeTime, login, senha);
                    t.setIdTime(timeResponse.getTime().getIdTime());
                    setTimeModel(t);
                }
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.recuperaTimePeloId(request, timeResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void BuscaJogadorPeloId(int idJogador){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        PesquisaPorIdJogadorRequest request = PesquisaPorIdJogadorRequest.newBuilder().setIdJogador(idJogador).build();
        StreamObserver<JogadorResponse> response = new StreamObserver<>() {
            @Override
            public void onNext(JogadorResponse jogadorResponse) {
                System.out.println("Response: "+jogadorResponse.toString());
                if(jogadorResponse.hasJogador()){
                    JogadorModel jogadorModel = ConstroiJogadorModel(jogadorResponse.getJogador());
                    setJogador(jogadorModel);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.recuperaJogadorPeloId(request, response);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void BuscaJogadoresPeloNome(String nome){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        BuscaJogadoresRequest buscaJogadoresRequest = BuscaJogadoresRequest.newBuilder().
                setNomeJogador(nome).
                build();
        StreamObserver<ListaJogadoresResponse> lista = new StreamObserver<>() {
            @Override
            public void onNext(ListaJogadoresResponse listaJogadoresResponse) {
                System.out.println("Lista de jogadores: "+listaJogadoresResponse.toString());
                if(listaJogadoresResponse.getJogadoresCount() > 0){
                    List<JogadorModel> jogadoresModelList = new ArrayList<>(listaJogadoresResponse.getJogadoresCount());
                    for(Jogador j : listaJogadoresResponse.getJogadoresList()){
                        JogadorModel jogadorModel = ConstroiJogadorModel(j);
                        jogadoresModelList.add(jogadorModel);
                    }
                    setJogadores(jogadoresModelList);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.buscaJogadoresNome(buscaJogadoresRequest, lista);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void BuscaJogadorPelaPosicao(String posicao){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        posicao = posicao.toUpperCase();
        Posicao pos = Posicao.newBuilder().
                setGoleiro(posicao.equals("GOLEIRO")).
                setDefensor(posicao.equals("DEFENSOR")).
                setMeia(posicao.equals("MEIA")).
                setAtacante(posicao.equals("ATACANTE")).
                build();

        BuscaJogadoresPosicaoRequest posicaoRequest = BuscaJogadoresPosicaoRequest.newBuilder().
                setPosicao(pos).
                build();
        StreamObserver<ListaJogadoresResponse> lista = new StreamObserver<>() {
            @Override
            public void onNext(ListaJogadoresResponse listaJogadoresResponse) {
                System.out.println("Lista de jogadores: "+listaJogadoresResponse.toString());
                if(listaJogadoresResponse.getJogadoresCount() > 0){
                    List<JogadorModel> jogadoresModelList = new ArrayList<>(listaJogadoresResponse.getJogadoresCount());
                    for(Jogador j : listaJogadoresResponse.getJogadoresList()){
                        JogadorModel jogadorModel = ConstroiJogadorModel(j);
                        jogadoresModelList.add(jogadorModel);
                    }
                    setJogadores(jogadoresModelList);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.buscaJogadoresPosicao(posicaoRequest, lista);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ListaDeJogadoresTime(int idTime){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        PesquisaPorIdTimeRequest request = PesquisaPorIdTimeRequest.newBuilder().setIdTime(idTime).build();
        StreamObserver<ListaJogadoresResponse> lista = new StreamObserver<>() {
            @Override
            public void onNext(ListaJogadoresResponse listaJogadoresResponse) {
                System.out.println("Lista de jogadores: "+listaJogadoresResponse.toString());
                if(listaJogadoresResponse.getJogadoresCount() > 0){
                    List<JogadorModel> jogadoresModelList = new ArrayList<>(listaJogadoresResponse.getJogadoresCount());
                    for(Jogador j : listaJogadoresResponse.getJogadoresList()){
                        JogadorModel jogadorModel = ConstroiJogadorModel(j);
                        jogadoresModelList.add(jogadorModel);
                    }
                    setJogadores(jogadoresModelList);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.exibeListaJogadores(request, lista);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void BuscaListaDeTransacoes(int idTime){
        escamballStub stub = escamballGrpc.newStub(channel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        PesquisaPorIdTimeRequest request = PesquisaPorIdTimeRequest.newBuilder().setIdTime(idTime).build();
        StreamObserver<ListaTransacaoResponse> response = new StreamObserver<>() {
            @Override
            public void onNext(ListaTransacaoResponse transacaoResponse) {
                System.out.println("Response: "+transacaoResponse.toString());
                if(!transacaoResponse.getTransacoesList().isEmpty()){
                    List<TransacaoModel> transacaoModelList = new ArrayList<>(transacaoResponse.getSerializedSize());
                    for(TransacaoJogador t : transacaoResponse.getTransacoesList()){
                        JogadorModel jogadorProposto = ConstroiJogadorModel(t.getJogadorProposto());
                        JogadorModel jogadorDesejado = ConstroiJogadorModel(t.getJogadorDesejado());
                        TransacaoModel transacaoModel = new TransacaoModel(t.getIdTimeProposto(),t.getIdTimeReceptor(),jogadorProposto,jogadorDesejado);
                        transacaoModel.setIdTransacao(t.getIdTransacao());
                        transacaoModelList.add(transacaoModel);
                    }
                    setTransacoes(transacaoModelList);
                }
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        };
        stub.historicoTransacoes(request, response);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public JogadorModel ConstroiJogadorModel(Jogador j){
        Posicao posicao = j.getJogador().getPosicao();
        Pontuacao pontuacao = j.getJogador().getPontuacao();
        PosicaoModel pos = new PosicaoModel(posicao.getGoleiro(), posicao.getDefensor(), posicao.getMeia(), posicao.getAtacante());
        PontuacaoModel pon = new PontuacaoModel(pontuacao.getAtaque(),pontuacao.getDefesa(),pontuacao.getFisico());
        JogadorModel jogador = new JogadorModel(j.getJogador().getIdTime(),j.getJogador().getNomeJogador(),j.getJogador().getIdadeJogador(),pos,j.getJogador().getPreco(),pon);
        jogador.setIdJogador(j.getIdJogador());
        return jogador;
    }

    public int getIdCadastrado() {
        return idCadastrado;
    }
    public void setIdCadastrado(int idCadastrado){
        this.idCadastrado = idCadastrado;
    }

    public TimeModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(TimeModel timeModel) {
        this.timeModel = timeModel;
    }

    public List<JogadorModel> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorModel> jogadores) {
        this.jogadores = jogadores;
    }

    public List<TransacaoModel> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<TransacaoModel> transacoes) {
        this.transacoes = transacoes;
    }

    public JogadorModel getJogador() {
        return jogador;
    }

    public void setJogador(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public TransacaoModel getTransacao() {
        return transacao;
    }

    public void setTransacao(TransacaoModel transacao) {
        this.transacao = transacao;
    }
}
