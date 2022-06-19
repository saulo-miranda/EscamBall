public class DonoTime {
    private String Nome;
    private Time Time;
    private String Login;
    private String Senha;

    public DonoTime(String nome, Time time, String login, String senha) {
        Nome = nome;
        Time = time;
        Login = login;
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time time) {
        Time = time;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
