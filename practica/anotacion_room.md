muy símil a DAO. 
Por cada marcador como `entity` se generea una nueva tabla, @relation para armar relaciones, @primarykey. se definen lasd anotaciones 
El patrón DAO hace de intermediaron con la Base de datos en el cual las operaciones en el cual con la anotación `@query` en el que iría la query sql. 
Las clases `repository` son los que interactúan con el DAO para mantener la encapsulación más allá de qué db usa. 
Un DAO -> un repository. 

Una vez que se llama al repository es necesario hacerlo en una corrutina y otro thread porque sino se queda bloqueado hasta esperar que se resuelva la query. (la corrutina sería `viewModelScope`)
A definir:
- entidades
- DAOs -> interfaz 
- BD ->clase abstracta