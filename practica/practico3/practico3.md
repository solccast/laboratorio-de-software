# Laboratorio de Software - Práctica 3

| Temas |
| -- |
| - Clases anidades y clases internas |
| - Clases anónimas |
| - Módulos |
| - Tipos Enumerativos |

1. Complete el código de la clase `Stack` en el paquete `practica3` de manera que implemente una pila de String:
![alt text](image.png)
a) Implemente un método `main()` para probar la pila. Agregue Strings a la pila y recórrala para imprimir sus valores. ¿Cuántas veces puede recorrerla?
Se puede recorrer una única vez porque los elementos se puede tener acceso con el método `pop`, por lo tanto la pila queda vacía. 
```java
        while(!stack.isEmpty()){
            //Lógica de recorrido
            System.out.println(stack.pop());
        }
```
b) Agregue una clase anidada llamada `StackIterator` que provea un objeto de tipo `Iterator` para recorrer la pila.

c) Agregue en la clase `Stack` un método para que retorne una instancia de `StackIterator`. ¿Cuántas veces puede recorrer la pila ahora?
d) ¿Es posible crear objetos `StackIterator` desde una clase diferente a la clase `Stack` con el operador `new`?, ¿cómo lo hace?
Sí, si se define a la clase anidada como pública se puede instanciar desde afuera: 
```java
Iterator<String> itr3 = stack.new StackIterator();
```

e) ¿Cómo haría para evitar crear instancias de una clase anidada desde una clase que no sea la que la definió?
Si se modifica el alcance a private no se puede instanciar desde afuera, si o sí desde la clase Stack. 


2. Analice el código que figura debajo: 
```java
class InnerStatic{

    static double PI = 3.1416;

    static class Circulo{
        static double radio = 2;

        static double getArea(){
            double a = PI * Math.pow(radio, 2);
            System.out.println("El area es: "+a);
            return a;
        }

        static double getLongitudCircenferencia(){
            double l = 2*PI*radio;
            System.out.println("La longitud es: "+l);
            return l; 
        }
    }
    //...
}
```
a) Modifique el código de la clase interna estática para que el valor inicial del radio sea ingresado por el usuario en el momento de la ejecución.
Agregué un `setRadio` al que se le setea de esa forma el valor a la variable estática.  
b) Defina una clase llamada `InnerTest` en el paquete practica3 con un método `main()` que imprime en la pantalla el área y la longitud de la circunferencia. Ejecútela varias veces ingresando distintos radios.
c) Remplazar `PI* Math.pow(radio,2)` por `PI* pow(radio,2)`, siendo `pow()` el método de la
clase `java.lang.Math`.

`import static` te deja usar métodos/constantes estáticos sin anteponer el nombre de la clase. Aporta menos código repetido y más legibilidad.





