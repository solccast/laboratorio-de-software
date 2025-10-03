package clasesyherencia

open class Figura

class Rectangulo(var ancho: Double, var alto: Double): Figura() {
    var perimetro = (ancho + alto) * 2
}