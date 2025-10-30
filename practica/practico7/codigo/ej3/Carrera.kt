package practica7.ej3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

val objetivo: Int = 10
var ganador: String = ""
var hayGanador: Boolean = false
val lock = Any()

class Participante(val name: String, var actual: Int = 0){ //Otra forma es que esta clase implemente Runnable

    fun correr() {
        while (actual < objetivo){
            actual++
            println("${this.name}: Actualmente en el metro: ${actual}")
        }
        synchronized(lock){
            if (!hayGanador){
                hayGanador = true
                ganador = this.name
            }
        }
        println("[END] ${this.name}")
    }
}

fun main(args: Array<String>) {
    val executor = Executors.newFixedThreadPool(2)
    val p1 = Participante("P1")
    val p2 = Participante("P2")
    val p3 = Participante("P3")
    val p4 = Participante("P4")
    val p5 = Participante("P5")

    val participantes: Array<Participante> = arrayOf(p1, p2, p3, p4, p5)
    for (p in participantes){
        executor.execute { p.correr() } // lo que siempre recibe el execute es un runnable
    }
    executor.shutdown()

    executor.awaitTermination(1, TimeUnit.MINUTES) // esperar a que terminen

    println("GANADOR: ${ganador}")
}