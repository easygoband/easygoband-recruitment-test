# Preguntas Técnicas

##### 1) ¿Has aplicado los principios SOLID?

Podría haberlos aplicado con mayor empeño, pero el Principio de Responsabilidad Individual (la S de SOLID) sí que lo he aplicado.

He tratado de dividir el código en diferentes clases, segregando responsabilidades en conjuntos que tenían sentido.

##### 2) ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?

He ido pensando cómo podía probar las funcionalidades descritas sobre la marcha. Una vez había pensado cómo quería estructurar el código, iba probando las funcionalidades para comprobar que funcionaran todas correctamente.

##### 3) ¿Por qué motivo has elegido el lenguaje que has usado para este test?

Para ponerme a prueba. Si bien a Java estoy muy acostumbrado, Kotlin es un lenguaje al cual no lo estoy. Sabiendo de las similitudes con el primero, y conociendo la multitud de facilidades que ofrece este lenguaje de programación orientado a objetos, me he decantado por Kotlin.

##### 4) ¿Cómo mejorarías la API que has usado?

Añadiría más interfaces en la API para llevar a cabo más funcionalidades (filtrar, ordenar, consultar, etc.).

##### 5) ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información

Gracias a Postman, una aplicación para testeo de APIs, he podido llevar a cabo consultas a la interfaz ofrecida. Comprobando las cabeceras recibidas, he podido observar que el framework utilizado es Express, lo que me ha llevado a la conclusión de que el lenguaje usado es JavaScript.

##### 6) ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?

Sí, esta API soporta peticiones CORS. Siguiendo el punto descrito en la pregunta 5, he podido observar el parámetro de las cabeceras `access-control-allow-origin: *`, el cual especifica que el recurso puede ser compartido desde cualquier origen.

##### 7) ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?

Siguiendo el punto descrito en la pregunta 5, he podido observar que la infraestructura utilizada es Amazon CloudFront.

Amazon CloudFront es una CDN con servidores alrededor del mundo, lo que hace que el acceso sea eficiente y rápido desde cualquier parte del planeta. Por este motivo creo que habéis tomado esta decisión.

##### 8) ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?

Llevando a cabo tests, trataría de ver en qué escenario se está produciendo el problema de rendimiento. Una vez localizado el problema buscaría arreglar cómo puedo solucionar para mejorar el rendimiento. Una vez hechas las pruebas correspondientes en entornos de testing, y habiendo comprobado que funciona correctamente, el arreglo estaría listo para revisión y, si pasa los filtros correspondientes, también lo estaría para producción.

##### 9) Descríbete a ti mismo usando JSON.

```json
{
    "Nombre": "Lluís Masdeu",
    "Fecha de nacimiento": "24/10/1995",
    "Población": "Barcelona",
    "País": "España",
    "Hobbies":
    [
        "Tecnología",
        "Cine",
        "Series",
        "Literatura",
        "Videojuegos",
        "Viajar"
    ]
}
```