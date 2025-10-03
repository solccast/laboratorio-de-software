package clasesyherencia

interface Vehiculo {
    val plazas : Int // Esta es la propiedad abstracta pues no tiene inicialización ni getter. TODA clase que IMPLEMENTE esta interafaz DEBE proveerle un valor.
    val motor : String // Propiedad IMPLEMENTADA. Porque ya tiene implementación del getter. Significa que todas las clases que implementen Vehiculo verán motor = "Naftero" a menos que lo sobreescriban.
        get() = "Naftero"
    fun arrancar() //Abstractos
    fun parar() // Abstractos
    fun motor()  // Implementación default
    {
        println("Este metodo es default para la interface")
    }
}

class Avion: Vehiculo {
    override val plazas = 10
    override fun arrancar()
    {
        println("[Avion] Arrancando...")
    }

    override fun parar()
    {
        println("[Avion] Parando")
    }

}

class Barco: Vehiculo{
    override val plazas = 30
    override fun arrancar()
    {
        println("[Barco] Arrancando...")
    }

    override fun parar()
    {
        println("[Barco] Parando")
    }
}

fun main()
{
    val avion = Avion()
    avion.arrancar()
    avion.parar()
    avion.motor()
    print(avion.motor)
    val barco = Barco()
    barco.arrancar()
    barco.parar()
    barco.motor()
    print(barco.motor)
}