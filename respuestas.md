#### ¿Has aplicado los principios SOLID?
Sí, en el servidor se ha separado por servicio, handler y main. En el cliente se ha creado un componente
para la tabla.
#### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
1 semana.  Posiblemente habría hecho una gráficas para agrupar las sesiones y mostrar cuántas hay de cada una.
#### ¿Por qué motivo has elegido el lenguaje que has usado para este test?
Me han obligado :( 
#### ¿Cómo mejorarías la API que has usado?
Si las sesiones siempre tienen tamaño 1, sería mejor que no fuesen un Array. 
Parece que hay campos como structure_decode que siempre son false. ??
#### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Node.js/Express. Viene en la cabecera de X-powered-by.
#### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
Sí. Primero porque tiene el habilitado en las cabeceras (CORS: * ) y segundo porque sin el CORS no podría 
utilizarse en el navegador por el cliente.
#### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
Viendo muchas cabeceras que empiezan por x-amzn diría que está alojado en AWS. Es 2018 y hay que alojar los 
servidores en la nube, barato, escalable, no riesgos...
#### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Pues si el servidor estuviese escrito en Go, utilizaría las geniales herramientas que proporciona (pprof, trace) y vería cual es el bottleneck. Si no, pues tendría que investigar el proceso que consume más memoria, CPU, ... y ya dependiendo del proceso pues se buscaría las herramientas de tracing/profiling para ver 
que funciones se utilizan más tiempo. 
#### Descríbete a ti mismo usando JSON.
{
	"nombre": "Daniel",
	"edad": 21,
	"lenguaje_programacion_favorito": "Go",
	"ganas_de_trabajar": "enormes",
	"experiencia": "0"
}
#### Extra
Al intentar utilizar TDD he tenido problemas porque he hecho uso de la librería Angular Material.
Al testear la vista, no había forma de que se mostrase los datos en la tabla, aunque internamente si
que los almacenaba en el DataSource. 