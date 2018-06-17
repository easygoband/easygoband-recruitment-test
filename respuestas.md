#### ¿Has aplicado los principios SOLID?
Sí, en el servidor se ha separado por servicio, handler y main. En el cliente se ha creado un componente
para la tabla y filtro y se ha creado un servicio que se encarga de proporcionar la información del servidor al resto de componentes. 
#### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
1 semana.  Posiblemente habría hecho una gráficas para agrupar las sesiones y mostrar cuántas hay de cada una. 
#### ¿Por qué motivo has elegido el lenguaje que has usado para este test?
Me han obligado :( Al ser el test para el proyecto de Kotlin y Angular de la empresa, se ha indicado utilizar estos lenguajes.
#### ¿Cómo mejorarías la API que has usado?
Si las sesiones siempre tienen tamaño 1, sería mejor que no fuesen un Array. 
Parece que hay campos como structure_decode que siempre son false. ??
A lo mejor vendría bien exponer un método HEAD que dijese que significa cada campo (posiblemente utilizando json-ld). 
También implementar la posibilidad de filtrar y paginar por parte del servidor. Esto ya dependiendo del tamaño de los datos.
#### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Node.js/Express. Viene en la cabecera de X-powered-by.
#### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
Sí. Primero porque tiene el habilitado en las cabeceras (CORS: * ) y segundo porque sin el CORS no podría 
utilizarse en el navegador por el cliente.
#### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
Viendo muchas cabeceras que empiezan por x-amzn diría que está alojado en AWS. Es 2018 y hay que alojar los 
servidores en la nube: barato, escalable, no riesgos... El porque AWS y no DigitalOcean por ejemplo? Pues supongo porque la 
plataforma de AWS es enorme (RDS, Route 53, incluso machine learning...) y ofrece mucho más que un VPS a secas. 
Lo único malo de AWS realmente es el calculo de precios, que complica mucho el presupuestar el mantenimiento de la infraestructura. 
#### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Pues si el servidor estuviese escrito en Go, utilizaría las geniales herramientas que proporciona (pprof, trace) y vería cual es el bottleneck. Si no, pues tendría que investigar el proceso que consume más memoria, CPU, ... y ya dependiendo del proceso pues se buscaría las herramientas de tracing/profiling para ver 
que funciones se utilizan más tiempo. En concreto, la mejor solución es poner monitorización (por ejemplo, con Datadog o Prometheus) y tener alertas
en caso de que alguna métrica supere algún threshold. 
#### Descríbete a ti mismo usando JSON.
{
	"nombre": "Daniel",
	"edad": 21,
	"lenguaje_programacion_favorito": "Go",
	"ganas_de_trabajar": "enormes",
	"experiencia": "0, solo proyectos personales",
	"estudios": "Grado de Ingeniería Informática en la UJI"
}
#### Extra
Al intentar utilizar TDD he tenido problemas porque he hecho uso de la librería Angular Material 
concretamente [la tabla CDK](https://material.angular.io/cdk/table/overview). 
Al testear la vista, no había forma de que se mostrase los datos en la tabla, aunque internamente si
que los almacenaba en el DataSource. 
Por lo tanto, al intentar hacer pasar los tests veía que no había manera de hacerlo funcionar (en el test no mostraba los datos de la tabla,
mientras que fuera del test sí).
