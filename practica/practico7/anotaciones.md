# Notas adicionales 

## Interfaces 
- **Executor (nivel 1)**: es la interfaz base, representa cualquier cosa capaz de ejecutar una tarea (`Runneable`). Contiene únicamente el método `execute`. No devuelve resultados, no hay control posterior. 
- **ExecutorService (nivel 2)**: interfaz que se extiende de `Executor`, agrega funcionalidades de gestión de resultados y control del ciclo de vida. Agrega `submit()` que permite enviar tareas que devuelven resultados, `shutdown()` como control de ciclo de vida, `awaitTermination()`, `isShutdown()` e `isTerminated()` para el control del estado. 
- **ScheduledExecutorService (nivel 3)**: es una interfaz para tareas periodicas o con retardo que se extiende de `ExecutorService`. Devuelve `ScheduledFuture`, que hereda de `Future` pero con información de tiempo.


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

## `execute` vs `submit`
- **execute(Runnable)**
    - Es el método básico del interfaz `Executor`.
    - Solo ejecuta una tarea que implemente Runnable.
    - No devuelve nada.
    - Si la tarea lanza una excepción no capturada, esta va al Thread. `UncaughtExceptionHandler` del hilo del pool.

- **submit(Callable / Runnable)**
    - Pertenece a `ExecutorService` (subinterfaz de Executor).
    - Devuelve un `Future<T>`, un objeto que representa la tarea en ejecución y su posible resultado.
    - Si la tarea falla, la excepción queda guardada dentro del Future y podés consultarla con `future.get()`.

