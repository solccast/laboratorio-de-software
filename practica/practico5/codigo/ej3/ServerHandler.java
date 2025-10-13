package practica5.ej3;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class ServerHandler implements HttpHandler {
    private String archivo;
    private Object obj;
    private List<Method> metodos;

    public ServerHandler(String archivo, List<Method> metodos, Object obj){
        this.archivo = archivo;
        this.obj = obj;
        this.metodos = metodos;
    }

    @Override
    public void handle(HttpExchange request) throws IOException {
        InputStream is = request.getRequestBody();
        is.read(); // .. lee el request body
        loggear(request);
        //Invocación a los métodos
        for (Method m: metodos){
            try {
                m.setAccessible(true);
                m.invoke(obj);
            } catch (InvocationTargetException | IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        this.enviarRespuesta(request);
    }

    public void loggear(HttpExchange request) throws IOException {
        String ip = request.getRemoteAddress().getAddress().getHostAddress();
        String fechahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String linea = fechahora + " - " + ip + System.lineSeparator();
        Files.writeString(
                Paths.get(this.archivo),
                linea,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND
        );
    }

    public void enviarRespuesta(HttpExchange request) throws IOException {
        String response = "Esta es la respuesta";
        request.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
        request.sendResponseHeaders(200, response.length());
        OutputStream os = request.getResponseBody();
        os.write(response.getBytes());
        os.flush();
        os.close();
    }
}