# Notas adicionales 

## Ejecutores: diferencias en los métodos
Un Executor (o Thread Pool Executor) es un componente que administra un pool de threads (grupo de hilos reutilizables). En lugar de crear un nuevo hilo cada vez, se reusan hilos del pool para ejecutar tareas.
Esto mejora el rendimiento y permite controlar:
- cuántos hilos pueden ejecutarse al mismo tiempo,
- cuándo se crean o destruyen,
- y cómo se gestionan las colas de tareas.

| Executor                    | N° de hilos | Reutiliza | Crea nuevos hilos            | Cola de tareas         | Ideal para                         |
| --------------------------- | ----------- | --------- | ---------------------------- | ---------------------- | ---------------------------------- |
| `newFixedThreadPool(n)`     | Fijo (`n`)  | ✅ Sí      | ❌ No (solo si muere un hilo) | ✅ Sí                   | Carga estable, predecible          |
| `newCachedThreadPool()`     | Variable    | ✅ Sí      | ✅ Sí (sin límite)            | ❌ No (lanza más hilos) | Muchas tareas cortas o esporádicas |
| `newSingleThreadExecutor()` | 1           | ✅ Sí      | ❌ No                         | ✅ Sí                   | Procesamiento secuencial, ordenado |
 
> `newSingleThreadExecutor` es igual para cuando se necesa mantener orden o sincronización, pero sin bloquear el hilo principal.  

## Synchronized 
La anotación `@synchronized` se puede aplicar a una función o método. Funciona para indicarle al compilador que genere código sincronizado.  Dos hilos no pueden ejecutar el mismo método al mismo tiempo. 