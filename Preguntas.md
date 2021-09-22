## Preguntas técnicas

Responde a las siguiente preguntas en un fichero markdown.

### ¿Has aplicado los principios SOLID?

He aplicado los principios solid, ya que he estructurado los archivos, cada componente tiene su logica y comportameinto separadossumado a un codigo legible.

### ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

No tengo conocimiento en pruebas, me gustaria aprender hacer, si hubiera tenido mas tiempo me hubiera gustado aprender para hacerlas en la prueba.

En total para la prueba segun mi wakatime use 8 horas y 36 minuto. (https://ibb.co/CP4Zv2w)

### ¿Por qué motivo has elegido el lenguaje que has usado para este test?

Fue un gran reto usar Vue.js, es la primera vez que uso el framework, lo use ya que lo solicitaba la prueba (el framework que si he usado es React); todos las librerias usadas en la prueba las use guiandome de un curso de platzi.

### ¿Cómo mejorarías la API que has usado?

La seguridad de las peticiones, ya que al tener una autorizacion basica cualquier persona puede consultar la informacion, al implemetar tokens de autenticacion solo un suario con un token y un rol peude consultar x informacion.

### ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Revisando Headers de la peticion en el navegador se encuentra x-powered-by: Express, por los cual el framework que se uso es express y el lenguaje es Javascript usando NodeJs, he tenido la oprotunidad de crear apis para projectos propios usando dichas tecnologias, peuden verlos en mi Github.

#### ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

si, ya que en Response Headers, tiene access-control-allow-origin: \*, lo que permite que desde cualquier url que se le haga una peticion resiva una respuesta, si esa access contro no estuviera abierto o tuviera alguna condicion como un dominio especicifco, solo se podria hacer peticiones cumpliendo dichas condiciones.

### ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

Como lo muesta la url y los headers de la peticion, se esta usando Amazon Web Servies y en especifico Cloudfront, que es un servicio que permite entregar contenido de forma rapida, con altas velocidades de trnasferencia.

Me iamgino que se usa Amazon por que se necesita una alta velocidad en la consulta de la informacion por parte de clientes, sumado al bajo costo de la nube y que amazon solo cobra por los servicios usados.

### ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

He usado Lighthouse para generar reportes de rendimiento en produccion, pero ya para mejoras de dicho performance, accesibilidad y demas temas si no tenido la oprtunidad de mejorar el codigo, me gustaria aprender.

### Descríbete a ti mismo usando JSON.

```bash
{
       "avatar": "https://raw.githubusercontent.com/AbejaCruz/curriculumvitae/main/avatar.jpg",
        "name": "Diego A Cruz Triana",
        "profession": "Web Developer",
        "fecha_de_nacimiento": "30-04-92",
         "web": "https://abejacruz.github.io/curriculumvitae/"
         "Correo": "dacruzt@outlook.com",
        "bio": "Ingeniero de sistemas, Amante de los videjuegos y del constante aprendizaje.",
        "address": "Bogotá, Colombia.",
        "social": [{

                "name": "facebook",
                "url": "https://www.facebook.com/diegabeja"
            },
           {
                "name": "twitter",
                "url": "https://twitter.com/AbejaCruzDev"
            },
            {
                "name": "github",
                "url": "https://github.com/AbejaCruz"
            },
           {
                "name": "linkedin",
                "url": "https://www.linkedin.com/in/abejacruz/"
            }
        ],
        "experience": [
            {
                "jobTitle": "Desarrollador VR/AR",
                "company": "Mudi S.A.S",
                "startDate": "Mayo 2019",
                "endDate": "Febrero 2021",
                "jobDescription": "Desarrollo full stack de Aplicaciones de realidad amentada para la web, aplicaciones de VR para dispositivos y landing pages."
            },
            {
                "jobTitle": "Frontend",
                "company": "Tresciclaje",
                "startDate": "Marzo 2017",
                "endDate": "Diciembre 2018",
                "jobDescription": "Desarrollo del Frontend de la paltaforma Tresciclaje."
            }
        ],
        "education": [
            {
                "degree": "Tecnólogo en Producción Multimedia",
                "institution": "SENA",
                "startDate": "Enero 2016",
                "endDate": "Diciembre 2018",
                "description": ""
            },
            {
                "degree": "Ingeniería de Sistemas",
                "institution": "Universidad Distrital Francisco José de Caldas",
                "startDate": "Enero 2010",
                "endDate": "Mayo 2017",
                "description": ""
            }
        ],
        "certificate": [
            {
                "name": "Escuela de Javascript",
                "institution": "Platzi",
                "date": "2019",
                "description": "La Escuela de JavaScript es el mejor esfuerzo de blended education, educación online y presencial para especializarte en desarrollo Full Stack con JavaScript. "
            },
            {
                "name": "FrontEnd Developer",
                "institution": "Platzi",
                "date": "Enero 2019",
                "description": "Carrera de FrontEnd de Platzi"
            }
        ],
        "skills": [
            {
                "name": "HTML5",
                "percentage": "90%"
            },
            {
                "name": "CSS",
                "percentage": "85%"
            },
            {
                "name": "JavaScript",
                "percentage": "80%"
            },
            {
                "name": "React",
                "percentage": "60%"
            }
        ]
    }

```
