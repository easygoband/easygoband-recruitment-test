¿Has aplicado los principios SOLID?

Desde mi punto de vista si.

¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

La verdad es que la forma en la que he desarrolllado la app no se me ocurren formas que sepa actualmente de hacer tests,
ya que como tal el usuario solo tiene que realizar un input que esta controlado desde la cappa de la UI ya que no se puede acceder
a otro que link que acabe en un numero distinto a 1.

Aun asi, estoy en proceso de aprendizaje para testear ViewModels y APIs desde Android.

¿Por qué motivo has elegido el lenguaje que has usado para este test?

-

¿Cómo mejorarías la API que has usado?

Entiendo que al ser un servidor de pruebas no exista ningun tipo de sistema de autenticacion de usuarios implementado, aunque igual
alguna forma de filtrar desde una peticion por URL estaria bien pero siguiendo el objetivo de la prueba no hace falta en verdad.

¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Esta hecho en JS, con Express.js en Node.js

¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

Si porque el realizar una peticion por Postman, esta el Header especifico para permitir al acceso.

¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

Esta alojado en Amazon Web Services, a parte que de por ser practicamente un estandar el mercado, su largo recorrido, soporte y eficiencia.

¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Desde mi punto de vista lo dividiria en 3 partes:
 - Aplicacion. Test unitarios a todos los componentes, ViewModels, API Requests. Luego quiza por la herramienta de Android Profiler que tiene Android Studio y realizar una serie de puebas para medir el tiempo de respuesta de partes, o mediante dispositivos conectados, medir el rendimiento.
 - Servidor. Test incrementales en los que se testea el aguante maximo de peticiones.
 - Clientes. Mediante dispositivos moviles comprobar el funcionamiento de la aplicacion y el servidor en primera persona.

Descríbete a ti mismo usando JSON.

{
    "nombre": "Ramses Isaac",
    "apellidos": "Alarcon Cordova",
    "edad" : 21,
    "apodo" : "RAM",
    "bebida_favorita": "Cafe",
    "estudios": [
        {
            "titulo": "CFGS Desarrollo de aplicaciones multiplataforma",
            "institucion" : "Santa Maria La Nueva y San Jose Artesano",
            "ciudad": "Burgos",
            "inicio": "2018"
            "fin": "2020"
        },
        {
            "titulo": "Ingenieria Informatica",
            "institucion" : "Universidad Jaume I",
            "ciudad": "Castellon de la Plana",
            "inicio": 2020
            "fin": "Possibly 2025"
        }
    ],
    "lenguajes_programacion": [
        "Java","SQL","Visual Basic","ABAP","Kotlin","Python", "JavaScript", "Dart"
    ],
     "frameworks": [
       "React","Angular","Django","Flutter"
    ],
    "proximos_objetivos":[
        "Tensor flow", "Open AI","Amazon Web Services", "Google Cloud", "Azure", "Swift UI"
    ]

}


ANOTACIONES: 

Como no se me ocurria que podria añadir al servidor rest, he hecho una replica de este pero usando Django Rest Framework

Procedimiento previo a la creacion del servidor:
    1 Diseño de tablas: 
        - En este caso solo hay 3: ITEM, SESSION ya que por como es el JSON entiendo que un Item Object puede tener N Session Object 
        pero me descuadra un poco que no hay ningun objeto que tenga mas de 1 Session Object, asi que realizare una relacion 1 a N.
    2 Como desconozco que cuantos elementos estan definidos en la tabla sesion, aprobechare el codigo que usado en la app de Android
    cuando implemente los filtros para poder encontrar estos datos iniciales.
    3 Modelar los objetos en clases de Python implementando el sistema descrito en el punto 1.
    4 Crear los Serializers para poder usar el APIView del Framework.
    5 Cargar datos mediante un JSON desde consola.

Requisitos para poder correr el servidor: python3, django-admin, django-rest-framewrk,django-cors-headers.

Abrir la carpeta del server desde VSCode, abrir el terminal y ejecutar el siguiente comando:
    - python3 manage.py makemigrations
    - python3 manage.py migrate
    - python3 manage.py runserver 0.0.0.0:8000

IMPORTANTE: Al ser un desarrollo local, consultar la IP del dispositivo del emulador y agregarlo a settings.py en el apartado de ALLOWED_HOST[]

Demo del sistema completo y desarrollo aqui:
    - https://youtu.be/vJKZJXoouBg