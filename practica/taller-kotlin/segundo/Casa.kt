package segundo

class Casa {
    var sofa: String = ""
}

fun main(){
    /*
    Declaramos el objeto casa como val:
        ¿es posible modificar su estado? ¿por qué?
        - Sí, porque la variable sofá es posible usarlo porque
        está declarado como `var`.
     */

    val casa = Casa()
    casa.sofa="de tela"
    println("El sofa es ${casa.sofa}")
    casa.sofa="de cuero sintético"
    println("El sofa es ${casa.sofa} ")
}