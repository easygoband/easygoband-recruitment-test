¿Has aplicado los principios SOLID?

He aplicado los principios y siempre lo hago en mis proyectos para que queden afianzados en mí y cada vez sea más rápido el aplicarlos y salga como opción sin pensar expresamente en que tengo que aplicarlos. 

Dicho esto, me encantaría que si hay secciones de mi código en las que creeis que se puede mejorar o que no se han aplicado correctamente me lo comuniqueis y lo comentamos!

¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

Desde el principio (organizar ideas en papel) he tenido en cuenta que debía asegurarme de que los datos eran correctos antes de conectar las distintas partes del código. 

Debido a que las comprobaciones iban al mismo tiempo que el desarrollo del propio código, no sabría decir el tiempo exacto; Pero por poner una aproximación, y contando Logs en el términal y mis própias comprobaciones mediante la interfaz, diría que cerca de 60% tests 40% desarrollo.

De haber tenido mucho más tiempo, habría creado FakeClasses para tener simulaciones de datos y para comprobar mediante Tests que las clases interactuan entre ellas adecuadamente. También habría creado interfaces que compartieran las clases reales y las FakeClasses para así poder testear los distintos métodos que contienen las clases y los estados de los LiveData en puntos concretos del proceso lógico.


¿Por qué motivo has elegido el lenguaje que has usado para este test?

Kotlin es un lenguaje que llevo utilizando para el desarrollo Android cerca de 1 año, es el lenguaje que recomienda Google para los desarrollos en Android y tiene beneficios como que es un lenguaje sencillo de escribir, puede ser utilizado en un proyecto Java, fácil de leer y fue ideado pensando en la productividad del desarrollador.


¿Cómo mejorarías la API que has usado?

En la key sessions, hay una lista con un único objeto. A menos que se espere añadir en el futuro más objetos dentro de esta lista de sessions, una mejora sería cambiar esa lista por un objeto.



¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Según vuestra oferta de trabajo, el lenguaje que utiliza vuestro servidor es Kotlin. Al éste ser compatible con librerías de Java, debéis de utilizar algun framework que facilite la codificación mediante anotaciones, por ejemlo, para exponer la informacion de vuestras bases de datos. El primer framework que me viene a la mente es Spring. También, por supuesto, tendreis bases de datos (MySQL por ejemplo), y un framework de persistencia que haga la comunicación entre la base de datos y Kotlin.

¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

Soporta peticiones CORS ya que, tras testear la respuesta de la API, en sus Headers, he encontrado el siguiente campo

access-control-allow-origin: *

Esto significa que acepta todos los origenes


¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

La API está alojada en servidores en la nube propiedad de la empresa Amazon.

Esta decisión puede haber sido tomada por diversos factores, entre ellos está 

- no preocuparse por el hardware y su posición física
- la seguridad de los servidores o la disponibildad de ellos (perdida de internet, ataques cibernéticos, etc.),
- el servicio técnico 
- agregación de nuevo hardware durante un tiempo determinado.



Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?



Descríbete a ti mismo usando JSON.

{
	nombre: "Sergio",
	apellidos: [
		"Ribera",
		"Mateu"
	],
	edad: 28,
	localidad: "Ribarroja del Turia",
	ejercicio: true,
	juegos: [
		{
			nombre: "Tzar",
			edad: 21
		},
		{
			nombre: "Age of Empires 2",
			edad: 22
		},
		{
			nombre: "Imperium 3",
			edad: 16
		}
	],
	mascota: true
}


