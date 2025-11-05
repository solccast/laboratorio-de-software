package sdo_parcial;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        Server s = new Server();

        try {
            s.up(8080);
        } catch (IOException e){
            System.out.println("Error al levantar");
        }

    }
}