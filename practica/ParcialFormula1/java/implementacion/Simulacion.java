package implementacion;

import java.util.List;

public class Simulacion {
    private List<Auto> autos;
    private int capacidadPista;

    private Simulacion(){}

    public static Simulacion prepararSimulacion(Circuito unCircuito,int cantidadAutos, List<String> pilotos){
        Simulacion s = new Simulacion();
        s.setAutos(unCircuito.iniciarCircuito(cantidadAutos, pilotos));
        try{
            ProcesadorDeAnotaciones.procesarConfiguradorSimulacion(unCircuito, s.getAutos(), s);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return s;
    }

    private void setAutos(List<Auto> autos){
        this.autos = autos;
    }


    public List<Auto> getAutos(){
        return this.autos;
    }
}