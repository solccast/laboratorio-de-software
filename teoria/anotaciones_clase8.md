# Clase de anotaciones & reflection 

## Anotaciones
- anotaciones basados en interfaces. Al código ofrecen metadatos (indicaciones para otras herramientas). 
- entenderlo como información descriptia del código. 
- Tipo de dato verificable por el compilador. 

### Anotaciones predefinidas
- `@Override`: ayuda al compilador a indentificar el método sobreescrito y no la sobrecarga. Los warnings de los ides complementan los mensjaes de error del compilador, se garantiza entonces que se esta sobreescribiendo los métodos en el lugar que se desee. 
- `@Deprecated`: que el código no se va a mantener, no hay garantía. Se aplica a métodos. 
- `@SupressWarnings`: sirve para eliminar advertencias del compilador como las `unused`y `unchecked`
- `@FunctionalInterface`

## Declaración 
Al momento de instanciar una anotación es necesario pasarle valores (si corresponde a la interface) entonces el compilador indicará si es válido 

```java
// Definición de la anotación
@Retention(RetentionPolicy.RUNTIME) // Indica que estará disponible en tiempo de ejecución
@Target(ElementType.METHOD)         // Indica que solo se puede usar en métodos
public @interface MiAnotacion {
    String valor() default "Por defecto"; // Atributo con un valor predeterminado
}

public class Ejemplo {
    @MiAnotacion(valor = "Ejemplo de uso") 
    public void miMetodo() {
        System.out.println("Método anotado");
    }
}
```

Cuando se tiene un único elemento se puede omitir el nombre de los pares de modo que quedaría 
```java
public @interface MiAnotacion {
    String value() default "Por defecto"; // Atributo con un valor predeterminado
}

public class Ejemplo {
    @MiAnotacion("Ejemplo de uso") 
    public void miMetodo() {
        System.out.println("Método anotado");
    }
}
```
> Hay diferentes tipos de método, de clases, de constructores. 

## Anotaciones Marker
Las anotaciones marker (o marcadoras) son un tipo especial de anotaciones en Java que no tienen atributos. Su único propósito es marcar o etiquetar un elemento del código (clase, método, campo, etc.) para indicar algo específico.

Ejemplos comunes en Java:
@Override: Indica que un método sobrescribe uno de su clase padre.
@Deprecated: Marca un elemento como obsoleto.
@FunctionalInterface: Marca una interfaz como funcional.
@Test
 

# Excepciones 
Evento o problema que ocurre **durante** la ejecución de un programa. 

 --- 
 # Interfaces funcionales
Son interfaces que tienen un único método abstracto. Estas interfaces son la base para las expresiones lambda y las referencias a métodos introducidas en Java 8.

## Características principales:
- Un único método abstracto: Aunque pueden tener métodos default o static, solo pueden tener un método abstracto.
- Anotación `@FunctionalInterface`: Es opcional, pero se recomienda usarla para indicar que la interfaz es funcional. El compilador lanzará un error si intentas agregar más de un método abstracto.
- Las interfaces funcionales permiten usar lambdas para implementar su único método abstracto:



