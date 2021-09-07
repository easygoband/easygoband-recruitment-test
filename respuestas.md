## Respuestas a las preguntas técnicas



**¿Has aplicado los principios SOLID?**

En un desarrollo sencillo como este, es complicado poder aplicar cada uno de los principios SOLID. 
Creo que en conjunto he conseguido satisfacer los objetivos que buscan estos 5 principios a la 
hora de la escritura de código ya que he creado un código escalable, robusto y con flexibilidad para
poder modificarse fácilmente siempre que surjan nuevas necesidades.



**¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo...
¿que habrías añadido?**

En total he necesitado unas 7-8 horas para la escritura de los tests del código, ya que también he
empleado tiempo en pensar que tests serían interesantes de escribir y luego he tenido que dedicar
unas 2-3 horas más para probar que todo funcionase correctamente y mejorar la legibilidad y evitar 
la repetición de código.

Si hubiese tenido más tiempo hubiese añadido otras funciones como por ejemplo la obtención de los
resultados devueltos en diferentes formatos o poder contar la cantidad de registros que coinciden
con los filtros que se apliquen.



**¿Por qué motivo has elegido el lenguaje que has usado para este test?**

He pensado al principio qué sería lo mejor para lo que me estais pidiendo. El principal objetivo
es la realización de operaciones simples (consultas a la API) de manera rápida. Hay varios lenguajes
de programación que pueden realizar esta operación aunque Javascript, y más concretamente su entorno de
ejecución Node.js, permite la creación de aplicaciones de red rápidas y con una elevada escalabilidad.
Si además le añadimos el framework Express, nos permite agilizar el proceso de manejar las solicitudes
de HTTP, cosa que será determinante a la hora de ofrecer una API con las características requeridas.

Con lo cual, he usado el lenguaje Javascript por ser, a mi parecer, el lenguaje más adecuado para la
correcta implementación de los requisitos del test. 



**¿Cómo mejorarías la API que has usado?**

En primer lugar veo que cada uno de los access_group_id se corresponde con un access_group_name con
lo cual cada uno de los dos campos representa un identificador único del grupo de acceso de manera
independiente, con lo que yo no mostraría uno de los dos (dejaría quizás el nombre para que se
pueda obtener una mejor información, aunque dependería más de qué campo le sería de más utilidad al
receptor de la información.
En segundo lugar, lo mismo ocurre con los campos id y name. Entiendo que id es el identificador único,
aunque el campo nombre también es único para cada uno de los datos. 



**¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? 
Consejo: En el protocolo HTTP viaja mucha información**

Se ha utilizado el framework Express para exponer la API, ya que en la cabecera
se especifica la tecnologia que da soporte a la aplicación, y el lenguaje de programación Javascript.



**¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?**

Si que soporta peticiones CORS ya que se puede observar la cabecera Access-Control-Allow-Origin con el
valor *, que permite a cualquier origen el acceso a los recursos de la API. 



**¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?**

La API se encuentra alojada en la nube, concretamente en Amazon Web Services (AWS) ya que se puede 
observar tanto en la URL como en diversas cabeceras que incluye la API. Creo que habeis tomado esa
decisón como parte de la obtención de los diversos beneficios que ofrece el cloud: seguridad, flexibilidad,
escalabilidad, reducción de costos, eficiencia, etc. 



**¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?**

En primer lugar realizaría diferentes pruebas para comprobar de donde procede el problema de rendimiento
y una vez descubierto el problema, pasaría al entorno de pruebas para realizar diferentes correcciones
con el fin de mejorar el rendimiento. Una vez resuelto, aplicaría el cambio en producción en un momento
de baja interacción de los usuarios para evitar al máximo entorpecer su uso. No he tenido que hacerlo
pero en mi anterior trabajo ví como mis compañeros realizaban los pasos. 



**Descríbete a ti mismo usando JSON.**
```json
{
	"nombre" : "Iván",
	"apellidos" : "Guimerà Fontanet",
	"edad" : 28,
	"lenguajes de programación": [
		{
			"nombre": "Javascript",
			"nivel": "Medio"
		},
		{
			"nombre": "C#",
			"nivel": "Bajo"
		},
		{
			"nombre": "Python",
			"nivel": "Alto"
		},
		{
			"nombre": "Java",
			"nivel": "Medio"
		}

	],
	"softskills": ["Pensando en crecer", "Resiliencia", "Responsabilidad", "Trabajo en equipo", "Proactividad", "Honestidad"],
	"Intereses profesionales" : ["Cloud computing", "Data Science", "Full Stack Development"]
}
```
