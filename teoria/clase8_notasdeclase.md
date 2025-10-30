# Android 

> un Activity es un componente fundamental que representa una pantalla con una interfaz de usuario. Cada aplicación puede tener una o más actividades, y cada una está diseñada para realizar una tarea específica o mostrar una parte de la interfaz de usuario.

Los managers gestionan las activities (paralelismo con los Schedule executor). 

Una vez que se compile un archivo .kt se convierne en `.dex` queluego se empaqueta en un archivo `.apk`. 
> Las aplicaciones Android se ejecutan en su propio proceso Linux

## Arquitectura 
Aplicaciones y widgets: es la capa de más alto nivel de la arquitectura, en la que los ussuarios finales sólo ven a esta. 

## Aplicaciones 
Cada aplicación Android se ejecuta en un proceso Linux diferente y es independiente de las demás aplicaciones, cada proceso tiene su propio entorno de ejecución y este se crea cuando la aplicación es ejecutada por primera vez.

> Las app Android deben firmarse digitalmente antes de ser instaladas en un dispositivo (http://developer.android.com/tools/publishing/app-signing.html)

> R es la clase de los recursos, a partir de ahí se los invocan. 
> Los Intents permiten navegar desde un Activity a otro, comunicarse y transferir datos entre Activities. 