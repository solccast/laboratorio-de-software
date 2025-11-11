package implementacion;

import java.util.ArrayList;
import java.util.List;

@ConfiguradorSimulacion(
        vueltas=4,
        longitudPista=200,
        capacidadPista=5
)
public class Circuito {

    public Circuito(){}

    public List<Auto> iniciarCircuito(int cantAutos, List<String> pilotos){
        //retorna una lista de autos de tamaño cantAutos
        List<Auto> autos = new ArrayList<>();
        for (String piloto: pilotos){
            Auto a = new Auto();
            a.setPiloto(piloto);
            autos.add(a);
        }
        return autos;
    }
}
