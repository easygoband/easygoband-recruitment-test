¿Has aplicado los principios SOLID?
Sí, he creado el código de forma que sea flexible, limpio, escalable y mantenible. Mi código cuenta con un bajo acoplamiento y una alta cohesión.

¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
He estado 20 minutos pensando y escribiendo los tests del código, creo que se ajustan bastante a la reducida funcionalidad que se pedía, pero si hubiese tenido más tiempo hubiese hecho un análisis completo de caja blanca de mi código. Además, solo he implementado pruebas unitarias, con más tiempo hubiese implementado también pruebas de aceptación y pruebas de integración.

¿Por qué motivo has elegido el lenguaje que has usado para este test?
He utilizado nodeJS y express para realizar este test ya que son los lenguajes que mejor conozco para realizar backend.

¿Cómo mejorarías la API que has usado?
Mejoraría la API que he pasado haciendo que recibiese por un queryParam el nombre por el que se debe filtrar para que el filtrado se realizase en la propia API, eliminando así posibles problemas con sobrecarga en la red en caso de tener muchas peticiones.

¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Creo que se ha utilizado express para exponer esta API REST.

¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
Creo que esta API no soporta peticiones CORS ya que no cuenta con los encabezados "Access-Control-Allow-Headers" ni "Access-Control-Allow-Origin" ni "Access-Control-Allow-Methods".

¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
La API está alojada en la infraestructura de amazon, Amazon Web Services. Creo que se ha tomado la decisión de alojarla aquí porque amazon ofrece un servicio de bajo coste, en el que solo se factura por aquello que se está utilizando, y además completamente escalable.

¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Para rastrear un problema en producción lo primero que haría sería ver cuando ha ocurrido el problema. Sabiendo el momento en el que ocurre el problema buscaría la carpeta de logs del sistema que ha tenido algún problema en busca de lo que ha fallado. Tener implementado Elasticsearch y Kibana ayudaría mucho a la hora de localizar y entender el problema. Sí que lo he tenido que hacer en la empresa en la que he realizado las prácticas.


Descríbete a ti mismo usando JSON.
{
    "nombre": "Néstor",
    "apellidos": "López Olaria",
    "edad": 21,
    "fechaDeNacimiento": 1999-05-07T15:00:00.000+00:00,
    "rasgos": [
        "físicos":{
            "altura": 1.82,
            "peso": 73.52,
            "colorDePelo": "marrón"
        },
        "carácter": [
            "curioso",
            "afable",
            "trabajador"
        ]
    ],
    conocimientos: {
        "principiante": [
            "Vue",
            "React"
        ]
        "medio": [
            "Microsoft Power Point",
            "Microsoft Project",
            "Jira"
        ],
        "alto": [
            "Eclipse",
            "Java",
            "C++",
            "HTML5",
            "CSS3",
            "javascript",
            "nodeJS",
            "Angular",
            "Elastic Stack",
            "SQL"
        ]
    },
    "hobbies": [
        "Deporte",
        "Programación",
        "Videojuegos",
        "Series"
    ]
}
