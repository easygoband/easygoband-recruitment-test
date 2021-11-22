## Preguntas técnicas
Responde a las siguiente preguntas en un fichero markdown.
- **¿Has aplicado los principios SOLID?**
+ Diría que esta mas enfocado a la programación oriendata a objetos y aquí hemos usado mas programación funcional... Pero se ha intentado aplicar los principos SRP, OCP y DIP con la forma que hemos usado los componentes.

- **¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?**
+ No he realizado ningún test porque no estoy familiarizado con los tests en Vue, pero habría hecho tests unitarios del propio componente y tests E2E para comprobar que todo se renderiza correctamente.

- **¿Por qué motivo has elegido el lenguaje que has usado para este test?**
+ Es el exigido por la prueba, podría haber usado Typescript con Vue pero no esta muy bien integrado en Vue 2.

- **¿Cómo mejorarías la API que has usado?**
+ Añadiria una paginación, en la busqueda aplicaria un Debounce para evitar sobrecargar las peticiones al servidor, mejoraria el estilo...

- **¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información**
+ NodeJS con el framework de Express.

- **¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?**
+ Si, toda petición HTTP utiliza esta politica de seguridad, seguro que si se usarán websockets se habria quejado...

- **¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?** 
+ Amazon Web Services, ofrece una gran variedad de servicios y tiene la fiabilidad de Amazon.

- **¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?**
+ Mirando tiempos de ejecución, en caso de una aplicación web miraria el apartado de la Performance de las herramientas de desarrollador. No, por ahora no.

- **Descríbete a ti mismo usando JSON.**
```json
{
  "name": "Tomás Fletcher Xavier",
  "age": 27,
  "experience": {
    "knowledges": ["vue", "nestjs", "typescript", "java"],
    "workingTime": "6 months with vue and nestjs"
  },
  "softSkills": ["teamwork", "entusiast", "possitive", "adaptable"],
  "comments": "I love the developer world and I hope to improve my development skills"
}
```