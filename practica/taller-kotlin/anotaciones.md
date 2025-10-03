> Taller: https://sites.google.com/view/clauq/home

### 1. Clase vacía

```kotlin
class Persona
```

Esto declara una clase llamada `Persona` sin propiedades ni métodos.

---

### 2. Clase con constructor primario

```kotlin
class Persona(val nombre: String, var edad: Int)
```

* `val` → propiedad de solo lectura (similar a `final` en Java).
* `var` → propiedad mutable.
* El constructor primario va en la misma línea que el nombre de la clase.

Uso:

```kotlin
val p = Persona("Ana", 25)
println(p.nombre)  // Ana
p.edad = 26        // permitido porque es var
```

---

### 3. Clase con cuerpo y métodos

```kotlin
class Persona(val nombre: String, var edad: Int) {
    fun saludar() {
        println("Hola, soy $nombre y tengo $edad años")
    }
}
```

---

### 4. Constructores secundarios

```kotlin
class Persona {
    var nombre: String
    var edad: Int

    constructor(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }
}
```

> Se usa solo si necesitas lógica extra al construir el objeto. Normalmente alcanza con el constructor primario.

---

### 5. Clases `data`

Muy usadas en Kotlin para representar entidades con datos:

```kotlin
data class Persona(val nombre: String, val edad: Int)
```

Genera automáticamente `toString()`, `equals()`, `hashCode()` y `copy()`.

---
El método taller.taller.main no corresponde a ninguna clase.

---

## Configuración de los parámetros en IntelliJ
- Arriba a la derecha, se busca el menú desplegable **Run/Debug > Configurations**.
- Una vez ahí, en **Edit Configurations** se ingresa, y se modifica **Program Arguments**.
- Los parámetros se escriben separados por espacio: `hola mundo 123`

---
## Síntesis constructores primarios 
Los constructores primarios forman parte del encabezado de la clase y se ubican después del nombre de la clase y de los parámetros opcionales (anotaciones y modificadores de visibilidad). Por defecto son **públicos**. 
- Se declaran con la palabra clave **constructor**.
```kotlin
class Persona constructor(nombre: String){
    /*       
     */
}
```

--- 
## Sobre la nulabilidad en Kotlin
En Kotlin, por defecto todas las variables son no-nulas. 
Al declarar ``var a: String = null`` no compila. 
Si se busca que la variable pueda tomar el valor null se tiene que marcar explícitamente como _nullable_ usando `?`, entonces:
```kotlin
fun main() {
    var a: String? = "abc"  // puede ser String o null
    a = null                // ahora sí permitido
    println(a)
}
```
A diferencia de Java en la que cualquier referencia puede ser null.
Las variables son no nuleables garantiza que los errores no compilen a menos que se declaren explícitamente como null.
Entonces: 
- Menos errores en runtime -> se atrapan en tiempo de compilación
- Mayor expresividad -> el tipo te dice si una variable puede ser nula o no. 
- Código más seguro y claro -> cuando algo es `String?` el compilador te obliga a tratar el caso nulo con operadores como ?. o ?: 

### Encadenamiento de invocaciones seguras 
Eva es una programadora que puede estar asignada a un proyecto o no. A su vez ese proyecto, puede tener un líder del proyecto. ¿Cómo se obtiene el nombre del líder del proyecto al que está asignada Eva(si existe)?
`Eva?.proyecto?.lider?.nombre` -> retorna null si algunas de las propiedades de la cadena es `null`. 

## Casting 
- Uso de `as` (casting inseguro): intenta convertir un objeto a un tipo específico. Si el objeto no es del tipo esperado, lanza una excepción.
- Uso de `as?` (casting seguro): intenta convertir un objeto a un tipo, si no se puede, devuelve null en lugar de tirar una excepción. 

# Herencia
Se debe tener en cuenta que todas las clases son `final` por defecto. En caso de querer permitir la herencia, se debe declarar como `open` (al contrario que Java en el que se marca explícitamente la restricción de sí se puede heredar o no)

## 🔹 1. Clases son `final` por defecto

