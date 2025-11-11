package implementacion;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Auto implements Runnable {
    private String piloto;
    private int longitudPista; //Uso esta nueva variable para que el auto conozca la longitud y en run pueda hacerse el control sino tendría que modificar la firma run()
    private int cantVueltas;

    public Auto(){
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }


    public void run() {
        int distancia = 0;
        try{
            long init = System.currentTimeMillis() / 1000;
            for (int i = 0; i < cantVueltas; i++){
                while (distancia < longitudPista){
                    try {
                        int value = ThreadLocalRandom.current().nextInt(10);
                        TimeUnit.SECONDS.sleep(value);
                    } catch (InterruptedException e) {
                        System.out.println("Error al avanzar");
                    }
                    if (ThreadLocalRandom.current().nextDouble() <= 0.10){
                        throw new NeumaticoPinchado("Se pincho mi neumatico");
                    } else if (ThreadLocalRandom.current().nextDouble() <= 0.10){
                        throw new MotorDescompuesto("Se descompuso el motor");
                    } else distancia+=10;
                }

            }

            long end = System.currentTimeMillis() /1000;
            long total = end - init;
            System.out.println("["+getPiloto()+"]: Finaliza carrera en "+ total + " segundos");
        } catch (NeumaticoPinchado | MotorDescompuesto e){
            System.out.println("["+this.piloto+"]: Abandona");
        }

    }
}
