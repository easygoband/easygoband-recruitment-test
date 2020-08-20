**¿Has aplicado los principios SOLID?**
-Para ese proyecto tan pequeño no, pero si hubieran más elementos y el codigo fuera más extenso si que se deberia usar.

**¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?**
-Pensando el código habré estado 2 dias y escribiendo 3 ya que no conocía todavia bien el lenguaje y me ha costado un poco acceder a la información y sacarla.
Por añadir hubiera puesto un botón de los filtros de sesión que hay, un botón para volver al inicio de la página si hay mucha infomación y mejorar la parte visual usando v-cards.

**¿Por qué motivo has elegido el lenguaje que has usado para este test?**
-És el que se requería pero también és el que queria aprender.

**¿Cómo mejorarías la API que has usado?**
-Pienso que está correcta tal y como está.

**¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información**
-Sé que es Amazon Aws y por la información de la consola puedo detectar que es Laravel pero no estoy seguro.

**¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?
¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?**
-Puede soportar peticiones CORS con un middleware pero supongo que no es la opción que se quiere para hacer pruebas desde peticiones desconocidas. La decisión es por seguridad, si se entrega un enlace y una clave ya sabes que sólo va a entrar en ese dominio quien tenga la clave de acceso.

**¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?
Descríbete a ti mismo usando JSON.**
-Nunca he tenido que hacerlo y no sé por donde empezaría, supongo que monitorear las peticiones, ver dónde está fallando e intentar solucionar la parte que esté dando el problema.