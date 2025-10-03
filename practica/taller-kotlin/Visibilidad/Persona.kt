package Visibilidad

class Persona constructor(val nombre: String, var edad: Int) { //Persona es posible usarse desde cualquier parte del proyecto
    var int = 10 // Público por default
    fun display(){ // Público por default
        println("La edad de $nombre es $edad")
    }
}

fun main(){
    val persona = Persona("Charly", 70)
    persona.display()
    println("${persona.int}")
}