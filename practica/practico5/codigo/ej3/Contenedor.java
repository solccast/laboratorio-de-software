package practica5.ej3;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Contenedor {

    public Contenedor(){}

    public static void procesarServidor(Object object){
        Class<?> clazz = object.getClass();

        //Vamos a tomar la anotacion
        Servidor servidor_anotacion = clazz.getAnnotation(Servidor.class);
        if (servidor_anotacion == null){
            throw new RuntimeException("La clase no posee la anotación correspondiente");
        }

        String direccion = servidor_anotacion.direccion();
        int puerto = servidor_anotacion.puerto();
        String archivo = servidor_anotacion.file();

        //Métodos a invocar
        List<Method> metodos = obtenerMetodos(clazz);

        try {
            levantarServidor(direccion, puerto, archivo, metodos, object);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static List<Method> obtenerMetodos(Class<?> clazz){
        List<Method> list = List.of(clazz.getDeclaredMethods());
        List<Method> metodos_a_invocar = new ArrayList<>();
        for (Method m: list){
            if (m.isAnnotationPresent(Invocar.class)){
                metodos_a_invocar.add(m);
            }
        }
        return metodos_a_invocar;
    }

    public static void levantarServidor(String direccion, int puerto, String archivo, List<Method> metodos, Object obj)
            throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(puerto), 0);
        server.createContext("/", new ServerHandler(archivo, metodos, obj));
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado en http://" + direccion + ":" + puerto);
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            procesarServidor(server);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
