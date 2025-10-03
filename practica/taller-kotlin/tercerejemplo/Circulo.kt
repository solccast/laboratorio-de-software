package tercerejemplo

/*
CONSTRUCTORES
 */
class Circulo {
    var radio: Double

    constructor(radio: Double){
        this.radio = radio
    }
    constructor(){
        this.radio = 0.2
    }
}

class CirculoDos(radio: Double)
/*
Este tipo de constructor no puede contener código de inicialización. Si es necesario definirlo, se usan los bloques
de inicialización prefijados con la palabra clave 'init'
 */

fun main(){
    val c1 = Circulo(20.0)
    val c2 = Circulo()
    val c3 = Circulo(radio = 4.0)
    val c4 = CirculoDos(20.0)
}