## ¿Has aplicado los principios SOLID?
Si, en los nuevos proyectos en los que he participado  

## ¿Cuánto tiempo has estado pensando y escribiendo los tests del código?
Medio año

## Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
Visualización de las sessiones y una vista de detalle con más estilos

## ¿Por qué motivo has elegido el lenguaje que has usado para este test?
He elejido kotlin porque es el lenguaje que utilizais en la empresa

## ¿Cómo mejorarías la API que has usado?
Añadiría filtros para poder reducir la información devuelta

## ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
Java Script o Type Script como lenguaje de programción corriendo en un servidor NodeJs y con el framework Express

## ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
No, porque el content-type de la cabecera es application/json


## ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
Está alojada en un servidor de Amazon Web Services, utilizando CloudFront.
Creo que lo habéis utilizado por la sencilled de publicar apis.

## ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
En el caso de que hayan logs, buscaría que acción está causando el problema. Si no encontrara el problema en el caso del back end comprovaría que las consultas a la bd no fueran el problema e iria a la partes del código dónde fuera más problable que esté el problema (seguramente en la capa de negocio).

Nunca he tendio que hacerlo

## Descríbete a ti mismo usando JSON.
```
{
  "nombre": "Joan Vicens",
  "apellidos": "Vallés Cerera",
  "web": "https://joanvicens.github.io/"
  "fecha_de_nacimiento": "24-12-1994",
  "trabajo": {
    "actual": true,
    "empresa": "virtusway",
    "posticion": ".NET developer",
  }
  "hobies": [
    "música", "diseño", "tecnología"
  ],
  "leguajes": [
    {
      "nombre": "java script",
      "nociones": "avanzadas"
    },
    {
      "nombre": "type script",
      "nociones": "basicas"
    },
    {
      "nombre": "java",
      "nociones": "medias"
    },
    {
      "nombre": "kotlin",
      "nociones": "basicas"
    },
    {
      "nombre": "C#",
      "nociones": "medias"
    },
    {
      "nombre": "F#",
      "nociones": "basicas"
    },
  ] 
}
```
