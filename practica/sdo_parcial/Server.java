package sdo_parcial;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {

    public Server(){}

    public void up(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api", new MyHandler());
        server.setExecutor(Executors.newFixedThreadPool(2));
        server.start();
        System.out.println("Servidor levantado en: "+port);
    }
}
