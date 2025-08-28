package practica1;

public class TestLogger {
    public static void main(String[] args) {
        /*
        Acá se rompe esto porque logger tiene acceso privado para el constructor
        Logger l = new Logger();

         */

        Logger l = Logger.getInstance();
        l.logInfo("lorem ipsum");

        Logger l2 = Logger.getInstance();
        System.out.println(l == l2);
    }
}
