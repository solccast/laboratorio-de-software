# Laboratorio de Software - Práctica 5

| Temas |
| -- |
| - Conceptos y uso de anotaciones|
| - Definición de anotaciones |

1. Analice qué ocurre con la siguiente clase cuando se compila: 
```java
public class TestSobreescritura {
    @Override
    public String toString(){
        return super.toString() + "Testeando: 'Override'";
    }
}

```
a) ¿Qué ocurre cuando se ejecuta `TestAnotaciones`?
Nada, no lanza ninguna alerta, compila y ejecuta con éxito. 

b) ¿Qué ocurre si se elimina `@SuppressWarnings({"deprecation"})`? ¿el resultado de la ejecución es el mismo?
Sí, el resultado de la ejecución es el mismo sin embargo, desde la IDE se nos indica que la función utilizada hay que reemplazarla porque ya se encuentra deprecada desde donde se la hace uso. 
Al momento de compilar nos sale la siguiente alerta: 
`java: hacer() in practica5.ej1.TestDeprecated has been deprecated`

c) ¿Cuál es la diferencia entre anotar el método testarYa() y anotar la clase TestAnotaciones?

```java
public class TestAnotaciones {
    public static void main(String[] args) throws Exception{
        new TestAnotaciones().testearYa();
    }

    @SuppressWarnings({"deprecation"})
    public void testearYa(){
        TestDeprecated t2 = new TestDeprecated();
        t2.hacer();
    }
}

public class TestDeprecated {
    @Deprecated
    public void hacer(){
        System.out.println("Testeando: 'Deprecated'");
    }
}
```

En caso de usar la anotación en la clase si tiene más _warnings_ en otros métodos, serán ignorados por el compilador pero en el caso actual provisto ignora sólo las que están definidas en el método. 


2. Implementar una clase que mapee un objeto Bean a un archivo del filesystem y almacene en el archivo:
    a. El nombre de la clase. 
    b. Los nombres de los atributos y el contenido de los mismos. 

    Las anotaciones que entiende son las siguientes:
    - `Archivo(name="nombre.extension")` -- Indica que la información se almacenará en el archivo nombre.extensión. Si no se explicita un nombre, se utiliza el nombre de la clase. 
    - `AlmacenarAtributo` -- Denota que el nombre del atributo que está a continuación de la anotación se debe almacenar en el archivo. 

    Por ejemplo, dada la siguiente clase:
    ```java
    @Archivo(nombre="Archivomapeado.txt")
    public class Mapeado{

        @AlmacenarAtributo
        private String valor = "Default1";
        @AlmacenarAtributo
        private Integer valor2=20;
        @AlmacenarAtributo
        private Float valor3=30.20f;
        private Float valor4=30.20f;
        //Metodos getters y setters
    }

    ```
    La salida en el archivo `Archivomapeaado.txt` sería:
    ```java
    <nombreClase>Mapeado</nombreClase>
    <nombreAtributo>valor</nombreAtributo>
    <nombreValor>Default1</nombrenombreValor>
    <nombreAtributo>valor2</nombreAtributo>
    <nombreValor>20</nombrenombreValor>
    <nombreAtributo>valor3</nombreAtributo>
    <nombreValor>30.2</nombrenombreValor>

    ```

> Me gustó esta documentación, es clara: https://www.oracle.com/technical-resources/articles/java/javareflection.html