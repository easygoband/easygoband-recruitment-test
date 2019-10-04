# Respuestas

- ¿Has aplicado los principios SOLID?
  Single responsibility principle, Interface segregation principle y Dependency inversion principle.

- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
  Unas 4 horas de forma intermitente. No tengo mucha experiencia con los tests. Añadiría testeo de los componentes.

- ¿Por qué motivo has elegido el lenguaje que has usado para este test?
  Simplicidad y universalidad.

- ¿Cómo mejorarías la API que has usado?
  Limitar el número de elementos en la respuesta y tener un control de peticiones por IP para evitar abusos.

- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
  Express.js y JS, basado en la respuesta del header “x-powered-by: Express”

- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
  Sí, por el header de respuesta “access-control-allow-origin y por no haber tenido problema en los testeos.

- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
  En AWS por la dirección de la API. AWS proporciona un escalado de los servicios contratados en base las necesidades del momento y también proporciona multiples servicios interrelacionados entre ellos.

- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
  Sí, he tenido que hacerlo bastantes veces. Lo rastrearía utilizando la información y gráficas de servicios como Firebase, en su defecto del propio servidor. A nivel frontend, usaría las herramientas de desarrolladores de los navegadores.

- Descríbete a ti mismo usando JSON.

```
{
  "name": "José Ulizarna",
  "alias": "Uli",
  "statement": "Desarrollador Full Stack que realiza proyectos para web, iOS y Android. José crea webs y web apps desde el principio hasta el último deployment.",
  "languages": ["Español", "Inglés"],
  "skils": [
    "HTML5",
    "Pug",
    "Twig",
    "CSS3",
    "SASS",
    "ES6",
    "BEM",
    "PHP",
    "Python MySQL",
    "AWS S3 Wordpress React Native Apache",
    "AWS Lightsail Heroku",
    "Git",
    "GitHub GitLab",
    "CLI",
    "Sketch (assets) UI"
  ],
  "projects": [
    {
      "name": "WORLD PADEL TOUR",
      "tech": "Pug, SASS, JS, jQuery, AJAX, BEM & ITCSS",
      "link": "https://www.worldpadeltour.com/"
    },
    {
      "name": "SUPERFACE",
      "tech": "Python, Flask, Panda3D, PIL, Google Vision, REST API, Heroku, PHP, WordPress, PugPHP, BEM, SASS, JS, jQuery, Heroku & Blender",
      "link": "https://superface.app"
    },
    {
      "name": "SIR 112",
      "tech": "React Native, Google Maps",
      "link": "https://www.112sir.com"
    },
    {
      "name": "FEDERACIÓN PADEL C.V.",
      "tech": "Timber, Twig, ES6, Gulp, Webpack, Tailwind CSS, SCSS, WordPress, WP Gutenberg, ACF, AWS Lightsail, AWS S3, AWS SES, Flickr API & Youtube API",
      "link": "https://padelcv.com"
    },
    {
      "name": "IDENTILOG",
      "tech": "React Native",
      "link": "https://identylogapp.com"
    }
  ]
}

```
