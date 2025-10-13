package practica5.ej3;

@Servidor
public class Server {

    public Server(){}

    @Invocar
    public void escuchando(){
        System.out.println("Escuchando...");
    }

    @Invocar
    public String respuesta(){
        System.out.println("Segundo método invocado");
        return "Esta es una respuesta desde server";
    }

    public void no_debe_verse(){
        System.out.println("Si este mensaje se ve es porque está mal programado xd");
    }
}
