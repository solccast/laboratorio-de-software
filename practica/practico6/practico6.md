# Laboratorio de Software - Práctica 5

| Temas                            |
| -------------------------------- |
| - Conceptos y uso de excepciones |
| - Try, catch, finally            |
| - Definición de excepciones      |

1. Determine el siguiente código es correcto. Si produce un error, observe de qué tipo es y soluciónelo.

```java
class Excepcion1 extends Exception{}

class Excepcion2 extends Exception1{}

public class Test1 {
    public static void main(String[] args) {
        try {
            throw new Exception2();
        } catch(Excepcion1 e1) {
            System.out.println(“Se capturó la Excepción1”);
        } catch(Excepcion2 e2) {
            System.out.println(“Se capturó la Excepción2”);
        }
    }
}

```

No es correcto. Es un error que se detecta en tiempo de compilación por lo tanto es un _Checked Exception_. Excepcion2 no podría ser capturada por el segundo catch ya que por herencia adoptaría Excepcion1. Esto se resuelve cambiando el orden, es decir que el catch adopte Excepcion2 primero antes que Excepcion1. 

```java
        try{
            throw new Excepcion2();
        } catch (Excepcion2 e2){
            System.out.println("Se capturó la Excepción2");
        } catch (Excepcion1 e1){
            System.out.println("Se capturó la Excepción1");
        }
```
Con esta solución compila pero nos indica de todas formas un alerta: que el último catch es inalcanzable pues ya está contemplado en el anterior catch. Como solución se nos propone eliminar el catch sobrante. 

```java
        try{
            throw new Excepcion2();
        } catch (Excepcion2 e2){
            System.out.println("Se capturó la Excepción2");
        } 
```

2. Ejecute el siguiente código, ¿cuál es el resultado? Elimine los comentarios y vuelve a ejecutarlo, ¿cuál es el resultado? 
```java
public class Test2 {
    public int unMetodo(){
        // try {
        System.out.println("Va a retornar 1");
        return 1;
        // } finally {
        System.out.println("Va a retornar 2");
        return 2;
        // }
    }
    public static void main(String[] args) {
        Test2 res = new Test2();
        System.out.println(res.unMetodo());
    }
}
```
No compila xD el segundo print es inalcanzable porque el return está arriba: `java: unreachable statement`. 

Al quitar los comentarios compila y ejecuta correctamente. Tenemos el siguiente output:
```java
Va a retornar 1
Va a retornar 2
2
```
Por la naturaleza de la estructura try/catch/finally el último bloque se va a ejecutar siempre (si hay return, break o una excepción inclusive) por eso responde con 2 ya que el valor 1 queda pendiente de retorno y el finally lo anula. En buenas prácticas, no debe usarse para retornar valores.

3. Ejecute el siguiente código. ¿cuál es la salida del programa? 
```java
public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3");
        try {
            System.out.println("Primer try");
            try {
                throw new Exception();
            } finally {
                System.out.println("Finally del 2º try");
            }
        } catch (Exception e) {
            System.out.println("Se capturó la Excepción ex del 1º Primer try");
        } finally {
            System.out.println("Finally del 1º try");
        }
    }
}
```

**Output**:
```
Test3
Primer try
Finally del 2º try
Se capturó la Excepción ex del 1º Primer try
Finally del 1º try
```
Se observa como **antes** de saltar en búsqueda del manejador de exepciones se ejecuta el finally del correspondiente bloque try/catch. 

4. Analice el siguiente código y determine si es correcto. Si hay errores, esriba el motivo de cada uno y proponga una solución. 

```java
class FutbolException extends Exception{}

class Falta extends FutbolException{}

class EquipoIncompleto extends FutbolException{}

class ClimaException extends Exception{}

class Lluvia extends ClimaException{}

class Mano extends Falta{}

class Partido {
    Partido() throws FutbolException{}
    void evento() throws FutbolException{}
    void jugada() throws EquipoIncompleto, Falta{}
    void penal(){}
}

interface Tormenta {
    void evento() throws Lluvia;
    void diluvio() throws Lluvia;
}

public class Encuentro extends Partido implements Tormenta {
    Encuentro() throws Lluvia, FutbolException{..}
    Encuentro (String fecha) throws Falta, FutbolException{..}
    void penal() throws Mano{..}
    public void evento() throws Lluvia{..} 
    public void diluvio() throws Lluvia{..} 
    public void evento(){..}
    void jugada() throws Mano{..}

    public static void main (String[] args) {
        try {
            Encuentro enc = new Encuentro();
            enc.jugada();
        } catch(Mano e) {
        } catch(Lluvia e) {
        } catch(FutbolException e) {
            try {
                Partido par = new Encuentro();
                par.jugada();
            } catch(EquipoIncompleto e) {
            } catch(Falta e) {
            } catch(Lluvia e) {
            } catch(FutbolException e) {}
        }
    }
```  

| Caso | Solución | 
| --- | --- |
| En la clase `Encuentro` se encuentra redefinido el método `penal()` pero en podría lanzar una excepción, esto no es correcto. Solo puede lanzar excepciones no comprobadas (RuntimeException, NullPointerException, etc.),
porque esas no necesitan declararse en throws. | Modificar el método penal de Partido para que tire la misma excepción o superior. O que en Penal se encuentre un manejador de la excepción Mano. |
| En el método evento() tiene dos implementaciones. La firma es la misma para ambos casos, no compila. Recordar que la firma de un método es `nombreMetodo + lista de parámetros (tipos y orden)` | Cambiar la firma equisde | 


5. Analice el siguiente código: 
```java
public class Suma{
    public static void main(String[] args){
        int suma=0;
        for(int i = 0; i< args.length; i++)
            suma += Integer.parseInt(args[i]);
        
        System.out.println("La suma es: "+suma);
    }
}
```
a. Ejecútelo ingresando al menos dos valores.
b. Ahora ejecútelo ingresando: 2 3 four ¿Qué pasó? Solucione el problema de manera que los datos no numéricos sean impresos en la consola con un mensaje y descartados antes de ser sumados.

**OUTPUT de 2 3 four**:  `Exception in thread "main" java.lang.NumberFormatException: For input string: "four" at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)`

c. ¿Por qué no fue necesario capturar la excepción en el inciso a)? 
Porque eran valores válidos para el casting a Integer.

---

# Sobre excepciones
Una excepción es un evento o problema que ocurre durante la ejecución de un programa e interrumpe el flujo normal de ejecución de instrucciones. Una excepción interrumpe el procesamiento normal porque no cuenta con la información necesaria para resolver el problema en el contexto en que sucedió. 
Se clasifican en: 
- **Checked Excepction - Verificables en compilacion**: representan un problema con la posibilidad de recuperación. Las apps bien escritas pueden anticipar y recuperar estos errores. Java obliga a los métodos que disparan este tipo de excepciones a que capturen y manejen el error que lo propauen. 
- **Runtime Exception**: son errores internos de la aplicación que no se pueden anticipar ni recuperar. Estas excepciones en general son bugs del programa y se producen por errores de lógica o por el **mal uso de la API JAVA**. 
- **Error**: son errores externos a la aplicación, relacionadas al hardware, a la falta de memoria y que la aplicación no puede anticipar ni recuperar

> El método sobrescrito no puede lanzar excepciones más amplias que las que declara el método de la superclase.