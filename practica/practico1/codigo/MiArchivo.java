package practica1;

import java.io.File;

public class MiArchivo extends File {
    public MiArchivo(String text){
        //Una solución sería usar un constructor a elección de File y agregar parámetro necesario
        super(text);
        System.out.println("Mi archivo instanciado");
    }

    public MiArchivo(){
        // Poner algún valor por defecto para mantener sin parámetros este constructor
        super("Dirección");
        System.out.println("Mi archivo instanciado");
    }
}
