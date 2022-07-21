package main.java;

import main.java.Communication.GrpcServer;
import main.java.Controllers.Persistencia;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) {
        Persistencia persistencia = new Persistencia("dados.db");
        try {
            GrpcServer server = new GrpcServer(persistencia);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}