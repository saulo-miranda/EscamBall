package Controladores;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login implements Serializable {
    private final String Login;
    private final String Senha;

    public Login(String login, String senha) {
        Login = login;
        try {
            Senha = geraHashSenha(senha);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String geraHashSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }


    public String getLogin() {
        return Login;
    }
    public String getSenha(){
        return Senha;
    }
}
