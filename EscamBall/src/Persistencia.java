import java.sql.*;
import java.sql.Connection;

public class Persistencia {
    private Connection conexaoBD;
    private Statement stmt;

    public Persistencia(String bd){
        try {
            String url = "jdbc:sqlite:./"+bd;
            conexaoBD = DriverManager.getConnection(url);
            System.out.println("Conexao com banco de dados " + bd + " estabelecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
                    " nome_time TEXT NOT NULL UNIQUE," +
                    " nome_dono TEXT NOT NULL," +
                    " login TEXT NOT NULL," +
                    " senha TEXT NOT NULL)";

            String sql_posicao = "CREATE TABLE IF NOT EXISTS Posicao " +
                    "(ID_POSICAO INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " goleiro INTEGER," +
                    " zagueiro INTEGER," +
                    " lateral_esquerdo INTEGER," +
                    " lateral_direito INTEGER," +
                    " volante INTEGER," +
                    " meio_campo INTEGER," +
                    " ponta_esquerda INTEGER," +
                    " ponta_direita INTEGER," +
                    " atacante INTEGER)";

            String sql_jogador = "CREATE TABLE IF NOT EXISTS Jogador " +
                    "(ID_JOGADOR INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " ID_TIME INTEGER NOT NULL, " +
                    " nome TEXT NOT NULL, " +
                    " nome TEXT NOT NULL, " +
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
                    " CRIADOR TEXT NOT NULL, " +
                    " RECEPTOR TEXT NOT NULL, " +
                    " GRUPO_CRIADOR INTEGER NOT NULL, " +
                    " GRUPO_RECEPTOR INTEGER NOT NULL, " +
                    " contraproposta INTEGER NOT NULL," +
                    " finalizada INTEGER NOT NULL, " +
                    " FOREIGN KEY (CRIADOR) REFERENCES Time(nome_time)," +
                    " FOREIGN KEY (RECEPTOR) REFERENCES Time(nome_time)," +
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

    public void inserirPontuacao(Pontuacao p){
        String sql = "INSERT INTO Pontuacao(ataque, defesa, fisico, geral) " +
                     "VALUES("+p.getAtaque()+","+p.getDefesa()+","+p.getFisico()+","+p.getGeral()+")";
        try {
            stmt.execute(sql);
            System.out.println("SUCESSO: inserir Pontuação no SQLite!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Pontuação no SQLite!");
            throw new RuntimeException(e);
        }
    }

    public Pontuacao recuperarPontuacao(long ID){
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

}
