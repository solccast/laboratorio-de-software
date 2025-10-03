package taller

class Rectangulo (var ancho: Double, var alto: Double){ // Constructor primario
    var perimetro = (ancho + alto) * 2
}

class Circulo(var radio: Double)

fun main(){
    val rect = _root_ide_package_.segundo.Rectangulo(5.0, 2.0)
    println("El ancho es ${rect.ancho}")
    println("El perimetro es ${rect.perimetro}")

    /* crea un rectángulo nuevo en la variable rect
    NO es posible con la configuración actual, es necesario cambiar a var para que la variable
    no sea inmutable:
    Use the var keyword to declare variables that can be reassigned.
     */
    var rect2 = _root_ide_package_.segundo.Rectangulo(2.0, 1.0)
    rect2 = _root_ide_package_.segundo.Rectangulo(10.0, 30.0)

    /*
    ¿Se pueden crear objetos de otras clases en el mismo taller.taller.main()?
    ¿Observas alguna diferencia entre el método taller.taller.main() de Java y la función taller.taller.main() de Kotlin?
     */
    val p1 = Circulo(32.0)

}