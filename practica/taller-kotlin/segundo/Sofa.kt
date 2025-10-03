package segundo

class Sofa {
    val material: String = "terciopelo"
}

fun main(){
    /*
    Declaramos al objeto sofa como var:
    ¿es posible modificar su estado? ¿por qué?
    - No, no es posible porque está declarado como val (inmutable)
    por más que la variable que contenga a Sofa esté declarado como
    var.
     */
    var sofa = Sofa()
    println("El sofa es ${sofa.material}")
    //sofa.material="lana"
    println("El sofa es ${sofa.material}")
    sofa = Sofa()
}