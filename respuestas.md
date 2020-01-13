Aclaraciones
------------

He elegido programar en Kotlin por utilizar el lenguaje que impera hoy en día para programar en Android. Aunque nunca 
había programado antes en este lenguaje me ha servido para iniciarme en él y descubrir las diferencias con Java y sus
bibliotecas propias.

Se compila y se ejecuta el módulo easyGObandRecruitmentTest.kt con una de las siguientes opciones:
 * --all (para listar todos los elementos recibidos)
 * --names (para listar los nombres de sesiones válidos)
 * --filter \<sessionName\>, donde \<sessionName\> es un valor de un nombre de sesión válido. De estar mal escrito el
  programa indicará cuáles son los nombres de sesión válidos.
  
Internamente el método  getURL() de la clase GetData puede parametrizarse indicando un valor diferente 
al predeterminado. Aunque, evidentemente, no hay posibilidad de cambiar este valor pues como indica el enunciado el 
valor debe ser 1. 

Preguntas Técnicas
------------------
#### ¿Has aplicado los principios SOLID?
Los he aplicado en su mayoría, dándole una única resposabilidad a cada método, por ejemplo.

#### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
En general tanto el código fuente como los tests los he ido haciendo en mi tiempo libre, por lo que ha sido muy intermitente
y difícil de cronometrar/calcular. Los tests los he hecho en una tarde, primero averiguando como debían implementarse en Kotlin,
puede que en cosa de cuatro horas.

He intentado que el test verifique que los datos obtenidos sean acorde al tipo de dato esperados. Aunque debería haberlo hecho
en base a los datos que devuelve el servidor, he usado los que obtiene la clase Element.

#### ¿Por qué motivo has elegido el lenguaje que has usado para este test?
Inicialmente hice un esbozo en Python, que es el lenguaje que más domino, aunque quise aprovechar la ocasión para experimentar
con Kotlin que me pareció mucho más adecuado para los tiempos que corren por la premisa de Google: "Android development will become increasingly Kotlin-first".

#### ¿Cómo mejorarías la API que has usado?
Debería permitir filtros y paginación de los datos devueltos. Los filtros podrían ser tanto de un periodo comprendido 
entre dos fechas como de un cierto nombre de sesion permitiendo algun tipo de comodín o expresiones regulares.

#### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Javascript con el marco de trabajo Express.js (NodeJS).

#### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
Sí, ya que en los encabezados aparece `access-control-allow-origin: *`.

#### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
Por la dirección de la API proporcionada se deduce que está alojada en Amazon Web Services (AWS), supongo que por su
escalabilidad y su disponibilidad.

#### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Habría que identificar y localizar el problema. Lo primero es descartar que sea un problema de _hardware_. Luego analizar
Luego analizar desde las conexiones a la base de datos, sus consultas, etc.

Sí, tanto en programas propios, como en tareas asignadas en mi empleo.

#### Descríbete a ti mismo usando JSON.
```json
{
    "nombre": "Igor",
    "apellidos": "Remolar Detœuf",
    "nacionalidad" : "española",
    "edad": 43,
    "lugar_nacimiento": {
      "población": "Ivry-sur-Seine",
      "provincia/estado": "Val-de-Marne",
      "país": "Francia"
    },
    "linkedIn": "https://www.linkedin.com/in/igorremolar/",
    "incorporación_inmediata": true,
    "estudios": [
        {
            "nombre": "Grau en Enginyeria Informàtica",
            "inicio": "2016-09-12",
            "fin": "2018-07-23",
            "cursos": [1, 2]
        }
    ],
    "experiencia_laboral": [
        {
            "empresa": "Heratic Consulting",
            "cargo": "Integrador de Software",
            "descripción": [
                "PowerBuilder", "SQL Server"
            ],
            "inicio": "2018-10-01",
            "fin": "2019-04-31"
        },
        {
            "empresa": "Amical Viquimèdia",
            "cargo": "becario",
            "descripción": [
                "Python", "JavaScript", "despliegue de Moodle"
            ],
            "inicio": "2010-05-01",
            "fin": "2010-10-31"
        },
            
    ],
    "conocimientos": {
      "lenguajes" : ["Java", "JavaScript", "Turbo Pascal", "PowerScript", "Python"],
      "bases_de_datos": ["MySQL", "SQL Server", "SQLite", "PostgreSQL", "MariaDB"]
    },
    "idiomas": {
      "francés": "c2",
      "castellano": "c2",
      "valenciano": "grau mitjà (JQV)",
      "inglés": "b2"
    } 
}
```
