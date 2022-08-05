package main.java.Communication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.Models.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class EscamballService
{

    private final String baseUrl = "http://localhost:8080/api/";
    private final String timeController = "Time/";
    private final String jogadorController = "Jogador/";
    private final String transacaoController = "Transacao/";
    public EscamballService() {    }

    public TimeModel CadastroTime(String nomeDono, String nomeTime, String login, String senha) throws IOException {
        TimeModel t = new TimeModel();
        t.setNomeTime(nomeTime); t.setNomeDono(nomeDono);
        t.setLogin(login); t.setSenha(senha);

        String URL = baseUrl+timeController+"InsereTime";
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(URL);

        StringEntity postingString = new StringEntity(gson.toJson(t));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        TimeModel retorno = retornoGson.fromJson(result, TimeModel.class);

        return retorno;
    }

    public JogadorModel CadastroJogador(String nomeJogador, int idadeJogador, long precoJogador, int ataque, int defesa, int fisico, String posicao, int timeId) throws IOException
    {
        JogadorLightModel jogadorLightModel = new JogadorLightModel();
        jogadorLightModel.setNomeJogador(nomeJogador); jogadorLightModel.setIdadeJogador(idadeJogador);
        jogadorLightModel.setPrecoJogador(precoJogador); jogadorLightModel.setAtaque(ataque);
        jogadorLightModel.setDefesa(defesa); jogadorLightModel.setFisico(fisico);
        jogadorLightModel.setPosicao(posicao); jogadorLightModel.setTimeId(timeId);

        String URL = baseUrl+jogadorController+"InsereJogador";
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(URL);

        StringEntity postingString = new StringEntity(gson.toJson(jogadorLightModel));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        JogadorModel retorno = retornoGson.fromJson(result, JogadorModel.class);

        return retorno;
    }

    public TransacaoModel CadastroTransacao(int idTimeProposta, int idTimeReceptor, int idJogadorOferecido, int idJogadorDesejado) throws IOException
    {

        TransacaoModel t = new TransacaoModel();
        t.setTimePropostaId(idTimeProposta); t.setTimeReceptorId(idTimeReceptor);
        t.setJogadorOferecidoId(idJogadorOferecido); t.setJogadorDesejadoId(idJogadorDesejado);

        String URL = baseUrl+transacaoController+"InsereTransacao";
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(URL);

        StringEntity postingString = new StringEntity(gson.toJson(t));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        TransacaoModel retorno = retornoGson.fromJson(result, TransacaoModel.class);

        return retorno;
    }

    public TransacaoModel RespostaTransacao(int idTransacao, boolean aceite) throws IOException
    {
        TransacaoLightModel t = new TransacaoLightModel(idTransacao);
        String URL ="";
        if(aceite){
            URL = baseUrl+transacaoController+"AceitaTransacao";
        }
        else{
            URL = baseUrl+transacaoController+"RecusaTransacao";
        }

        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut(URL);

        StringEntity postingString = new StringEntity(gson.toJson(t));
        put.setEntity(postingString);
        put.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(put);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        TransacaoModel retorno = retornoGson.fromJson(result, TransacaoModel.class);

        return retorno;

    }

    public TransacaoModel RecuperaTransacaoPeloId(int idTransacao) throws IOException
    {
        String URL = baseUrl+transacaoController+"GetTransacaoPorId/"+idTransacao;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        TransacaoModel retorno = retornoGson.fromJson(result, TransacaoModel.class);

        return retorno;
    }

    public TimeModel RealizaLogin(String username, String password) throws IOException
    {
        LoginLightModel loginLightModel = new LoginLightModel(username, password);

        String URL = baseUrl+timeController+"ConfereLogin";
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(URL);

        StringEntity postingString = new StringEntity(gson.toJson(loginLightModel));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        TimeModel retorno = retornoGson.fromJson(result, TimeModel.class);

        return retorno;
    }

    public TimeModel BuscaTimePeloId(int timeId) throws IOException
    {
        String URL = baseUrl+timeController+"GetTimePorId/"+timeId;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        TimeModel retorno = retornoGson.fromJson(result, TimeModel.class);

        return retorno;
    }

    public JogadorModel BuscaJogadorPeloId(int jogadorId) throws IOException
    {
        String URL = baseUrl+jogadorController+"JogadorPorId/"+jogadorId;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        JogadorModel retorno = retornoGson.fromJson(result, JogadorModel.class);

        return retorno;
    }

    public List<JogadorModel> BuscaJogadoresPeloNome(String nome) throws IOException
    {
        String URL = baseUrl+jogadorController+"JogadoresPorNome/"+nome;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        List<JogadorModel> retorno = retornoGson.fromJson(result, new TypeToken<List<JogadorModel>>(){}.getType());

        return retorno;
    }

    public List<JogadorModel> BuscaJogadorPelaPosicao(String posicao) throws IOException
    {
        String URL = baseUrl+jogadorController+"JogadoresPorPosicao/"+posicao;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        List<JogadorModel> retorno = retornoGson.fromJson(result, new TypeToken<List<JogadorModel>>(){}.getType());

        return retorno;
    }

    public List<JogadorModel> ListaDeJogadoresTime(int timeId) throws IOException
    {
        String URL = baseUrl+jogadorController+"JogadoresPorIdTime/"+timeId;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        List<JogadorModel> retorno = retornoGson.fromJson(result, new TypeToken<List<JogadorModel>>(){}.getType());

        return retorno;
    }

    public List<TransacaoModel> BuscaListaDeTransacoes(int timeId) throws IOException
    {
        String URL = baseUrl+transacaoController+"GetTransacoesPorTimeId/"+timeId;
        Gson gson = new Gson();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(URL);

        get.setHeader("Content-type", "application/json");

        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        Gson retornoGson = new Gson();
        List<TransacaoModel> retorno = retornoGson.fromJson(result, new TypeToken<List<TransacaoModel>>(){}.getType());

        return retorno;
    }
}