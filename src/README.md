# easygoband-test

## Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Lints and fixes files

```
npm run lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).

### Preguntas

### ¿Has aplicado los principios SOLID?

Algunos principios han sido aplicados, aunque no todos encajan de la mejor forma con el framework de frontend utilizado, como el de la sustitución por una superclase, ya que no existe esa relación entre elementos en la solución actual o el de segregación de interfaz.

Si he intentado aplicar el principio de responsabilidad única, utilizando un componente para cada funcionalidad distinta. Y por ejemplo, un cambio en la forma de obtener el listado, solo afecta a un componente.

También el principio de inversión de dependencias aplica en el componente Providers donde se utilizan algunas dependencias como "date-fns" y el módulo general de la aplicación no depende de esta librería si se decide luego cambiarla por otra.

### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

No he realizado tests de código, no estoy completamente familiarizado con los frameworks que lo realizan y me hubiera demandado bastante más tiempo.

Si hubiera tenido más tiempo los hubiera añadido a la solución.

También con más tiempo hubiera investigado más acerca del framework VUE, sobre buenas prácticas, mejores formas de utilización de componentes y de optimización.

Además hubiera creado archivos de configuración para para algunas constantes como el BASE_URL donde está alojada la API. Tal vez creando distintos scripts con configuraciones distinas dependiendo del ambiente.

### ¿Por qué motivo has elegido el lenguaje que has usado para este test?

Las posibilidades sobre las que hablamos en la primer entrevista eran react y vue, y me comentaron que si lo realizaba en vue era mejor.

Pese a no haberlo utilizado antes, no tuve mayores inconvenientes en entender su principal funcionamiento y poder desarrollar el test.

### ¿Cómo mejorarías la API que has usado?

Le agregaría la posibilidad de paginar los resultados y que el request sea configurable para obtener una cantidad menor, para no traer todos los datos al mismo tiempo y disminuir el tiempo que tarda en dar una respuesta.

También el filtro para buscar por texto, podría hacer un request al server y que éste sea el encargado de devolver la información filtrada.

### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Se ha utilizado Express de Node.js

### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

Si, por el header: access-control-allow-origin: \*

### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

Está alojada en AWS, también por la información del protocolo HTTP. Se podría haber tomado esa decisión por muchos motivos, conocimiento de AWS, el uso masivo que tiene en el mercado, por cuestiones de seguridad, disponibilidad de los datos, escalabilidad, etc.

### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

Empezaría desde lo más básico a lo más complejo. Primero en cuestiones de hardware como los servidores remotos, la cantidad disponible y su capacidad de procesamiento. De igual forma con las bases de datos y la cantidad de consultas simultáneas que soporta y cuánto tarda en responder.

Luego evaluar si quien demora la respuesta es el backend, tal vez por alguna consulta a la base de datos mal realizada, o procesamiento innecesario para retornar datos.

Y también en el frontend, viendo si el framework y su utilización es el adecuado para nuestra necesidad.

Habría que ir cubriendo todas las posibilidades hasta encontrar el cuello de botella que hace que la aplicación tenga un problema de rendimiento.

Me tocó realizarlo en una aplicación móvil, y el inconveniente era que estábamos utilizando una versión vieja del framework de frontend, pero no podíamos actualizarlo.

### Descríbete a ti mismo usando JSON.

```json
{
"nombre": "Fernando",
"apellido": "Haspert",
"email": "fhaspert08@gmail.com",
"nacimiento": "14-10-1993"
"estudios": [
{
"instituto": "IDET Instituto de educación técnica",
"título": "Técnico en electromecánica",
"inicio": 2006,
"final": 2011,
"estado": "finalizado"
},
{
"instituto": "UTN - Universidad Tecnológica Nacional",
"título": "Ingeniería en Sistemas de Información",
"inicio": 2012,
"estado": "en curso"
},
],
"experiencia": [
{
"empresa": "Certant S.A",
"cargo": "Desarrollador fullstack"
"inicio": "02-05-2017",
"fin": "27-12-2019",
"area": "Bancos",
},
{
"empresa": "Crowder",
"cargo": "Desarrollador frontend"
"inicio": "06-01-2019",
"fin": "actual",
"area": "Eventos",
}
],
"habilidades": {
"lenguajes": ["JAVA", "Javascript", "C"],
"frameworks": ["react", "Angular", "Srping", "Next.js", "Ionic"],
"otros": ["SQL", "git", "HTML", "CSS", "SASS", "GULP", "Integración continua", "Metodologías ágiles", "Jenkins"]
},
"hobbies": ["fútbol", "básquet", "música"]
}
```
