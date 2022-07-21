package main.java.Communication;

import main.java.Controllers.Persistencia;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class GrpcServer  {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());
    private Persistencia persistencia;
    public GrpcServer(Persistencia persistencia) throws IOException, InterruptedException {
        Server server = NettyServerBuilder.forPort(3403).addService(new EscamballService(persistencia)).build();
        server.start();
        logger.info("Serve started on " + server.getPort());
        server.awaitTermination();
    }

}