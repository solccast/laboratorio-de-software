package practica7.prueba

import kotlin.concurrent.thread

class ThreadsTeoria {
}

fun main() {
    /*
        Cuando finaliza el for, hay 6 threads
        ejecutándose en paralelo: el thread que
        invocó a la thread(), en nuestro caso el
        main thread y los threads que están
        ejecutando los bloques lambda.
     */
    for (i in 1..5){
        thread (){
            val name="thread_${i}"
            var contador = 10
            for (j in 1..contador){
                println("#${name}: $j")
            }
        }
    }
}