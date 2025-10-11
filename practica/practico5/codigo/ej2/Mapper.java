package practica5.ej2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static Path guardar(Object bean, Path directorioDestino){
        //Uso de reflection
        Class<?> clazz = bean.getClass();
        String nombreArchivo = resolverNombre(clazz);
        Path destino = directorioDestino.resolve(nombreArchivo);

        try{
            Files.createDirectories(directorioDestino);
            List<String> lineas = new ArrayList<>();
            lineas.add("<nombreClase>"
                    +clazz.getName()
                    +"</nombreClase> " +
                    "\n");
            //Agarramos los datos de los campos
            agregarCampos(lineas, clazz, bean);

            Files.write(destino, lineas, StandardCharsets.UTF_8);
            return destino;
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void agregarCampos(List<String> lineas, Class<?> clazz, Object bean) throws IllegalAccessException {
        //Tomamos las anotaciones
        Class <? extends Annotation> annotation = AlmacenarAtributo.class;
        List<Field> fields = List.of(clazz.getDeclaredFields());
        for (Field f : fields){
            if (f.isAnnotationPresent(annotation)){
                lineas.add("<nombreAtributo>"
                        +f.getName()
                        + "</nombreAtributo>");
                f.setAccessible(true);
                Object v = f.get(bean);
                lineas.add("<valorAtributo>" +
                        v.toString() + "</valorAtributo>");
            }
        }
    }

    public static String resolverNombre(Class<?> clazz){
        //Usamos la anotación que se almacenó
        Archivo meta = clazz.getAnnotation(Archivo.class); //Parte de la API reflection

        if (meta != null){
            String name = meta.name().trim();
            if (!name.isEmpty()) return name;
        }
        return clazz.getSimpleName()+".txt";
    }

}
