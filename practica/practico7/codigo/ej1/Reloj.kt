package practica7.ej1

import java.time.LocalTime
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

class Reloj {
}

fun main(args: Array<String>) {
    val executor = Executors.newSingleThreadExecutor()

    val future= executor.submit {
        for (i in 1..30) {
            println("Tiempo actual es: ${LocalTime.now()}")
            TimeUnit.SECONDS.sleep(1)
        }
    }
    println("En main")
    TimeUnit.SECONDS.sleep(10)
    future.cancel(true)
    executor.shutdown()
    println("Off")

    /*
    --------------------------
     */
    val tarea = Runnable{
        println("Hora: ${LocalTime.now()}")
    }
    val executorSchedule = Executors.newScheduledThreadPool(1)
    executorSchedule.scheduleAtFixedRate(tarea, 0,1,TimeUnit.SECONDS)

    println("Fuera del thread")
    TimeUnit.SECONDS.sleep(5)
    executorSchedule.shutdown()
    println("Off")

    /*

     */

}