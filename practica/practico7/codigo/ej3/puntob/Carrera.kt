package practica7.ej3.puntob

import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import kotlin.random.Random

val objetivo: Int = 10
var ganador: String = ""
var hayGanador: Boolean = false
val lock = Any()

class Participante(val name: String, var actual: Int = 0): Callable<String>{

    fun run() {
        while (actual < objetivo){
            actual++
            println("${this.name}: Actualmente en el metro: ${actual}")

            if (Random.nextInt(100) < 10) { // 10% de chance
                throw AbandonoException("[${this.name}]: Me rindo :(")
            }
        }
        synchronized(lock){
            if (!hayGanador){
                hayGanador = true
                ganador = this.name
            }
        }
    }

    override fun call(): String {
        this.run()
        return "[${this.name}]: Finalizado"

    }
}

fun main(args: Array<String>) {
    val executor = Executors.newFixedThreadPool(5)
    val p1 = Participante("P1")
    val p2 = Participante("P2")
    val p3 = Participante("P3")
    val p4 = Participante("P4")
    val p5 = Participante("P5")

    val participantes: Array<Participante> = arrayOf(p1, p2, p3, p4, p5)

    val futuros: List<Future<String>> = participantes.map { p -> executor.submit (p)}
    executor.shutdown()

    for (f in futuros){
        try {
            println(f.get())
        } catch (e0: ExecutionException){
            println("atrapado") //La excepcio´n se enmascara por eso nunca toma el catch de AbandonoException
        } catch (e: AbandonoException){
            println("Ups: ${e.message}")
        } catch (e2: Exception){
            println("asdfsfs")
        }

    }

    println("GANADOR: ${ganador}")
}