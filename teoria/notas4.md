# Tipos enumerativos 

Siempre tiene asociado un conjunto de valores **finito** y **acotado** de objetos. 
Es como una extensión de singleton. 
El tipo enumerativo es una clase y sus valores son **instancias** de dicha clase -> garantiza **seguridad de tipos**. 
- Esta clase NO es extendible. 
Un enum “enriquecido” (también llamado “enum con estado y comportamiento”) permite asociar datos y métodos a cada constante del enum, convirtiendo a cada constante en un objeto singleton con sus propios atributos. Siempre se debe tener un constructor para este tipo de enums. 

Ejemplo de Enum Enriquecido:
```java
enum Dia {
    LUNES("Inicio de semana", 1),
    MARTES("Día normal", 2),
    MIERCOLES("Mitad de semana", 3);

    private final String descripcion;
    private final int numero;

    Dia(String descripcion, int numero) {
        this.descripcion = descripcion;
        this.numero = numero;
    }

    public String getDescripcion() { return descripcion; }
```

A cada constante enumertiva se le puede asociar un **comportamiento diferente**. 
```java
enum Operacion {
    SUMA {
        double aplicar(double x, double y) { return x + y; }
    },
    RESTA {
        double aplicar(double x, double y) { return x - y; }
    };
    abstract double aplicar(double x, double y);
}

```
Acá se puede observar las implementaciones de métodos de constantes específicas. 

Los tipos enumerativos **NO** pueden extenderse pero sí pueden **implementar** interfaces. 
En Java, los tipos enumerativos pueden implementar interfaces para definir comportamientos comunes. Cada constante enum puede proveer su propia implementación de los métodos de la interfaz, logrando polimorfismo sin necesidad de clases separadas.

# Clases genéricas 
Los tipos y métodos genérticos se usan para proveer **chequeo de tipos en compilación**.
```java
public class LinkedList<E> ...{
    LinkedList -> tipo genérico 
    E es un parámetro formal que denota un tipo de dato
}

```
- Una clase genérica tiene el mismo comportamiento para todos sus posibles tipos de parámetros. 
- **Tipos parametrizados**: se forman al asignarle tipos **reales** a los parámetros formales: `LinkedList<Integer> listaInteger = new LinkedList<Integer>();`

## ¿Qué problemas resuelven los genéricos?
Se evitan los errores en ejecución causados por el uso de casting. 
- Provee seguridad en compilación pudiendo detectar errores en compilación. 
Los **tipos parametrizados con comodines** el cual es una construcción sintáctica "?" que denota un conjunto de algún tipo desconocido. Se usan generalmente como **sólo lectura** ya que se castea como instancias de Object. 

```java
public void prueba(Set<?> s1, Set<?> s2) { //---> solo lectura
    // Solo puedes leer elementos como Object
    Object o = s1.iterator().next();
    // s1.add("texto"); // Error de compilación
}

public void prueba(Set s1, Set s2) {
    // Puedes añadir cualquier objeto
    s1.add("texto"); // Compila, pero puede causar problemas si s1 era Set<Integer>
}
```

Se pueden usar comodines con cotas:
- <?> (comodín sin restricción)
- <? extends T> (subtipos de T)
- <? super T> (supertipos de T)
Son útiles en situaciones en las que es encesario contar acon un conocimiento parcial sobre el tipo de argumento de los tipos parametrizados. 

- Los tipos parametrizados son **invariantes** por lo tanto si el método es:
`public static double sum(List<Number> list)` solo se puede pasar una lista declarada exactamente como List<Number>, no List<Integer>, en cambio si está decladada de esta forma: `public static double sum(List<? extends Number> list)` es más **flexible**.

### Reglas de subtipos para genéricos
Los tipos parametrizados son **invariantes**:
```java
List<Integer> listita = new ArrayList<>();
List li = listita; // Compila, pero pierdes seguridad de tipos
```
Se Pierde la seguridad de tipos que ofrecen los genéricos. y se Puede añadir cualquier tipo de objeto a li, incluso que no sea Integer, lo que puede causar errores en tiempo de ejecución.

```java
List<Integer> li = new ArrayList<>();
li.add(10);
List<? extends Number> lo = li;
lo.add(3.14);
Integer i = li.get(1);
```

Cuando se hace  `List<? extends Number> lo = li;`, el compilador ya no sabe si la lista contiene Integer, Double, etc. Por eso, no se puede añadir ningún elemento (excepto null) a lo, porque podría romper la seguridad de tipos. El comodín `? extends Number` solo permite leer.

-> Si se busca que la lista sea de solo lectura -> `<? extends T>`
-> Si se busca que la lista sea de escritura -> `<? super T>`

### Ventajas de usar genéricos
- Detección temprana de errores: durante el tiempo de compilación. 
- Seguridad de tipos: un programa es seguro respecto al tipado si compila sin errores ni advertencias. 
-