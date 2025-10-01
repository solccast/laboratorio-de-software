```java
enum ComparadorPersona implements Comparator<Persona> {
    POR_NOMBRE_ASC {
        public int compare(Persona a, Persona b) {
            return a.getNombre().compareToIgnoreCase(b.getNombre());
        }
    },
    POR_NOMBRE_DESC {
        public int compare(Persona a, Persona b) {
            return b.getNombre().compareToIgnoreCase(a.getNombre());
        }
    };
}

//Uso
List<Persona> copia = new ArrayList<>(personas);
copia.sort(ComparadorPersona.POR_APELLIDO_Y_NOMBRE); //Sort recibe un comparador 

```

```
? extends T → “Producer”: podés leer como T pero no escribir.

? super T → “Consumer”: podés escribir T pero lees como Object.

? solo (sin acotar) → “unknown”: lees como Object, no escribís.
```