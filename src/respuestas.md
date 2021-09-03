- ¿Has aplicado los principios SOLID?
  - No tengo claro si he aplicado todos los principios o no, pero creo que he hecho un código limpio y fácil de entender.
- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?
  - No he tenído que hacer muchos test, es un desarrollo sencillo.
- ¿Por qué motivo has elegido el lenguaje que has usado para este test?
  - Se solicitaba en la prueba.
- ¿Cómo mejorarías la API que has usado?
  - Una cosa extraña que he visto es que 'session' trae un array con solo un objeto dentro, si siempre va a devolvernos un dato ese apartado, no haría falta el array y sería más fácil trabajar con el.
- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información
  - Investigando un poco pone 'x-powered-by: Express', pero desconozco si realmente esto hace referencia a que está hecha la api con Expres.js o Node.
- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
  - En un principio entiendo que si porque utiliza cabeceras HTTP.
- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?
  - Amazon web service. Fiabilidad, tranquilidad, rendimiento...
- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
  - Principalmente tiempos de carga excesivos, errores en las peticiones o problemas a la hora de integridad de los datos.
- Descríbete a ti mismo usando JSON.

```json
  {
  fullName: 'Andrés Fabregat Nogueras',
  nick: 'Ntres',
  createdAt: '02/02/1992',
  hobbys: {
    program: {
      like: true,
      level: 'noob'
    },
    music: {
      like: true,
      instruments: 'guitar'
      level: 'pro'
    },
    gamer: {
      like: true,
      games: ['League of legends', 'Enlisted']
      level: 'Ultra noob'
    }
  },
  animals: {
    dog: {
      name: 'Baloo'
      age: 5,
      type: 'Chow Chow'
    },
    tortoise: {
      name: null
    }
  }
  skills: ['javascript', 'react', 'angular', 'html', 'css'],
  lvlSkills: 'Beginer',
  softSkills: ['patient', 'worker', 'honest', 'fast compression']
}
```
