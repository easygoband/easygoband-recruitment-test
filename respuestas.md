Respuestas
==========

El cliente
----------

Para implementar el cliente he usado Java, Spring Booot y Gradle.

Es una aplicación de línea de comandos.

La aplicación se puede compilar y ejecutar con el comando:

```
./gradlew -q --console plain bootRun
```

Si se quiere filtrar por una sesión:

```
./gradlew -q --console plain bootRun -Pargs="--sessionName=02-JUEVES"
```

Compilar, ejecutar y pasar argumentos, todo en uno, no queda muy elegante en
Gradle.

El filtro de sesión selecciona cualquier elemento que en sus sesiones contenga
la sesión especificada. Dado que es un array, he supuesto que puede haber más
de una.

Cosas que habría que mejorar:
  - Gestión de errores (status http no ok, excepciones conversión json, ...).
  - En el modelo `modified` tendría que pasarse al tipo fecha adecuado.
  - Errores y ayuda de la línea de comandos.

Al intentar decodificar el usuario y password me he encontrado con algo raro:

```
>>> base64.b64decode('cJmAc71jah17sgqi1jqaksvaksda=');
'p\x99\x80s\xbdcj\x1d{\xb2\n\xa2\xd6:\x9a\x92\xcb\xda\x92\xc7Z'
```

¿No son caracteres de texto "visible"? Para no complicarme he pasado la cabecera
a mano.

Al ejecutarlo con gradle los mensajes del build interfieren en las primeras
líneas de stdout, de ahí las opciones `-q --console plain`.

Preguntas técnicas
------------------

### ¿Has aplicado los principios SOLID?

Sí uso algunos de ellos. Intento que las clases sean lo más sencillas posibles
y tengan una única funcionalidad. Favorezco la composición sobre la
herencia, así que no suelo tener herencias complejas. Usar Spring lleva
naturalmente a programar contra abastracciones (interfaces en Java). 

### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

Para realizar la aplicación desconocía el uso de `RestTemplate` de Spring para
hacer la petición http y, por tanto, también las opciones para testear que
existían.

Dada la limitación de tiempo, he preferido programar el cliente y luego
revisar la parte de los tests.

Al final he realizado un mock del servicio web que testea el parsing del
json a objetos Java y que la opción de filtrar funciona.

Se podrían testear también errores en los datos (json) recibidos, respuestas http
no satisfactorias, etc.

Personalmente, en nuestra empresa decidimos hacer solo test de integración de
los procesos complejos. Para aprovechar al máximo el tiempo, esto permite tener
confianza en estos procesos, ya que, en nuestra experiencia, los fallos suelen
ser más de no aplicar correctamente los procesos de negocio que fallos de
programación propiamente dichos. Procesos tipo contabilizar una factura,
calcular el IVA trimestral, facturar todos los alumnos del mes, etc.

### ¿Por qué motivo has elegido el lenguaje que has usado para este test?

Es el que más domino y es una buena opción por todo el ecosistema de librerías
que existe y su rendimiento.

### ¿Cómo mejorarías la API que has usado?

Añadiendo un parámetro para filtrar por el nombre de la sesión, permitiendo al
servidor optimizar la consulta y reduciendo la transferencia de datos.

### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Dada la cabecera `x-powered-by: Express`, supongo que usará el framework
Express.js y JavaScript (o algún lenguaje _transpilado_ a JS).

### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

Sí, por la cabecera `access-control-allow-origin: *`.

### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

Se está utilizando Amazon Web Services:
  - CloudFront.
  - API Gateway.

Podría ser por reducir costes (de infraestructura, mantenimiento), por que
con su multitud de servicios cubrís todas vuestras necesidades, por fiabilidad
comparados con otros proveedores, por flexibilidad, por que teníais experencia
previa con AWS y queríais aprovechar esos conocimientos.

### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

Dependerá del sistema (servidor monolítico, micro servicios, ...). Pero en
general habría que averiguar si el problema está en el servidor, en el cliente,
o ambos.

Luego habría que obtener la mayor información posible. Para ello se pueden
utilizar las herramientas de monitorización y alertas que existan.
Herramientas de inspección del runtime en tiempo real. Los diferentes
sistemas de logging de que se dispongan en servidores, bases de datos u otros
servicios (analizar mensajes de error, métricas, etc).

Idealmente se debería poder conseguir reproducir el problema, con lo que se
podría repetir en local y hacer todas las pruebas que se consideren oportunas
sin afectar al sistema de producción o a los clientes.

Sí lo he tenido que hacer en una aplicación servidor + cliente SPA.
Normalmente han sido casos como servicios que no realizaban
consultas optimizadas o procesos batch que duraban demasiado.

### Descríbete a ti mismo usando JSON.

```json
{
  "name": "Roberto",
  "lastname": "Ferreras",
  "age": 36,
  "nationality": "Spain",
  "livesin": "Castellón",
  "education": "Computer Scientist",
  "skills": [
    "Java", "Spring", "Flex", "AWS", "Linux", "vi"
  ],
  "passions": [
    "Mountain biking",
    "Cars",
    "Technology"
  ]
}
```
