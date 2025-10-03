package tercerejemplo

fun main(){
    /*
    Se hace uso del operador elvis en el que:
    Se retorna el valor de la expresión de la izquierda del operador
    y el de la derecha en otro caso.
     */
    val a = "Kotlin"
    var b : String? = null //Apto nulleable
    b = "String"
    val a_length = a?.length?: -1
    b = null
    val b_length = b?.length?: -1
    println(a_length)
    println(b_length)

    /*-------------------
   Tarea: que imprima los elementos no nulos de la lista
   -------------------- */
    val listaConNulls: List<String?> = listOf("Kotlin", null, null, "Java")
    for (string in listaConNulls) {
        println(string?:"Vacío")
        println(string?:-1)
        if (string != null){
            println(string)
        }
    }
}