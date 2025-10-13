package practica6.ej4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.nio.file.FileSystemAlreadyExistsException;

public class CClase extends APrueba implements IPrueba{
    @Override
    public void prueba() {

    }

    @Override
    public void evento() throws ArithmeticException {}

    public void evento(String nombre) throws IOException{}

    void something() throws RuntimeException {
        System.out.println("Subclase");
        throw new RuntimeException();
    }

    @Override
    void jugada() throws Mano{}

    void jugando(){}

    public static void main(String[] args) {
        CClase prueba = new CClase();
        //prueba.something();

        try {
            prueba.jugando();
            throw new EquipoIncompleto("prueba");
        } catch (EquipoIncompleto e) {
        }catch (FutbolException e){
        }
    }
}
