package tercerejemplo

class Rectangulo(var ancho: Double, var alto: Double) {
    var perimetro = (ancho + alto) * 2 //Esta propiedad se calcula UNA sola vez porque se actualizan una vez CREADAS. Entonces, si seteamos las variables con otros valores estas permaneceran con un valor fijo.

    /*
    Los bloques init son bloques de inicialización.
    Se ejecutan automáticamente cuando se crea un objeto de la clase.
    Se pueden tener varios bloques init y se ejecutan en el orden en que
    aparecen dentro de la clase.
     */
    init {
        println ("El ancho del Rectangulo es $ancho")
    }
    init {
        println ("El alto del Rectangulo es $alto")
    }
    init {
        println ("El perimetro del Rectangulo es $perimetro")
    }

    var area = ancho * alto
    init {
        println ("El area del Rectangulo es $area")
    }
}
fun main(args: Array<String>) {
    val ancho_local = args[0].toDouble();
    val alto_local = args[1].toDouble();
    val rect = Rectangulo(ancho_local, alto_local)
}