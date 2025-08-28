package practica1;

public class Logger {
    private static Logger l; // Las variables estáticas se comparten entre todas las instancias de una clase y pertenecen a la clase misma, no a un objeto.

    private Logger(){}

    static Logger getInstance(){
        if (l == null){
            l = new Logger();
        }
        return l;
    }

    public void logInfo(String mensaje){
        System.out.println("[INFO]: " + mensaje);
    }

    public void logWarning(String mensaje){
        System.out.println("[WARNING]: " + mensaje);
    }

    public void logError(String mensaje){
        System.out.println("[ERROR]: "+ mensaje);
    }

}
