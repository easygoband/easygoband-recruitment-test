# Preguntas Técnicas

### ¿Has aplicado los principios SOLID?
No diria que haya aplicado todos los principios SOLID pero cabe destacar que la tabla al estar realizada en un componente Vue permite que se cumpla el 
principio de Responsabilidad Única, ya que su comportamiento y lógica está separada del resto de componentes o elementos del proyecto. Además el principio de 
Segregación de la Interfaz también lo cumpliría, ya que la tabla realizada en un componente tiene una finalidad concreta: mostrar, ordenar, buscar, etc.


### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
Si os referís al tiempo que he tardado en realizar esta prueba, serían unas 6 horas ya que he tenido que buscar documentación sobre Vue.js y refrescar
lo aprendido anteriormente en la Universidad. Si se trata de los test unitarios realizados, al haber realizado una tabla y haber implementado un par de funcionalidades,
no he realizado muchos test unitarios, además de haberme costado encontrar documentación alguna sobre estos. Si hubiera tenido más tiempo habría realizado más test unitarios y mejorado el diseño de la página.


### ¿Por qué motivo has elegido el lenguaje que has usado para este test?
Se ha usado el framework Vue.js y el lenguaje que utiliza dicho framework es JavaScript, además de añadir BootstrapVue como librería para facilitar el diseño de la web. He utilizado dicho framework
porque ya lo conocía, es bastante intuitivo y tenía conocimientos previos.


### ¿Cómo mejorarías la API que has usado?
Tras observar la lista que devuelve la API me he dado cuenta que el atributo "session" es un array con un solo objeto, sería más sencillo trabajar con dichos datos si se quita la lista 
y se añaden dos atributos. También se podría mejorar la autorización a la API, cambiandola de la básica por otra más segura como tokens de auth 2.0.


### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Al haber utilizado Postman para realizar pruebas con la API, he podido observar que la API se ha realizado con Node.js(JavaScript) ya que en la cabecera recibida aparece "z-powered-by: Express",
y Express es un framework para backend que utiliza Node.js.


### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
La API soporta peticiones CORS, ya que al observar la cabecera recibida se puede encontrar el parámetro "access-control-allow-origin: *". 
Esto significa que el recurso puede ser compartido desde cualquier origen.


### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
Se ha alojado en Amazon web services, se puede ver en el enlace proporcionado, y además si observamos la cabecera podemos ver que se ha usado Amazon CloudFront,
se trata de un servicio rápido de red de entrega de contenido (CDN) que distribuye datos, vídeos, aplicaciones y API a clientes de todo el mundo de forma segura, con baja latencia, 
altas velocidades de transferencia e integración total con AWS, supongo que por estos motivos se tomó dicha decisión.


### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
No he tenido que afrontarme a dichos problemas reales de rendimiento pero creo que detectando y verificando los tiempos de carga, errores en las peticiones realizadas y 
errores en funcionalidades implementadas recientemente se podría localizar el problema, aislarlo y empezar el proceso de eliminación de dicho problema.


### Descríbete a ti mismo usando JSON.
```json
{
	"Nombre": "Pedro",
	"Apellidos": "Giménez Aldeguer"
	"Fecha de nacimiento": "05/07/1998",
	"Provincia": "Alicante",
	"País": "España",
	"Correo": "pedrogial@gmail.com",
	"Descripción": "Soy una persona con mucha motivación a la hora de afrontar los diferentes obstáculos 
	que se me presentan en el día a día. Dispuesto a trabajar para poner en práctica todos mis conocimientos 
	y aprender más sobre mi pasión, el desarrollo web y software. Capacidad para trabajar en equipo, compartir
	opiniones, escuchar a mis compañeros y debatir desde un punto de vista razonable y con fines positivos para 
	así mejorar la situación del equipo y el proyecto común",
	"Estudios": 
	[
		{
		"Institución" :"CICE Escuela Profesional de Nuevas Tecnologías",
		"Estudio": "Máster en Desarrollo de Videojuegos con Unity"
		"Ciudad" : "Madrid",
		},
		{
		"Institución" :"Universidad de Alicante",
		"Estudio": "Grado en Ingenieria Informática especializado en Software",
		"Ciudad" : "Alicante",
		}
	],
	"Experiencia": 
	[
		{
	    	"Empresa" : "SWISS4WARD EUROPE S.L.",
	    	"Proyecto" : "Creación de una página web mediante un CMS (Gestor de Contenidos)",
	    	"Tecnologías" : ["JavaScript", "Node.js", "ApostropheCMS", "MongoDB", "CSS", "HTML"],
	    	"Tareas" : "Desarrollador tanto del backend como del frontend de la página web",
		}
	],
	"Hobbies":
	[
	"Tecnología",
	"Videojuegos",
	"Series",
	"Cine",
	"Viajar",
	"Música",
	"Deporte"
	],
}
```

