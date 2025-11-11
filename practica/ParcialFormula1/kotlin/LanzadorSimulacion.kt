package org.example

import implementacion.Auto
import implementacion.Circuito
import implementacion.Simulacion
import java.util.concurrent.Executors

class LanzadorSimulacion {
    fun main(){
        val pilotos = listOf("Stephane Peterhansel", "Franco Colapinto", "Fernando Alonso", "Marx Verstappen", "Checo Perez", "Charles Leclerc")
        val cantPilotos = pilotos.size
        //val capacidadPista = 6 // Si la capacidad es mayor a la cantidad de pilotos la tabla final se ve correctamente
        val capacidadPista = 3 // La tabla final no es que se vea desordenada sino que a medida que los hilos van terminando, dan cupo al otro piloto
        var circuito = Circuito()
        val simulacion: Simulacion = Simulacion.prepararSimulacion( circuito, cantPilotos, pilotos);
        val autos = simulacion.getAutos()

        val exec = Executors.newFixedThreadPool(capacidadPista);
        for (auto in autos){
            exec.execute { auto.run() }
        }

        exec.shutdown();
    }
}

fun main() {
    val lanzador = LanzadorSimulacion()
    lanzador.main()
}