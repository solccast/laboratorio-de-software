package implementacion;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.List;

public class ProcesadorDeAnotaciones {

    public static void procesarConfiguradorSimulacion(Circuito circuito, List<Auto> autos, Simulacion simulacion)
            throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        Class<?> clazz_auto = Class.forName("implementacion.Auto");
        Field longitudPista = clazz_auto.getDeclaredField("longitudPista");
        Field cantVueltas = clazz_auto.getDeclaredField("cantVueltas");
        longitudPista.setAccessible(true);
        cantVueltas.setAccessible(true);
        Class<?> clazz_circuito = Class.forName("implementacion.Circuito");
        ConfiguradorSimulacion configurador = clazz_circuito.getAnnotation(ConfiguradorSimulacion.class);

        for (Auto auto: autos){
            longitudPista.setInt(auto, configurador.longitudPista());
            cantVueltas.setInt(auto, configurador.vueltas());
        }

        Class<?> sim_class = simulacion.getClass();
        Field CampoCapacidadPista = sim_class.getDeclaredField("capacidadPista");
        CampoCapacidadPista.setAccessible(true);
        CampoCapacidadPista.setInt(simulacion, configurador.capacidadPista());

    }

}
