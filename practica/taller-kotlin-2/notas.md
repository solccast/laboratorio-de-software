# Kotlin - Taller 2 

## Funciones 

### Lambda 
Las funciones que contienen una sola expresión se pueden crear con una sintáxis abreviada omitiendo las llaves {}. El tipo de retorno se infiere. 
```
fun sum(a: Int, b: Int) = a + b
```

### Unit-returning functions 
Si una función no retorna una valor útil entonces su tipo de retorno es `Unit`. Este valor no tiene que devolverse de forma explícita:
```java
fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}
``` 
La declaración del tipo de retorno `Unit` también es opcional. El código anterior es equivalente a: `fun printHello(name: String?) { ... }` 
El equivalente en Java es `void` que debe declararse en la firma del método.  

### Parámetros con valores default 
Los parámetros de una función pueden tener valores predeterminados q se utilizan para omitir el argumento correspondients (también llamados opcionales). Esto reduce el número de sobrecarga. 

```java
fun printStudent(nombre: String, facultad: String="Facultad Informatica" , edad: Int=18) {       
    println("Nombre: $nombre")
    println("Facultad: $facultad")
    println("Edad: $edad")
}
```

En este ejemplo, al momento de compilar ya la función asigna el valor por defecto de la función, al sobreescribirla genera un error, la declaración por defecto se asocia a la superior. 

```java
open class A {
	open fun printParam(i: Int = 10) {
        println("El parametro vale $i")
    }
}
class B : A() {
	override fun printParam(i: Int = 20) {
        super.printParam(i)
    } 
}

fun main() {
    B().printParam()        
}
```

> En Kotlin, no se permite redefinir valores por defecto en los parámetros cuando se sobrescribe (override) un método.

## Infix notation
El lenguaje permite definir la función sin el uso de puntos y paréntesis. El objetivo es que el código luzca más parecido al lenguaje natural (más legible, limpio y conciso). 

Las funciones infijas cumplen los siguientes requisitos:
- Pueden ser funciones miembro de clases o de interfaces o extensiones. - Las funciones que son extensiones permiten extender la funcionalidad de una clase o interface sin usar herencia. De esta manera es posible escribir nuevas funciones para una clase o interface de una librería de terceros que no se puede modificar. 
- Deben tener un único parámetro.
- El parámetro de una función infija no acepta un número variable de argumentos y no puede contener un valor por defecto.

## Alcance de una función 
### Funciones de nivel superior
Son funciones definidas fuera de cualquier clase, objeto o interface, es decir definidas directamente a nivel de paquete.
Estas funciones realizan ciertas operaciones que pueden reutilizarse en múltiples sitios pero que no forman parte de clases, ofrecen "métodos estáticos" (en terminología Java) es decir son funciones invocadas sin instanciar objetos. Para usar dichas funciones simplemente se importan como si fuesen una clase más.

### Funciones miembro de clases o interfaces
Son las funciones que se declaran dentro de una clase o interface y para invocarlas es necesario disponer de una instancia. 

### Funciones locales
Son funciones declaradas dentro de otras funciones. Se puede acceder a las variables declaradas en ámbitos superiores.

### Funciones extensión
Permiten agregar funciones a cualquier clase aunque no tengamos acceso a su código fuente y sin tener que crear clases que la extiendan.
Se declaran anteponiendo el nombre de la clase para la que creamos la función: `fun MiClase.funcion(...){//...}`.
Mediante el objeto this tenemos acceso al objeto sobre el que invocamos a la función y por lo tanto a sus propiedades y funciones. En términos prácticos es equivalente a crear la función dentro de la clase Int.

# Expresiones Lambda en Kotlin 
Una función sin nombre es llamada función anónima y las expresiones lambda son funciones anónimas. 

```java
fun main(args: Array<String>) {
    //Definición de la función
    val imprimo = { println("Taller de Kotlin")}
    //Forma de invocación #1
    imprimo() 
    //Forma de invocación #2
    imprimo.invoke()
}
``` 

```java
val suma1: (Int, Int) -> Int = {a, b -> a + b} // el tipo se expresa en el método  
val suma2 = {a: Int, b: Int -> a + b} // el tipo de retorno se infiere por el compilador

fun main(){
    val result1 = suma1(2,3)
    val result2 = suma(3, 4)
    println("Suma de dos números : $result1")
    println("Suma de dos números : $result2")
}
```

## Manejo de excepciones 
En Kotlin las excepciones son `unchecked`. A diferencia de Java, el compilador no verifica que la excepción sea capturada y recuperado o re-disparada. 

Las excepciones más comunes en Kotlin son:

- NullPointerException: se levanta si quiere acceder a una propiedad o invocar un metodo sobre una referencia null.

- ArithmeticException: se levanta cuando se realiza una operación aritmética inválida.  Ej: división por cero.

- SecurityException: se utiliza para indicar una violación de seguridad.

- ArrayIndexOutOfBoundException: se levanta cuando se accede a un índice inválido al trabajar con arreglos.

> `try` es una expresión que retorna un valor al igual que throw con tipo `Nothing`. 

> Al consumir APIs Java con checked exceptions desde Kotlin, no estás obligado a capturarlas.

## Colecciones 
El paquete `kotlin.collections` (que se importa de manera automática) proporciona un conjunto completo de herramientas (interfaces, clases y funciones) para manejar colecciones.
Se agrupan en:
- Inmutables: son de solo lectura con operaciones para acceder a los elementos de la colección. Ej: List, Set y Map. 
- Mutables: modificables con operaciones de escritura. Ej: MutableList, MutableSet y MutableMap. 

| Función      | Propósito                                        | Parámetro principal | Ejemplo                                   | Relación                                      |
| ------------ | ------------------------------------------------ | ------------------- | ----------------------------------------- | --------------------------------------------- |
| `sortedBy`   | Ordena por una *clave* derivada de cada elemento | Lambda `(T) -> R`   | `lista.sortedBy { it.edad }`              | Usa internamente `sortedWith(compareBy(...))` |
| `sortedWith` | Ordena con un *Comparator* personalizado         | `Comparator<T>`     | `lista.sortedWith(compareBy { it.edad })` | Más general                                   |

## Clases anidadas e internas 
Una **clase anidada** es una clase definida dentro del espacio de nombres de una clase de nivel superior 

| Característica                          | **Clase Anidada** (`class A`) | **Clase Interna** (`inner class A`) |
| --------------------------------------- | ----------------------------- | ----------------------------------- |
| Acceso a miembros de la clase exterior  | ❌ No puede                    | ✅ Sí puede                          |
| Necesita instancia de la clase exterior | ❌ No                          | ✅ Sí                                |
| Equivalente en Java                     | `static class`                | `non-static inner class`            |
| Palabra clave especial                  | ninguna                       | `inner`                             |
| Sintaxis de creación                    | `Exterior.A()`                | `Exterior().A()`                    |

Una **clase local** es una clase declarada dentro de una función o un bloque (por ejemplo, dentro de main(), o dentro de otra función).
Solo existe en ese ámbito, es decir, no puede usarse fuera de la función donde se define.
Una clase anónima es una clase sin nombre, creada directamente en el momento en que se necesita, usualmente para implementar una interfaz o extender una clase abstracta una sola vez.