package Controladores;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private Connection conexaoBD;
    private Statement stmt;

    private String BD;

    public Persistencia(String bd){
        BD = bd;
        this.conectar();
        this.criarTabela();
    }
    private void conectar(){
        Connection con = null;
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
                    " goleiro INTEGER," +
                    " zagueiro INTEGER," +
                    " meio_campo INTEGER," +
                    " atacante INTEGER)";

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
                    " ID_CRIADOR  INTEGER NOT NULL, " +
                    " ID_RECEPTOR INTEGER NOT NULL, " +
                    " GRUPO_CRIADOR INTEGER NOT NULL, " +
                    " GRUPO_RECEPTOR INTEGER NOT NULL, " +
                    " contraproposta INTEGER NOT NULL," +
                    " finalizada INTEGER NOT NULL, " +
                    " FOREIGN KEY (ID_CRIADOR) REFERENCES Time(ID_TIME)," +
                    " FOREIGN KEY (ID_RECEPTOR) REFERENCES Time(ID_TIME)," +
                    " FOREIGN KEY (GRUPO_CRIADOR) REFERENCES Jogador(ID_JOGADOR)" +
                    " FOREIGN KEY (GRUPO_RECEPTOR) REFERENCES Jogador(ID_JOGADOR)" +
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

    public int inserirPontuacao(Pontuacao p){
        String sql = "INSERT INTO Pontuacao(ataque, defesa, fisico, geral) " +
                     "VALUES("+p.getAtaque()+","+p.getDefesa()+","+p.getFisico()+","+p.getGeral()+")";
        try {

            stmt.execute(sql);
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_PONTUACAO) AS max_id FROM Pontuacao");
            int ID =  retorno.getInt("max_id");
            p.setIdPontuacao(ID);
            System.out.println("SUCESSO: inserir Pontuação no SQLite!");
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Pontuação no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public Pontuacao recuperarPontuacao(int ID){
        String sql = "SELECT * FROM Pontuacao " +
                     "WHERE ID_PONTUACAO = " + ID;
        try {
            Pontuacao p = new Pontuacao(0,0,0);
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

    public void alterarPontuacao(Pontuacao p){
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

    public int inserirPosicao(Posicao p){
        String sql = "INSERT INTO Posicao(goleiro, zagueiro, meio_campo, atacante) " +
                "VALUES("+p.isGoleiro()+","+p.isZagueiro()+","+p.isMeioCampista()+","+p.isAtacante()+")";
        try {
            stmt.execute(sql);
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_POSICAO) AS max_id_posicao FROM Posicao");
            int ID =  retorno.getInt("max_id_posicao");
            p.setIdPosicao(ID);
            System.out.println("SUCESSO: inserir Posição no SQLite!");
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Posição no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public Posicao recuperarPosicao(int ID){
        String sql = "SELECT * FROM Posicao " +
                "WHERE ID_POSICAO = " + ID;
        try {
            Posicao p = new Posicao(false,false,false,false);
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                p.setIdPosicao(select.getInt("ID_POSICAO"));
                p.setGoleiro(select.getBoolean("goleiro"));
                p.setZagueiro(select.getBoolean("zagueiro"));
                p.setMeioCampista(select.getBoolean("meio_campo"));
                p.setAtacante(select.getBoolean("atacante"));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarPosicao(Posicao p){
        String sql = "UPDATE Posicao "+
                "SET goleiro = " +p.isGoleiro() +
                ", zagueiro = "+p.isZagueiro() +
                ", meio_campo = "+p.isMeioCampista() +
                ", atacante = "+p.isAtacante() +
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
    public int inserirJogador(Jogador j){
        String sql = "INSERT INTO Jogador( idade, nome, preco, ID_PONTUACAO, ID_POSICAO, ID_TIME) " +
                "VALUES("+j.getIdade()+", ? ,"+j.getPreco()+","+ inserirPontuacao(j.getPontos())+
                ","+inserirPosicao(j.getPosicoes())+","+ j.getIdTime()+
                ")";
        try {
            PreparedStatement ps = conexaoBD.prepareStatement(sql);
            ps.setString(1, j.getNome());
            ps.execute();
            //stmt.execute(sql);
            ResultSet retorno = stmt.executeQuery("SELECT MAX(ID_JOGADOR) AS max_id FROM Jogador");
            int ID =  retorno.getInt("max_id");
            System.out.println("SUCESSO: inserir Jogador no SQLite!");
            return ID;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Jogador no SQLite!");
            return -1;
        }
    }

    public Jogador recuperarJogador(int ID){
        Jogador j = new Jogador("0", 99, new Posicao(false, false, false, false), 0, new Pontuacao(0,0,0), 0);
        String sql = "SELECT nome, idade, preco, ID_PONTUACAO, ID_POSICAO, ID_TIME, ID_JOGADOR FROM Jogador " +
                " WHERE ID_JOGADOR = " + ID + ";";
        try {
            ResultSet select = stmt.executeQuery(sql);
            String nome = select.getString(1);
            int idade = select.getInt(2);
            int idPos = select.getInt(5);
            int preco = select.getInt(3);
            int idPont = select.getInt(4);
            int idTime = select.getInt(6);
            j = new Jogador(nome,idade , recuperarPosicao(idPos), preco , recuperarPontuacao(idPont), idTime);

            j.setIdJogador(ID);

            return j;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Jogador> recuperarJogadorPeloNome(String nome) {
        String sql = "SELECT ID_JOGADOR, nome FROM Jogador "+
                "WHERE ID_TIME > 0 AND nome LIKE '%" + nome + "%';";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<Jogador> elenco = new ArrayList<>();
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

    public List<Jogador> recuperarJogadorPelaPosicao(String posicao) {
        String sql = "SELECT ID_JOGADOR, nome FROM Jogador "+
                "WHERE ID_TIME > 0 AND " + posicao + " = TRUE;";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<Jogador> elenco = new ArrayList<>();
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

    public int inserirTime(Time t){
        System.out.println(t.getSenha());
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
    public Time recuperarTime(int ID) throws NoSuchAlgorithmException {
        Time t = new Time("","","","");
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
            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperarElenco(Time t) {
        String sql = "SELECT ID_JOGADOR, nome FROM Jogador "+
                "WHERE ID_TIME = " + t.getIdTime() + ";";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<Jogador> elenco = new ArrayList<>();
            while (rs.next()) {
                if(rs.getMetaData().getColumnCount() != 2){ continue;}
                int j = rs.getInt(1);
                resultado.add(j);
            }
            for(int id: resultado){
                elenco.add(this.recuperarJogador(id));
            }
            t.carregarElenco(elenco);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int inserirTransacao(Transacao t){
        String sql = "INSERT INTO Transacao(ID_CRIADOR, ID_RECEPTOR, GRUPO_CRIADOR, GRUPO_RECEPTOR, contraproposta, finalizada) " +
                "VALUES("+t.getCriador()+","+t.getReceptor()+","+t.getGrupoCriador().getIdJogador()+
                ","+t.getGrupoReceptor().getIdJogador()+","+t.isContraproposta()+","+t.isFinalizada()+
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

    public Transacao recuperarTransacao(int ID){
        Transacao t = null;
        String sql = "SELECT * FROM Transacao " +
                "WHERE ID_TRANSACAO = " + ID;
        try {
            ResultSet select = stmt.executeQuery(sql);
            if(!select.isClosed()){
                int idCriador = select.getInt("ID_CRIADOR");
                int idReceptor = select.getInt("ID_RECEPTOR");
                int grupoCriador = select.getInt("GRUPO_CRIADOR");
                int grupoReceptor = select.getInt("GRUPO_RECEPTOR");
                boolean finalizada = select.getBoolean("finalizada");
                t = new Transacao(idCriador, idReceptor,this.recuperarJogador(grupoCriador),this.recuperarJogador(grupoReceptor));
                t.setIdTransacao(ID);
            }

            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarTransacao(Transacao t, boolean resposta){
        String sql = "UPDATE Transacao "+
                "SET finalizada = " + resposta +
                " WHERE ID_TRANSACAO = "+ t.getIdTransacao() + ";";
        String sqlTroca1 =  "UPDATE Jogador "+
                "SET ID_TIME = " + t.getReceptor() +
                " WHERE ID_JOGADOR = "+ t.getGrupoCriador().getIdJogador() + ";";
        String sqlTroca2 =  "UPDATE Jogador "+
                "SET ID_TIME = " + t.getCriador() +
                " WHERE ID_JOGADOR = "+ t.getGrupoReceptor().getIdJogador() + ";";
        try {
            stmt.execute(sql);
            boolean retorno = stmt.execute(sql);
            if(resposta){
                stmt.execute(sqlTroca1);
                stmt.execute(sqlTroca2);
            }
            System.out.println("SUCESSO: alterar Transação no SQLite!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar Transação no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public List<Transacao> historicoTransacoes(Time t) {
        String sql = "SELECT ID_TRANSACAO FROM Transacao "+
                "WHERE ID_CRIADOR = " + t.getIdTime() + " OR ID_RECEPTOR = " + t.getIdTime() +
                " ORDER BY ID_TRANSACAO DESC";
        try {
            stmt = conexaoBD.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Integer> resultado = new ArrayList<>();
            List<Transacao> historico = new ArrayList<>();
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

    public Time recuperarTimePorLogin(String login) throws NoSuchAlgorithmException {
        Time t = new Time("","","","");
        String sql = "SELECT * FROM Time " +
                "WHERE login = \'" + login + "\'";
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
