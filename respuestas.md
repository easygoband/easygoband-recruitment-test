## Preguntas técnicas
- ¿Has aplicado los principios SOLID?
    
    Tratar la tabla como un componente me ha permitido cumplir con algunos de los principios SOLID pese a no estar hablando de clases de datos sino de elementos de la aplicación. 

    En este caso el principio de responsabilidad unica se cumpliria ya que al tener toda la lógica de la tabla en este componente solo cambiaria si cambiasemos la tabla o su comportamiento quedando así aislada del resto de posibles elementos de la aplicación.

    También esto nos lleva a estar cumpliendo el principio de segregación ya que como el componente "Table" es especifico para una unica función que es la de mostrar y interactuar con la tabla.

    Por otro lado al tratarse de una estructura de componentes el principio de "Abierto/Cerrado" podria cumplirse si entendemos que se pueden añadir funcionalidades creando otros componentes e incluyendolos en Table sin necesidad de modificar este mismo. 


    
- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

    Al ser la primera vez usando Vue la gran parte del tiempo que he empleado ha sido documentandome sobre este framework, en total alrededor de 10 horas.

    Si hubiera tenido mas tiempo al tratarse de la primera vez usando Vue me hubiera documentado más de los estandares que se suelen seguir en este framework y como se suelen organizar en situaciones como consumiendo una api si teniendo la logica para consumirla en el propio componente que usa su respuesta es correcto o es mejor tener esta logica en un store global.

    Y respecto a la propia implementación buscar una forma de que se viera un feedback a la hora de realizar un filtrado por busqueda ya que puede ser que en ciertas ocasiones en las que la tabla no cambia al buscar el usuarui pueda pensar que la busqueda no se ha realizado, al mismo tiempo habira añadido alguna animación de cargando o algo por el estilo mientras esta recogiendo la información de la api.

    Y también habria mirado que hacer si alguno de los campos no existiera en algún objeto como el id y sustituirlo por quiza un "-" u otra forma de mostrar que ese dato no está.

    Y respecto a los test he tenido problemas porque no he encontrado demasiada documentación sobre como esperar actualizaciones del DOM y no he podido hacer todos los test que me habria gustado.


- ¿Por qué motivo has elegido el lenguaje que has usado para este test?

    He usado JavaScript ya que tengo mas experiencia con este lenguaje con TypeScript y en la documentación que he visto se usaba siempre este lenguaje.

- ¿Cómo mejorarías la API que has usado?

    En la forma de los objetos de la lista cambiaria la parte de sessions si siempre solo va a haber un objeto en la lista quitar la lista y añadir dos atributos que sean lo que contenia etse objeto como "session_name" y "session_id". Claro esto seria si solo hubiera un objeto siempre como este caso pero si existe la posibilidad de tener más en ese caso no midificaria nada ya que tampoco se de que se trata la información de la api.

- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información 

    Express y JavaScript pero porque es el único framework que he usado y del resto no conozco mucho.

- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión? 

    Diria que si ya que por lo que he podido leer de CORS permite que se comunique con diferentes dominios. Tampoco estoy seguro porque no conozco si existe otro metodo de permitir estas comunicaciones.

- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión? 

    Diria que en amazon web services. Esta decisión podria darse por lo economico que son sus servicios, que no tienes que preocuparte por el mantenimiento de los servidores y porque varias empresas reconocidas como Netflix usan estos servicios (El año pasado hice una presentación en clase sobre los serverless y me documente de estos servicios y de ahi que conozca estos beneficios)

- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

    Para rastrear un problema de rendimiento en la web se podrian usar la herramienta de desarrollador de chrome que nos muestra el tiempo de cada petición, por otra parte en el propio codigo existen extenciones para ciertas IDEs que muestran el tiempo de ejecución de cada método y juntando esto a test de estres o rendimiento se podria localizar la fuente de este problema.

- Descríbete a ti mismo usando JSON.

```json
{
    "nombre":"Daniel",
    "apellidos" : "Miralles Vargas",
    "ciudad" : "Castellon de la Plana",
    "lenguajes-programación" : [
        {
            "nombre" : "Java",
            "nivel" : "8/10",
        },
        {
            "nombre" : "Dart",
            "nivel" : "6.5/10",
        },
        {
            "nombre" : "C++",
            "nivel" : "7.5/10",
        },
        {
            "nombre" : "JavaScript",
            "nivel" : "7.5/10",
        },
        {
            "nombre" : "Python",
            "nivel" : "7/10",
        }
    ],
    "estudios" : [
        {
            "institución" :"Universidad Jaume I",
            "ciudad" : "Castellón",
            "fecha-inicio" : "09-2017",
            "fecha-fin" : "este més cuando presente el TFG (09-2021)",
        },
        {
            "institución" :"Cork Institute of Technology",
            "ciudad" : "Cork",
            "fecha-inicio" : "09-2019",
            "fecha-fin" : "05-2020 (más o menos por el covid)",
            "erasmus" : true
        }
    ],
    "experiencia" : [
        {
            "lugar" : "Grupo de fluidos multifasicos (UJI) | FACSA",
            "proyecto" : "aplicación de escritorio para la simulación de estructuras de depuración de agua residual para la empresa FACSA en la cual realicé mi estancia en practicas continuando con este mismo proyecto",
            "tecnologias" : ["Qt","C++","Bash (scripts)","docker","wsl","libreria OpenFoam","libreria VTK"],
            "tareas" : "desarrollo de funcionalidades tanto en la parte de back-end como en el front end y visualización de figuras 3D",
            "fecha-inicio" : "06-2020",
            "fecha-fin": "05-2021",
        }
    ],
    "descripción": "Soy un chico apunto de ser graduado en ingenieria informática y desde no hace mucho desarrolle un interés por el desarrollo web y empecé a dedicarle horas ya que por parte de la universidad esta modalidad o el uso de html, css y js no se ve demasiado aunque este ultimo año si tuve la oportunidad de usar React y me gustó bastante.
    
    Considero que soy una persona autodidacta aunque prefiero que gente con más experiencia y conocimientos en campos que no conozco puedan enseñarme y darme un feedback, esto también biene dado a que me gusta el trabajo en equipo sobretodo por esta parte de poder aprender de los demás y mejor de esta manera.
    
    En estos momentos estpy buscando un puesto donde poder edsarrollar estas habilidades de frontend que tanto me interesan y poder aportar todo lo que pueda.",
    "intereses-y-gustos" : ["La programación" ,"el internet de las cosas", "desarrollo web", "desarrollo de aplicaciones moviles", "hacer deporte", "la música", "tocar el piano o la guitarra","videojuegos"],
    "contacto" : {
    	"movil" : "660882176",
    	"correo" : "danielmirallesvargas@gmail.com"
    }

}
```