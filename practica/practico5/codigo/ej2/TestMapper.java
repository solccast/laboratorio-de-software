package practica5.ej2;

import java.nio.file.Path;

public class TestMapper {
    public static void main(String[] args) {
        Mapeado map = new Mapeado();
        var ruta = Mapper.guardar(map, Path.of("salida"));
        System.out.println("Guardado en: " +
                ruta.toAbsolutePath());

        Persona p = new Persona("Juan",30,"Perez");
        var ruta2 = Mapper.guardar(p, Path.of("salida"));
        System.out.println("Guardado en: "
                            + ruta2.toAbsolutePath());
    }
}
