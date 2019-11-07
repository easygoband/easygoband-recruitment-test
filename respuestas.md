### ¿Has aplicado los principios SOLID?
He aplicado parte de los principios como la S de Single Responsibility Principle (SRP) en los casos de uso que solo tienen una responsabilidad.

### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
Por falta de experiencia en este campo he tardado un par de dias en prepararlos.
Con mucho más tiempo 

### ¿Por qué motivo has elegido el lenguaje que has usado para este test?
Porque es con el que me siento más comodo dado que estoy más experimentado.

### ¿Cómo mejorarías la API que has usado?
Añadiría los filtros y una paginación directamente en la API para no recibir excesivos resultados como sucede actualmente.
También crearía una opción para devolver solo los que se han modificado a partir de cierta fecha,
dado que por disponibilidad he decidido guardar todos los datos en una base de datos local y así solo tendría que hacer petición y comprobar los últimos.

### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Express (Node.js)

### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
Si, porque en los headers aparece el Allow CORS Origin *.

### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
AWS Api gateway, por escalabilidad y alta disponibilidad.

### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Con un Test de estrés en un clon de la infraestructura, aunque nunca he llegado a hacerlo.

### Descríbete a ti mismo usando JSON.
```javascript
{
    "nombre": "Héctor",
    "apellido": "Fernández",
    "email": "hector.jose.fv@gmail.com",
    "linkedIn": "https://www.linkedin.com/in/hector-fernandez-vaquero/",
    "disponibilidad": true,
    "estudios": [
        {
            "nombre": "SMR",
            "inicio": 1410426000,
            "fin": 1474480800
        },
        {
            "nombre": "DAM",
            "inicio": 1473757200,
            "fin": 1529431200
        },
        {
            "nombre": "DAW",
            "inicio": 1536656400,
            "fin": 1561053600
        }
    ],
    "experiencia": [
        {
            "empresa": "Cuatroochenta",
            "cargo": "Desarrollador Backend"
            "inicio": 1552035600,
            "fin": 1570557600
        }
    ]
}
```
