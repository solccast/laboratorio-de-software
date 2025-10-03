package segundo

class Rectangulo(var ancho: Double, var alto: Double) {
    var perimetro = (ancho + alto) * 2
}
fun main(args: Array<String>) {
    val ancho_local = args[0].toDouble();
    val alto_local = args[1].toDouble();
    val rect = _root_ide_package_.taller.Rectangulo(ancho_local, alto_local)
    println("El perímetro es ${rect.perimetro}")
}
