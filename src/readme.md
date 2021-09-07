## README
**
El código desarrollado como prueba del "easyGOband Recruitment Test" se ha desarrollado para cumplir
unas determinadas funciones.


## Sin parámetros
**
Muestra la totalidad de los datos obtenidos a través de la api REST de la empresa:

GET /items


##Filtrado de datos
**
Se obtienen únicamente los datos de aquellos objetos cuyos atributos coinciden con los indicados por
el usuario. Hay diversos criterios de filtrado, ya que podemos buscar filtrado por coincidencia exacta
y filtrado por atributo mayor o igual y filtrado por atributo menor o igual. También es posible
el filtrado por dos o más atributos. Ejemplos:

GET /items?access_group_name=Abono
GET /items?basic_product_id=35
GET /items?id=[gte]100
GET /items?basic_product_id=[lte]50

Los campos sobre los cuáles se puede realizar el filtrado son:
- id
- access_group_name
- access_group_id
- basic_product_id
- event_id


##Ordenación de datos
**
Se puede obtener tanto un listado con todos los datos ordenados según un campo o ordenar el listado de datos obtenidos
cuando se aplica un filtrado de datos. La ordenación será ascendente o descendente (por defecto será ascendente).

GET /items?sorted_by=id
GET /items?sorted_by=desc(id)
GET /items?access_group_name=Viernes&sorted_by=asc(id)


##Paginación
**
Permite indicar la posición del primer dato que se mostrará y la cantidad límite de datos que se desean mostrar.
Además, se puede combinar con el filtrado y la ordenación de datos. 

GET /items?offset=2&limit=20  => Muestra el segundo objeto del listado de objetos obtenido y los 19 siguientes.




