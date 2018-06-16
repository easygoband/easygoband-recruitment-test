# easyGOband Recruitment Answers

- ¿Has aplicado los principios SOLID?
Sí, en concreto la separación de responsabilidades, la abstracción de clases y el principio de extensión.
- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? 
Aproximadamente 3 horas debido a que he usado Gherkin y aunque ya lo conocía, no había usado la integración con el código, sólo la escritura de historias de usuario.
- ¿Cómo mejorarías la API que has usado?
La mejoraría usando corutinas de Kotlin para que cada tarea ya bien sea, una consulta o una modificación, sea asíncrona y no sobrecargar el backend. También añadiendo una capa de seguridad.
- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información 
Acorde con los headers de la respuesta, ExpressJS como framework y JavaScript/TypeScript como lenguaje.
- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión? 
Sí, ya que el backend no ha tenido ningún problema en recibir los datos de la API. Sin embargo para asegurarme, he usado antes de todo www.test-cors.org y confirmo que sí soporta CORS.
- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión? 
Viendo la URL, está alojada en AWS. Esto puede ser así, debido a que la velocidad de escalado de Amazon es idónea para que en un momento dado, si la API recibe demasiadas peticiones, escale y pueda suplir esa demanda. También por el costo de mantenimiento y la facilidad de uso.
- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
En mi breve experiencia usando la filosofía DevOps, he utilizado herramientas como Sentry.io para monitorizar las incidencias y sobretodo las excepciones que se producen. Esta herramienta captura el stacktrace e informa de la línea en la que se ha producido y el origen del problema (Información de la IP del cliente, navegador...).
- Descríbete a ti mismo usando JSON.
```
{
	"name": "Albert",
	"surnames": "Sendrós Jiménez",
	"age": "24",
	"interpersonal_abilities": ["charming", "teamwork", "communication", "open minded"],
	"education": [{
			"institution": "Cork Institute Technology",
			"degree": "Software Development"
		},
		{
			"institution": "Universitat Jaume I",
			"degree": "Computer Science Engineering"
		}
	],
	"coding_languages": ["Kotlin", "Java", "Swift", "Javascript", "TypeScript", "Python", "Bash-Scripting"],
	"frameworks": ["Spring MVC", "Flask", "Angular", "Spark"],
	"databases": ["MongoDB", "PostgreSQL", "Oracle"]
}
```
