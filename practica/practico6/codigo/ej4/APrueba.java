package practica6.ej4;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

class APrueba {
    void something(){
        System.out.println("Desde abstracto");
    }

    void evento() throws ArithmeticException{}
    void jugada() throws EquipoIncompleto, Falta{}
}
