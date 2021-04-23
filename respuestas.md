# Preguntas Test


- ¿Has aplicado los principios SOLID?

En general, dentro de lo posible en esta aplicación, sí se han aplicado.



- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

Probablemente dediqué al menos una hora para organizar las ideas, decidir las tecnologías que iba a necesitar y planificar el proyecto. Una vez hecho esto, comencé con el desarrollo. Al verse interrumpido por unos días, no sabría decir con exactitud el tiempo total que me llevó, pero aproximadamente calculo que le dediqué unas 8 horas.

En general, al tratarse de una aplicación con una función bastante sencilla no le añadiría más cosas como tal. Mejoraría como se muestran los datos, aspectos estéticos y, principalmente, la lista de proveedores de acceso. En este último caso, se obtiene de la API todos los proveedores. Si la cantidad de proveedores fuera muy grande, se tendrían que obtener todos a la vez y se mostrarían en una lista inmensa. Una solución sería que la API permitiera hacer peticiones con paginación, limitando el número de elementos de la colección que puede devolver.



- ¿Por qué motivo has elegido el lenguaje que has usado para este test?

Dentro de los lenguajes más comunes en la programación para Android, Java es probablemente el lenguaje con el que me siento más cómodo y con el que estoy acostumbrado a trabajar en el desarrollo de aplicaciones móviles.



- ¿Cómo mejorarías la API que has usado?

Se podría permitir obtener los datos filtrados, aplicar paginación o, para este caso, obtener los datos ordenados en base a algún campo específico, como por ejemplo el de nombre o fecha de modificación.
También se podría plantear cambiar el método de autentificación de Basic authentication por otro que pueda garantizar mayor seguridad.



- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Consultando la información del encabezado HTTP con el comando curl, se puede ver que el framework utilizado es Express.js. El lenguaje utilizado debe ser Javascript.



- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

Creo que sí. Al utilizar el comando ‘curl -I’ he obtenido en la respuesta a la petición la cabecera CORS ‘access-control-allow-origin: *’, que indica que se permite a cualquier origen el acceso a los recursos.



- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

Está almacenada en Amazon Web Service (AWS).  Probablemente sea por la gran variedad de servicios que ofrece, siendo de fácil uso y teniendo bastante documentación de apoyo. Además es escalable y los precios se ajustan al uso. 



- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

Para detectar problemas de rendimiento llevaría a cabo al menos alguno de los cuatro tipos de test siguientes, destinados a ese fin: test de carga, de estrés, de capacidad o de rendimiento.

La verdad, no he tenido que hacerlo antes. Siempre las pruebas que he realizado se han centrado en que el código no falle y cumpla su función, pero no tanto en su rendimiento. Es por ello, que tengo bastante interés en ampliar mi experiencia en ese aspecto.



- Descríbete a ti mismo usando JSON.

{
“nombre”: “Víctor”,
“apellido”: “Colejo”,
“genero”: “hombre”,
“edad”: 24,
“ciudad”: “Ponferrada”,
“intereses”: [“videojuegos”, “arte”, “series”, “deporte”, “gatos”],
“estudios”: [{“título”: “Grado en Diseño y Desarrollo de Videojuegos”,
			“universidad”: “Universidad Jaume I”,
                “año”: 2019
        },
        {“título”: “Máster en Ingeniería Informática”,
        “universidad”: “Universidad de León”,
                “año”: 2021
        }]
}










}