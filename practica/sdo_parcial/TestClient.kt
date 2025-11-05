package sdo_parcial

import java.util.concurrent.Executors

class TestClient {
}

fun main() {
    val client = Client("http://localhost:8080/api")
    val exec = Executors.newFixedThreadPool(5);
    for (i in 1..20){
        exec.execute {
            client.solicitud()
        }
    }
}