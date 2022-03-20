# easyGOband Recruitment Test


El test consiste de dos partes:

- Test de código
- Respuestas cortas a las preguntas que planteamos más abajo.

## Test de código

Hemos preparado una api REST que devuelve en formato JSON un listado de proveedores de acceso.

```
https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/{eventId}
```

La ID del evento que hemos preparado para vosotros es: 1

Para poder autenticar contra la API se debe enviar la siguiente cabecera: 

```
Authorization: Basic cJmAc71jah17sgqi1jqaksvaksda=
```

La tarea consiste en programar un cliente que consulte esta API mostrando sus resultados y el usuario final de dicho cliente pueda filtrar por el nombre de la sesión.

### Requisitos 
- Siéntete libre de usar el lenguaje que creas más oportuno.
- Aplica TDD o BDD.
- Muestra la mayor cantidad de información posible.
- El código debe compilar y ejecutarse en un paso.
- Puedes usar los frameworks y/o librerías que creas oportunos.

## Preguntas técnicas
Responde a las siguiente preguntas en un fichero markdown.
- ¿Has aplicado los principios SOLID?
  - si, el framework usado para esta prueba lo considera
- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
  - AL rededor de un dia, hubiera agregado alguna autentificación para usuarios, 
- ¿Por qué motivo has elegido el lenguaje que has usado para este test?
  - laravel es una proderosa herramienta que incluye ya un conjunto de librerias que ayudan al desarrollo rapido de sistemas o APIs
- ¿Cómo mejorarías la API que has usado?
  - Me gustaria Integrar alguna autentificación por usuario ya que laravel tiene modulos interesantes <br> con los que se puede trababar mas rapido
- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
  - Nodejs/Express
- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión? 
  - No acepta, al relizar una prueba con postman nos regresa las cabeceras de respuesta la cual no incluye Access-Control-Allow-Origin, Access-Control-Allow-Headers y Access-Control-Allow-Methods 
- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
  - AWS, Actualmente es de la mejores y cuenta con muchas opciones para la implementacion de sistemas, ademas de que en un crecimiento se puede hacer escalable ademas de que siempre se encuentra innovando
- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
  - se puede hacer con algunas herramientas como postman, esta herramienta cuenta con monitores y estadisticas que arroja cuando se hace una preticion nueva , aun no he tenido oportunidad
- Descríbete a ti mismo usando JSON.
```json
{
   "nombre":"fernando",
   "edad":36,
   "ciudad_origen":"guanajuato",
   "profesion":"Desarrollador Fullstack",
   "habilidades_tecnologicas":{
      "soporte":true,
      "redes":true,
      "habilidades_de_programacion":{
         "lenguajes":[
            "php",
            "javascrip",
            "html",
            "css",
            "sql"
         ],
         "bases_de_datos":[
            "mysql",
            "posgrest",
            "sqlserver"
         ],
         "frameworks":[
            "laravel",
            "codeigniter",
            "angularjs",
            "bootstrap"
         ]
      }
   },
   "estado_civil":"casado",
   "hobbies":[
      "andar en moto",
      "ver series"
   ]
}
```


## Entrega
Puedes hacernos llegar este test abriendo un pull request a partir de un fork de este mismo repositorio aquí en github. 

El código dentro de una carpeta "src" y las respuestas a las preguntas en un fichero "respuestas.md"

Muchas gracias por tu tiempo.
