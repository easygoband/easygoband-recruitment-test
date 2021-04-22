# Preguntas técnicas

-   ¿Has aplicado los principios SOLID?

    -   No estoy familiarizado con este término pero por lo que he estado mirando creo que cumplo con las normas SOLID

-   ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

    -   Al ser una aplicación muy simple y sin a penas inputs por parte del usuario no he dedicado mucho tiempo a tests. En el supuesto de que hubiera sido una aplicación comercial habría dedicado más tiempo a asegurarse de que los datos se guardarán correctamente independientemente del input y hardware del usuario, por ejemplo al aumentar el número de usos de cada entrada, en este caso. Hay muchas cosas que podría añadir, como por ejemplo soporte para nfc para que se pueda hacer uso de las pulseras nfc, o alertas si en caso de comportamiento sospechoso, como varios usos de una misma entrada en un breve periodo de tiempo.

-   ¿Por qué motivo has elegido el lenguaje que has usado para este test?

    -   He usado kotlin para desarrollar la app en android y nodeJS para el backend. Hace unos años ya desarrollé una pequeña app para android con kotlin y pensé que sería bueno refrescar y ampliar esos conocimientos, ya que según me habéis dicho sería el lenguaje que usaría en caso de trabajar para vosotros. Respecto al backend mi idea inicial era usar spring con kotlin, a pesar de que he conseguido hacer avances y creo que con un poco más de tiempo podría haberlo hecho he tenido que recurrir a nodeJS para poder terminar el proyecto a tiempo.

-   ¿Cómo mejorarías la API que has usado?

    -   Añadiría más datos, por ejemplo cuando se creó la entrada, en vez de solo saber su última modificación.

-   ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

    -   Se ha usado NodeJS y Express.

-   ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

    -   Creo que sí que soporta peticiones cortas, dado que he probado a hostear el backend para mis pruebas y no me ha dado ningún problema, además teniendo en cuenta que la API requiere autentificación, creo es lógico permitir llamadas a cualquiera que introduzca los credenciales.

-   ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

    -   Está alojada en AWS. Creo que lo habéis usado porque es, según tengo entendido, el mejor servicio para hostear webs o APPs, además de ser muy fácil de escalar en caso de necesario y ser muy fiable.

-   ¿Cómo rastrear un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

    -   Nunca he tenido que rastrear un problema en producción pero creo que lo primero sería saber qué usuarios se han visto afectados para poder investigar qué parte del servicio está causando el problema. También creo que es muy importante refactorizar el código de vez en cuando para así poder optimizarlo.

-   Descríbete a ti mismo usando JSON.

```
{
    "name": "Lluís Muñoz Ladrón de Guevara",
    "fecha nacimiento": "02-11-1997",
    "estudios": ["2 años de ingeniería industrial", "DAM", "DAW"],
    "lenguajes de programación": {
        "conozco y estoy cómodo": [
            "JavaScript",
            "Java",
            "Python",
            "PHP",
            "CSS",
            "SQL"
        ],
        "he usado en ocasiones": ["kotlin", "C#"],
        "quiero aprender": ["Ruby", "C++"]
    },
    "Puntos fuertes": [
        "ganas de aprender",
        "trabajo bien bajo presión",
        "asertivo",
        "me gusta ayudar a mis compañeros siempre que pueda",
        "me gusta aprender de cualquier consejo que me den"
    ],
    "Puntos débiles": [
        "falta de experiencia",
        "tengo que mejorar mi diseño de interfaces a nivel estético"
    ]
}
```

-   Datos sobre la app que considero relevantes:
    -   La app se ha desarrollado sobre con "minSdkVersion 19", ya que según tengo entendido es lo más habitual para apps comerciales y unas lineas de diseño muy simples, dado que he preferido dar prioridad a la funcionalidad.
    -   El backend se ha desarrollado con nodeJS y Express, en caso de una app comercial tendría más funciones, pero en este caso se limita a hacer un filtrado de datos de la API que me facilitasteis. He decidido ejecutarlo en heroku para poder realizar pruebas con mi teléfono, lo he dejado desactivado, pero si queréis que lo active para poder probar la app poneos en contacto conmigo y lo activare lo antes posible, lo desactiva permanentemente una vez se haya completado la prueba.
