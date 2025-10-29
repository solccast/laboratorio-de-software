package practica7.prueba

import java.util.concurrent.Executors

/*
‒Los EJECUTORES proveen una capa de indirección entre un cliente y la ejecución de una tarea. Es
un objeto intermedio que ejecuta la tarea, desligando al cliente de la ejecución de la misma.
‒Los EJECUTORES son objetos que encapsulan la creación y administración de threads,
permitiendo desacoplar la tarea concurrente del mecanismo de ejecución. Entre sus
responsabilidades están la creación, el uso y el scheduling de threads.
-Un ejecutor es un objeto que implementa la interface Executor
-En lugar de crear un nuevo hilo cada vez, se reusan hilos del pool para ejecutar tareas.
 */
class EjecutoresTeoria {

}

fun main(){
    val executor = Executors.newFixedThreadPool(5) //Mantiene 5 hilos, listos para ejecutar tareas.

    for (i in 1..5){
            executor.execute { //La tarea se asigna a uno de los hilos disponibles.
            val name = "thread_${i}"
            var contador = 10
            for (j in 1..contador){
                println("#${name}: $j")
            }
        }
    }

    println("fuera del for")
    executor.shutdown()
}