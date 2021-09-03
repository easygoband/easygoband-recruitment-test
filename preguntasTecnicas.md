¿Has aplicado los principios SOLID?

Si los usé porque Vue.js con su estructura ayuda a hacer el codigo, organizandolo por componentes, usando metodos reutilisables para la funcionalidad requerida, como la busqueda o los filtros

¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

no hice tests por falta de tiempo, pero he estado leyendo sobre la importancia de crear unit tests, y mantenerlos
Si hubiera tenido mas tiempo habria hecho mejor el diseño, depronto manejar la parte de la conexion al API de manera mas escalable para q luego pudiera cambiar el eventId y q funcione con columnas dinamicas

¿Por qué motivo has elegido el lenguaje que has usado para este test?

El lenguaje usado es JS, ya que Vue.js y el front end se realizan en ese lenguaje, usé una plantilla de webpack para poder usar componentes single file (.vue) y la razón por la que usé vuetify es porque consideré que era la mejor opción para crear una tabla porque v-data-table es un componente que permite adjuntar funciones a las tablas con mayor facilidad que otros pluggins de vue

¿Cómo mejorarías la API que has usado?

La API usada se puede mejorar con un metodo de autenticacion basado en tokens auth 2.0 para no tener una autenticacion basica q puede resultar en abusos desde alguna otra pagina

¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

EXPRESS.Js, se puede ver en los headers del api donde dice x-power-by: Express

¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

si, porque en el Acess-Control-Allow-Origin es un \* lo que indica que lo pueden llamar desde cualquier otro dominio, si tuviera el dominio en específico no permitiría que nadie mas lo llame

¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

está alojado en Aws Amazon web services, porque es la plataforma en la nube más segura, amplia y confiable

¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Descríbete a ti mismo usando JSON.

no he tenido experiencia en eso pero creo que a través del network con los codigos de información de la api podría guiarme para ver si hay un problema y en caso de que lo haya supongo que sería por una limitante de rest
yo usando JSON me describo como una persona que ante todo quiere mantener el orden, pienso que ees indispensable para el manejo de cualquier tipo de información llevar una guia de como se debe manejar esta
