package practica2.ej3;

import java.util.Arrays;
import java.util.List;

public class HashSetAgregadosTest {

    public static void main(String[] args) {

        /*
        ------------- Punto 3a
         */
        HashSetAgregados<String> hashSetAgregados = new HashSetAgregados<String>();

        hashSetAgregados.add("Escrito1");
        hashSetAgregados.addAll(List.of("Escrito2","Escrito3", "Escrito4"));

        System.out.println(hashSetAgregados.getCantidadAgregados());

        /*
        ------------- Punto 3b
         */
        HashSetAgregadosB<String> hashSetAgregadosB = new HashSetAgregadosB<>();
        hashSetAgregadosB.add("Escrito1");
        hashSetAgregadosB.addAll(List.of("Escrito2", "Escrito3", "Escrito4"));
        System.out.println(hashSetAgregadosB.getCantidadAgregados());
    }
}
