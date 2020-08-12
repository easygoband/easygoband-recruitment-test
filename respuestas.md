- ¿Has aplicado los principios SOLID?

    He aplicado principios SOLID con el loop de las opciones del filtro avanzado, que permite ampliarlas fácilmente.

- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

    Si hubiera tenido más tiempo hubiera aprendido a utilizar una herramienta de testing, pero he priorizado no retrasar la entrega. También habría utilizado un navigation drawer en el menú hamburguesa.

- ¿Por qué motivo has elegido el lenguaje que has usado para este test?

    Porque se me requirió utilizar Vue y Vuetify en esta prueba técnica y JavaScript es el lenguaje con el que tengo más experiencia.

- ¿Cómo mejorarías la API que has usado?

    Incluiría el nombre del evento en la respuesta y dejaría la propiedad sessions para /{eventId}/sessions si pudiera contener mucha información.

- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información 

    Javascript y Express.js.

- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión? 

    Sí. En los header aparece "access-control-allow-origin".

- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión? 

    En Amazon Web Services. No conozco la infraestructura, así que no sabría decir el motivo.

- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

    No he rastreado ninguna vez un problema de rendimiento en producción, pero me fijaría en primer lugar en las iteraciones de código.

- Descríbete a ti mismo usando JSON.

    {
        "nombre": "Iván",
        "primer_apellido": "Francés",
        "segundo_apellido": "Alcántara",
        "edad": 25,
        "experiencia_laboral": [
            {
                "empresa": "Tacubaya Consulting",
                "fecha_inicio": "2020-1-10",
                "fecha_fin": "2020-7-10",
                "descripción": "Creación de scripts asíncronos para trasladar información de documentos varios a ala herramienta de orquestación de laboratorio Velocity para Orange Barcelona."
            },
            {
                "empresa": "株式会社ヒューマニック",
                "fecha_inicio": "2019-7-10",
                "fecha_fin": "2019-9-10",
                "descripción": "Asistente de cocina y jardinero en Nakafurano."
            },
        ]
        "educación": [
            {
                "curso": "Web Development Bootcamp",
                "instituto": "Ironhack",
                "lugar": "Barcelona",
                "fecha_inicio": "2019-8-10",
                "fecha_fin": "2019-12-10",
            },
            {
                "curso": "Traducción e Interpretación",
                "instituto": "Universitat Autònoma de Barcelona",
                "lugar": "Barcelona",
                "fecha_inicio": "2019-8-10",
                "fecha_fin": "2019-12-10",
            }
        ]
        "tecnologías": [ "JavaScript", "CSS3", "React.js", "HTML5", "Python", "SASS", "MongoDB", "Node.js", "jQuery", "SQL", "Git", "GitHub", "Postman", "Redux", "Express.js", "API" ],
        "hobbies": [ "videojuegos" ],
        "practica_deporte": false
    }
