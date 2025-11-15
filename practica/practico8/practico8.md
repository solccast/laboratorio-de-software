# Laboratorio de software - Practico 8

| Temas :                                                                |
| ---------------------------------------------------------------------- |
| - Ambiente de desarrollo Android                                       |
| - Conceptos Android: aplicación, activities, views, recursos y layouts |
| - Diseño declarativo de interfaz gráfica                               |

## Agenda de recursos web (Bookmarks o Favoritos)
En esta práctica desarrollaremos una aplicación Android que permita administrar recursos Web. 

1. Implemente una aplicación Android que muestre una lista de recursos Web. Estos recursos Web están representados por:
- un nombre
- un comentario
- una URL
- tipo de recurso (imagen, audio, video, etc)
La aplicación, desde su Activity principal debe mostrar una lista de selección simple. Cada ítem de la lista debe contener el nombre y el tipo de recurso.
**Ayuda**: para representar la lista utilice un `RecyclerView` y cree su propio `Adapter` extendiendo de `RecyclerView.Adapter`.

2. Agregue a la Agenda de Recursos Web, la posibilidad de abrir un recurso listado mediante el evento `onLongClick`. El recurso podría abrirse por ejemplo con el navegador Web que viene instalado en Android.

3. Reemplace el texto que indica el tipo de cada recurso con un ícono que lo represente.

4. Incorpore un botón flotante (FloatingActionButton) que permita compartir la lista de recursos (como texto plano) a través de otras aplicaciones instaladas en el dispositivo, como WhatsApp, Instagram, Twitter, etc.

