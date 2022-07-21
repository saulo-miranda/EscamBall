package main.java.Controllers;

import main.java.Models.*;
import main.java.TimesPadroes.TimesPadroes;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    private Connection conexaoBD;
    private Statement stmt;

    private final String BD;

    public Persistencia(String bd){
        BD = bd;
        this.conectar();
        this.criarTabela();
        AdicionaTimesPadroes();
    }

    private void conectar(){
        Connection con;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+BD);
            conexaoBD = con;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void fechar() throws SQLException {
        conexaoBD.close();
    }

    public void criarTabela(){
        try {
            stmt = conexaoBD.createStatement();

            String sql_pontuacao = "CREATE TABLE IF NOT EXISTS Pontuacao " +
                    "(ID_PONTUACAO INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " ataque INTEGER NOT NULL," +
                    " defesa INTEGER NOT NULL," +
                    " fisico INTEGER NOT NULL," +
                    " geral INTEGER NOT NULL)";

            String sql_time = "CREATE TABLE IF NOT EXISTS Time " +
                    "(ID_TIME INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nome_time TEXT NOT NULL," +
                    " nome_dono TEXT NOT NULL," +
                    " login TEXT NOT NULL UNIQUE," +
                    " senha TEXT NOT NULL)";

            String sql_posicao = "CREATE TABLE IF NOT EXISTS Posicao " +
                    "(ID_POSICAO INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " GOLEIRO INTEGER," +
                    " DEFENSOR INTEGER," +
                    " MEIA INTEGER," +
                    " ATACANTE INTEGER)";

            String sql_jogador = "CREATE TABLE IF NOT EXISTS Jogador " +
                    "(ID_JOGADOR INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " ID_TIME INTEGER NOT NULL, " +
                    " nome TEXT, " +
                    " idade INTEGER NOT NULL," +
                    " preco INTEGER NOT NULL, " +
                    " ID_PONTUACAO INTEGER NOT NULL, " +
                    " ID_POSICAO INTEGER NOT NULL, " +
                    " foto TEXT," +
                    " FOREIGN KEY (ID_PONTUACAO) REFERENCES Pontuacao(ID_PONTUACAO)," +
                    " FOREIGN KEY (ID_POSICAO) REFERENCES Posicao(ID_POSICAO)" +
                    " FOREIGN KEY (ID_TIME) REFERENCES Time(ID_TIME)" +
                    ")";

            String sql_transacao = "CREATE TABLE IF NOT EXISTS Transacao " +
                    "(ID_TRANSACAO INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " ID_TIME_PROPOSTA  INTEGER NOT NULL, " +
                    " ID_TIME_RECEPTOR INTEGER NOT NULL, " +
                    " JOGADOR_PROPOSTO INTEGER NOT NULL, " +
                    " JOGADOR_DESEJADO INTEGER NOT NULL, " +
                    " ACEITA INTEGER NOT NULL," +
                    " FINALIZADA INTEGER NOT NULL, " +
                    " FOREIGN KEY (ID_TIME_PROPOSTA) REFERENCES Time(ID_TIME)," +
                    " FOREIGN KEY (ID_TIME_RECEPTOR) REFERENCES Time(ID_TIME)," +
                    " FOREIGN KEY (JOGADOR_PROPOSTO) REFERENCES Jogador(ID_JOGADOR)" +
                    " FOREIGN KEY (JOGADOR_DESEJADO) REFERENCES Jogador(ID_JOGADOR)" +
                    ")";

            stmt.execute(sql_pontuacao);
            System.out.println("Tabela Pontuacao criada com sucesso!");
            stmt.execute(sql_time);
            System.out.println("Tabela Time criada com sucesso!");
            stmt.execute(sql_posicao);
            System.out.println("Tabela Posicao criada com sucesso!");
            stmt.execute(sql_jogador);
            System.out.println("Tabela Jogador criada com sucesso!");
            stmt.execute(sql_transacao);
            System.out.println("Tabela Transação criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void AdicionaTimesPadroes(){
        TimesPadroes timesPadroes = new TimesPadroes();
        int idReal = this.inserirTime(timesPadroes.getRealMadrid());
        int idPsg = this.inserirTime(timesPadroes.getParisSaintGermain());
        if(idReal != -1){
            for(JogadorModel jRM : timesPadroes.getRealMadrid().getElenco()){
                inserirJogador(jRM);
            }
        }
        if(idPsg != -1){
            for(JogadorModel jPSG : timesPadroes.getParisSaintGermain().getElenco()){
                inserirJogador(jPSG);
            }
        }
    }

    public int inserirPontuacao(PontuacaoModel p){

        String sql = "INSERT INTO Pontuacao(ataque, defesa, fisico, geral) " +
                "VALUES("+p.getAtaque()+","+p.getDefesa()+","+p.getFisico()+","+p.getGeral()+")";
        try {
            stmt.execute(sql);
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_PONTUACAO) AS max_id FROM Pontuacao");
            int ID =  retorno.getInt("max_id");
            p.setIdPontuacao(ID);
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Pontuação no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public PontuacaoModel recuperarPontuacao(int ID){
        String sql = "SELECT * FROM Pontuacao " +
                "WHERE ID_PONTUACAO = " + ID;
        try {
            PontuacaoModel p = new PontuacaoModel(0,0,0);
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                p.setAtaque(select.getInt("ataque"));
                p.setDefesa(select.getInt("defesa"));
                p.setFisico(select.getInt("fisico"));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarPontuacao(PontuacaoModel p){
        String sql = "UPDATE Pontuacao "+
                "SET ataque = " +p.getAtaque() + ", defesa = "+p.getDefesa()+", fisico = "+p.getFisico()+", geral = "+p.getGeral()+
                " WHERE ID_PONTUACAO = "+ p.getIdPontuacao();
        try {
            stmt.execute(sql);
            boolean retorno = stmt.execute(sql);
            System.out.println("SUCESSO: alterar Pontuação no SQLite!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar Pontuação no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public int inserirPosicao(PosicaoModel p){
        String sql = "INSERT INTO Posicao(GOLEIRO, DEFENSOR, MEIA, ATACANTE) " +
                "VALUES("+p.isGoleiro()+","+p.isZagueiro()+","+p.isMeioCampista()+","+p.isAtacante()+")";
        try {
            stmt.execute(sql);
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_POSICAO) AS max_id_posicao FROM Posicao");
            int ID =  retorno.getInt("max_id_posicao");
            p.setIdPosicao(ID);
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Posição no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public PosicaoModel recuperarPosicao(int ID){
        String sql = "SELECT * FROM Posicao " +
                "WHERE ID_POSICAO = " + ID;
        try {
            PosicaoModel p = new PosicaoModel(false,false,false,false);
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                p.setIdPosicao(select.getInt("ID_POSICAO"));
                p.setGoleiro(select.getBoolean("GOLEIRO"));
                p.setZagueiro(select.getBoolean("DEFENSOR"));
                p.setMeioCampista(select.getBoolean("MEIA"));
                p.setAtacante(select.getBoolean("ATACANTE"));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarPosicao(PosicaoModel p){
        String sql = "UPDATE Posicao "+
                "SET GOLEIRO = " +p.isGoleiro() +
                ", DEFENSOR = "+p.isZagueiro() +
                ", MEIA = "+p.isMeioCampista() +
                ", ATACANTE = "+p.isAtacante() +
                " WHERE ID_POSICAO = "+ p.getIdPosicao();
        try {
            stmt.execute(sql);
            boolean retorno = stmt.execute(sql);
            System.out.println("SUCESSO: alterar Posição no SQLite!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar Posição no SQLite!");
            throw new RuntimeException(e);
        }
    }
    public int inserirJogador(JogadorModel j){
        String sql = "INSERT INTO Jogador( idade, nome, preco, ID_PONTUACAO, ID_POSICAO, ID_TIME) " +
                "VALUES("+j.getIdade()+", ? ,"+j.getPreco()+","+ inserirPontuacao(j.getPontos())+
                ","+inserirPosicao(j.getPosicao())+","+ j.getIdTime()+
                ")";
        try {
            PreparedStatement ps = conexaoBD.prepareStatement(sql);
            ps.setString(1, j.getNome());
            ps.execute();
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_JOGADOR) AS max_id FROM Jogador");
            int ID =  retorno.getInt("max_id");
            System.out.println("SUCESSO: inserir Jogador no SQLite!");
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Jogador no SQLite!");
            return -1;
        }
    }

    public JogadorModel recuperarJogador(int ID){
        JogadorModel j = null;
        String sql = "SELECT nome, idade, preco, ID_PONTUACAO, ID_POSICAO, ID_TIME, ID_JOGADOR FROM Jogador " +
                " WHERE ID_JOGADOR = " + ID + ";";
        try {
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                String nome = select.getString(1);
                int idade = select.getInt(2);
                int idPos = select.getInt(5);
                int preco = select.getInt(3);
                int idPont = select.getInt(4);
                int idTime = select.getInt(6);
                j = new JogadorModel(idTime,nome,idade , recuperarPosicao(idPos), preco , recuperarPontuacao(idPont));

                j.setIdJogador(ID);
            }
            return j;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<JogadorModel> recuperarJogadorPeloNome(String nome) {
        nome=nome.toLowerCase();
        String sql = "SELECT ID_JOGADOR, nome FROM Jogador "+
                "WHERE ID_TIME > 0 AND nome LIKE '%" + nome + "%';";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<JogadorModel> elenco = new ArrayList<>();
            while (rs.next()) {
                if(rs.getMetaData().getColumnCount() != 2){ continue;}
                int j = rs.getInt(1);
                resultado.add(j);
            }
            for(int id: resultado){
                elenco.add(this.recuperarJogador(id));
            }
            return  elenco;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<JogadorModel> recuperarJogadorPelaPosicao(String posicao) {
        String sql = "SELECT ID_JOGADOR, nome FROM Jogador "+
                "WHERE ID_TIME > 0 AND ID_POSICAO = ? ;";
        try {
            List<Integer> posicoes = this.recuperarPosicao(posicao);
            PreparedStatement ps = conexaoBD.prepareStatement(sql);
            List<Integer> resultado = new ArrayList<>();
            List<JogadorModel> elenco = new ArrayList<>();
            for(int id: posicoes){
                ps.setString(1, String.valueOf(id));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if(rs.getMetaData().getColumnCount() != 2){ continue;}
                    int j = rs.getInt(1);
                    resultado.add(j);
                }
            }
            for(int id: resultado){
                elenco.add(this.recuperarJogador(id));
            }
            return  elenco;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> recuperarPosicao (String posicao){
        String sql = "SELECT ID_POSICAO FROM Posicao "+
                "WHERE " + posicao + " = TRUE;";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            while (rs.next()) {
                if(rs.getMetaData().getColumnCount() != 1){ continue;}
                int j = rs.getInt(1);
                resultado.add(j);
            }
            return  resultado;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int inserirTime(TimeModel t){
        String sql = "INSERT INTO Time( nome_time, nome_dono, login, senha) " +
                "VALUES('"+t.getNomeTime()+"','"+t.getNomeDono()+"','"+t.getLogin()+
                "','"+t.getSenha()+
                "')";
        try {
            PreparedStatement ps = conexaoBD.prepareStatement(sql);
            ps.execute();
            //stmt.execute(sql);
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_TIME) AS max_id FROM Time");
            int ID =  retorno.getInt("max_id");
            System.out.println("SUCESSO: inserir Time no SQLite!");
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Time no SQLite!");
            return -1;
        }
    }
    public TimeModel recuperarTime(int ID) {
        TimeModel t = new TimeModel("","","","");
        String sql = "SELECT * FROM Time " +
                "WHERE ID_TIME = " + ID;
        try {
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                t.setIdTime(select.getInt("ID_TIME"));
                t.setNomeTime(select.getString("nome_time"));
                t.setNomeDono(select.getString("nome_dono"));
                t.setLogin(select.getString("login"));
                t.setSenha(select.getString("senha"));
                recuperarElenco(t);
            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperarElenco(TimeModel t) {
        String sql = "SELECT ID_JOGADOR, nome FROM Jogador "+
                "WHERE ID_TIME = " + t.getIdTime() + ";";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<JogadorModel> elenco = new ArrayList<>();
            while (rs.next()) {
                if(rs.getMetaData().getColumnCount() != 2){ continue;}
                int j = rs.getInt(1);
                resultado.add(j);
            }
            for(int id: resultado){
                elenco.add(this.recuperarJogador(id));
            }
            t.setElenco(elenco);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public int inserirTransacao(TransacaoModel t){
        String sql = "INSERT INTO Transacao(ID_TIME_PROPOSTA, ID_TIME_RECEPTOR, JOGADOR_PROPOSTO, JOGADOR_DESEJADO, ACEITA, FINALIZADA) " +
                "VALUES("+t.getIdTimeProposta()+","+t.getIdTimeReceptor()+","+t.getJogadorProposto().getIdJogador()+
                ","+t.getJogadorDesejado().getIdJogador()+","+t.isAceita()+","+t.isFinalizada()+
                ")";
        try {
            PreparedStatement ps = conexaoBD.prepareStatement(sql);
            ps.execute();
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_TRANSACAO) AS max_id FROM Transacao");
            int ID =  retorno.getInt("max_id");
            System.out.println("SUCESSO: inserir Transacao no SQLite!");
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Transacao no SQLite!");
            return -1;
        }
    }

    public TransacaoModel recuperarTransacao(int ID){
        TransacaoModel t = null;
        String sql = "SELECT * FROM Transacao " +
                "WHERE ID_TRANSACAO = " + ID;
        try {
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                int idTimeProposta = select.getInt("ID_TIME_PROPOSTA");
                int idTimeReceptor = select.getInt("ID_TIME_RECEPTOR");
                int jogadorProposto = select.getInt("JOGADOR_PROPOSTO");
                int jogadorDesejado = select.getInt("JOGADOR_DESEJADO");
                boolean finalizada = select.getBoolean("FINALIZADA");
                t = new TransacaoModel(idTimeProposta, idTimeReceptor,this.recuperarJogador(jogadorProposto),this.recuperarJogador(jogadorDesejado));
                t.setFinalizada(finalizada);
                t.setIdTransacao(ID);
            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean alterarTransacao(TransacaoModel t){
        String sql = "UPDATE Transacao "+
                "SET FINALIZADA = " + true + " , " +
                " ACEITA = " + t.isAceita() +
                " WHERE ID_TRANSACAO = "+ t.getIdTransacao() + ";";
        String sqlTroca1 =  "UPDATE Jogador "+
                "SET ID_TIME = " + t.getIdTimeReceptor() +
                " WHERE ID_JOGADOR = "+ t.getJogadorProposto().getIdJogador() + ";";
        String sqlTroca2 =  "UPDATE Jogador "+
                "SET ID_TIME = " + t.getIdTimeProposta() +
                " WHERE ID_JOGADOR = "+ t.getJogadorDesejado().getIdJogador() + ";";
        try {
            boolean retorno = stmt.execute(sql);
            if(t.isFinalizada()){
                return false;
            }
            if(t.isAceita()){
                stmt.execute(sqlTroca1);
                stmt.execute(sqlTroca2);
            }
            System.out.println("SUCESSO: alterar Transação no SQLite!");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public List<TransacaoModel> historicoTransacoes(TimeModel t) {
        String sql = "SELECT ID_TRANSACAO FROM Transacao "+
                "WHERE ID_TIME_RECEPTOR = " + t.getIdTime() + " AND FINALIZADA = FALSE"+
                " ORDER BY ID_TRANSACAO DESC";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<TransacaoModel> historico = new ArrayList<>();
            while (rs.next()) {
                if(rs.getMetaData().getColumnCount() != 1){ continue;}
                int j = rs.getInt(1);
                resultado.add(j);
            }
            for(int id: resultado){
                historico.add(this.recuperarTransacao(id));
            }
            return historico;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TimeModel recuperarTimePorLogin(String login) throws NoSuchAlgorithmException {
        TimeModel t = new TimeModel("","","","");
        String sql = "SELECT * FROM Time " +
                "WHERE login = '" + login + "'";
        try {
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                t.setIdTime(select.getInt("ID_TIME"));
                t.setNomeTime(select.getString("nome_time"));
                t.setNomeDono(select.getString("nome_dono"));
                t.setLogin(select.getString("login"));
                t.setSenha(select.getString("senha"));
            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