En **Java**, todas las clases pueden heredarse salvo que estén marcadas como `final`.
En **Kotlin**, es al revés:

```kotlin
open class Animal(val nombre: String) {
    open fun hacerSonido() {
        println("Sonido genérico")
    }
}
```

---

## 🔹 2. Uso de `:`

Se usa `:` para indicar herencia (igual que interfaces).

```kotlin
class Perro(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: ¡Guau!")
    }
}
```

---

## 🔹 3. Sobreescritura (`override`)

* Si un método puede ser sobreescrito, debe estar marcado como `open`.
* En la subclase, se usa `override`.

> Se requieren modificadores explícitos para indicar que un miembro puede ser sobreescrito. Si se quiere prohibir la reescritura, es necesario declararlo final. 

```kotlin
fun main() {
    val perro = Perro("Firulais")
    perro.hacerSonido()  // Firulais dice: ¡Guau!
}
```
> Si la clase derivada tiene un constructor primario, la clase base debe ser inicializada con dicho constructor.
```kotlin
open class Base (val p: Int)

class Derivada (val p: Int): Base(p)
```

---

## 🔹 4. Constructores y herencia

La subclase debe llamar al constructor de la superclase.
Ejemplo con propiedades adicionales:

```kotlin
open class Persona(val nombre: String, val edad: Int)

class Estudiante(nombre: String, edad: Int, val carrera: String) : Persona(nombre, edad)
```

---

## 🔹 5. Clases `abstract`

Si una clase no debe ser instanciada directamente, se marca como `abstract`.
Los métodos abstractos deben implementarse en las subclases.

```kotlin
abstract class Figura {
    abstract fun area(): Double
}

class Rectangulo(val ancho: Double, val alto: Double) : Figura() {
    override fun area() = ancho * alto
}
```
> Por defecto, las clases y funciones abstractas son open. 
---

## 🔹 6. Interfaces

En Kotlin, las interfaces pueden tener métodos abstractos y también **implementaciones por defecto** (similar a `default` en Java 8).

```kotlin
interface Volador {
    fun volar()
    fun despegar() { println("Despegando...") }
}

class Pajaro : Volador {
    override fun volar() { println("El pájaro vuela") }
}
```

> Las interfaces en Kotlin, en forma similar a Java, pueden contener funciones abstractas y funciones con implementación (métodos de default). La diferencia con clases abstractas es que las interfaces no contienen estado.

> Si más de una interfaz define el mismo método con implementación por defecto, la subclase está obligada a sobrescribirlo (porque si no, habría ambigüedad).
---

## 🔹 7. `super`

Se puede usar `super` para llamar a la implementación de la superclase:

```kotlin
open class Vehiculo {
    open fun encender() = println("Encendiendo vehículo")
}

class Auto : Vehiculo() {
    override fun encender() {
        super.encender()
        println("Listo para conducir")
    }
}
```


> Todas las clases en Kotlin tienen una superclase común: Any (equivalente a Object en Java). 


---

# Modificadores de acceso (Visibilidad)
Contra desde donde se puede ver y usar una clase, propiedad, función o constructor.
| Modificador              | Visibilidad                                                                               |
| ------------------------ | ----------------------------------------------------------------------------------------- |
| `public` *(por defecto)* | Visible en **todas partes**.                                                              |
| `internal`               | Visible en **todo el mismo módulo** (ejemplo: mismo proyecto, mismo artefacto compilado). |
| `protected`              | Visible en la **clase y sus subclases**.                                                  |
| `private`                | Visible **solo dentro del mismo archivo** (si es top-level) o dentro de la clase/objeto.  |

> En Kotlin protected NO significa "clase + mismo paquete" como en Java sino que es solo **clase + herencia**

### Ejemplo de declaraciones  de nivel superior:
```kotlin
// nombre de archivo: ejemplo.kt

package laboratorio

private fun unaFuncion() {  } // solamente visible desde visible dentro de ejemplo.kt

public var miPropiedad: Int = 5 // esta propiedad es visible en todos lados

    private set         // el setter es solo visible en ejemplo.kt

internal val miPropiedadInmitable = 6    // visible dentro del mismo módulo
```
