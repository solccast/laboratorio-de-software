# Laboratorio de Software - Práctica 5

| Temas |
| -- |
| - Conceptos y uso de anotaciones|
| - Definición de anotaciones |

1. Analice qué ocurre con la siguiente clase cuando se compila: 
```java
public class TestSobreescritura {
    @Override
    public String toString(){
        return super.toString() + "Testeando: 'Override'";
    }
}

```
a) ¿Qué ocurre cuando se ejecuta `TestAnotaciones`?
Nada, no lanza ninguna alerta, compila y ejecuta con éxito. 

b) ¿Qué ocurre si se elimina `@SuppressWarnings({"deprecation"})`? ¿el resultado de la ejecución es el mismo?
Sí, el resultado de la ejecución es el mismo sin embargo, desde la IDE se nos indica que la función utilizada hay que reemplazarla porque ya se encuentra deprecada desde donde se la hace uso. 
Al momento de compilar nos sale la siguiente alerta: 
`java: hacer() in practica5.ej1.TestDeprecated has been deprecated`

c) ¿Cuál es la diferencia entre anotar el método testarYa() y anotar la clase TestAnotaciones?

```java
public class TestAnotaciones {
    public static void main(String[] args) throws Exception{
        new TestAnotaciones().testearYa();
    }

    @SuppressWarnings({"deprecation"})
    public void testearYa(){
        TestDeprecated t2 = new TestDeprecated();
        t2.hacer();
    }
}

public class TestDeprecated {
    @Deprecated
    public void hacer(){
        System.out.println("Testeando: 'Deprecated'");
    }
}
```

En caso de usar la anotación en la clase si tiene más _warnings_ en otros métodos, serán ignorados por el compilador pero en el caso actual provisto ignora sólo las que están definidas en el método. 


2. Implementar una clase que mapee un objeto Bean a un archivo del filesystem y almacene en el archivo:
    a. El nombre de la clase. 
    b. Los nombres de los atributos y el contenido de los mismos. 

    Las anotaciones que entiende son las siguientes:
    - `Archivo(name="nombre.extension")` -- Indica que la información se almacenará en el archivo nombre.extensión. Si no se explicita un nombre, se utiliza el nombre de la clase. 
    - `AlmacenarAtributo` -- Denota que el nombre del atributo que está a continuación de la anotación se debe almacenar en el archivo. 

    Por ejemplo, dada la siguiente clase:
    ```java
    @Archivo(nombre="Archivomapeado.txt")
    public class Mapeado{

        @AlmacenarAtributo
        private String valor = "Default1";
        @AlmacenarAtributo
        private Integer valor2=20;
        @AlmacenarAtributo
        private Float valor3=30.20f;
        private Float valor4=30.20f;
        //Metodos getters y setters
    }

    ```
    La salida en el archivo `Archivomapeado.txt` sería:
    ```java
    <nombreClase>Mapeado</nombreClase>
    <nombreAtributo>valor</nombreAtributo>
    <nombreValor>Default1</nombrenombreValor>
    <nombreAtributo>valor2</nombreAtributo>
    <nombreValor>20</nombrenombreValor>
    <nombreAtributo>valor3</nombreAtributo>
    <nombreValor>30.2</nombrenombreValor>

    ```

> Me gustó esta documentación, es clara: https://www.oracle.com/technical-resources/articles/java/javareflection.html

3. Implementar el siguiente ejercicio:
    a. Definir la anotación `RUNTIME` llamada `@Servidor` que se utiliza para anotar una clase que funcionará como un servidor HTTP. Esta anotación debe poseer los siguientes atributos:
    - dirección: ip a la cual se conectarán los clientes.
    - puerto: donde se esperan las conexiones de los clientes.
    - archivo: archivo en el que se guardará la información del login. 
    b. Definir la anotación `RUNTIME` llamada `@Invocar` que se utiliza para marcar el o los métodos de clase que deben ser invocados cuando un cliente se conecta al servidor. 
    c. Utilice las anotaciones previamente definidas para anotar una clase cualquiera. 
    d. Implementar una clase llamada `Contenedor`que procese la clase anotada para escuchar peticiones de red en la IP y puerto especificados y luego delegar la atención de las mismas en los métodos de la clase anotada. La clase `Contenedor` al recibir una petición deberá realizar dos tareas:
        - Loguear Fecha, Hora e IP del cliente en un archivo de texto cuyo nombre se indicó en la anotación `@Servidor`
        - Invocar a todos los métodos que fueron anotados con la anotación `@Invocar`.
    e. Pruebe el servidor HTTP creado en los incisos anterior con un navegador de Internet. 

Faltan muchos try, faltan muchos catch, en su momento lo analizaré (?)

--- 

# Sobre JavaNet 

## Crear un servidor simple: 
```java
HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
server.createContext("/applications/myapp", new MyHandler());
server.setExecutor(null); // Usa un executor por defecto (maneja 1 petición a la vez)
server.start();
```

## Implementar un handler
Cada handler atiende un contexto distinto: `/api`, `/login`, `/` 
HttpExchange encapsula tanto el request como la response.

```java
class MyHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        InputStream is = t.getRequestBody(); // Lee el request
        is.read(); // se puede procesar el cuerpo

        String response = "Esta es la respuesta";
        t.sendResponseHeaders(200, response.length());

        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close(); // 🔹 Importante: cierra el stream para finalizar la respuesta
    }
}
```

## Ejmplo de cliente
```java
URL url = new URL("http://www.twitter.com");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setReadTimeout(5000);
conn.addRequestProperty("User-Agent", "Mozilla");

int status = conn.getResponseCode();
if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM) {
    String newUrl = conn.getHeaderField("Location");
    conn = (HttpURLConnection) new URL(newUrl).openConnection();
}

BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line;
StringBuilder html = new StringBuilder();
while ((line = in.readLine()) != null) {
    html.append(line);
}
in.close();

System.out.println("Contenido URL:\n" + html);

```