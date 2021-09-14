<!-- Responde a las siguiente preguntas en un fichero markdown. -->

<!-- ¿Has aplicado los principios SOLID? -->

    He intentado aplicar los principios SOLID dado que la aplicación tiene una estructura organizada, en parte gracias al framework de VueJs que permite la creación y comunicación entre componentes sin ningun tipo de dificultad.

<!-- ¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido? -->

    El desarrollo de la aplicación me ha llevado varias horas ya que he tenido bastantes problemas de compatibilidad con el framework y los paquetes de node_modules. En cuanto a código, no me ha llevado mucho tiempo obtener los datos de la API y manejarlos dado que las librerías que he gastado facilitan el trabajo de desarrollo.
    En cuanto a test, no he realizado ninguno que pueda exponerse en el código, he controlado durante el desarrollo todos los problemas que me iban saliendo y resolviendolos al instante. Gracias a la extensión para el navegador de Vue Devtools y al programa Postman he podido controlar y ver la entrada de datos de la Api y he sabido como manejarla sin problemas.

<!-- ¿Por qué motivo has elegido el lenguaje que has usado para este test? -->

    La prueba consistía en crear una aplicación con el framework de VueJs y lo he combinado con TypeScript, jQuery y Scss ya que me parece una combinación que facilita el desarrollo. Además he instalado la librería de bootstrap para el diseño responsive, moment para el manejo de fechas y axios para el manejo de APIs desde Vue.

<!-- ¿Cómo mejorarías la API que has usado? -->

    No sabría decir si se debería mejorar, el manejo de la "session" se podría simplificar ya que solamente gasta un objeto y eso incomoda el manejo de datos pero si se guardaran más objetos estaría correctamente contemplado.

<!-- ¿Qué framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información. -->

    Diría que se ha usado Node ya que permite un envio de datos muy rapido y el principal framework que gasta node es Express por lo que creo que se hizo con estos. Esto lo he podido observar en un proyecto anterior que hice aplicandolo al desarrollo de un chat en tiempo real y viendo que la información se envia de forma instantanea.

<!-- ¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión? -->

     Si soporta peticiones CORS ya que este puede permitir a varios scripts gastar la API para diversos usos ya sea para mostrar una tabla de datos o manejar sus datos.

<!-- ¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión? -->

    Esta alojada en los servicios web de Amazon dado que proporcionan una calidad de servicio alta y fiable.

<!-- ¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo? -->

    Los tiempos de carga de datos prolongados pueden indicar la existencia de algun error pero desconozco otras formas de comprobación.

<!-- Descríbete a ti mismo usando JSON. -->

{
"basics": {
"name": "Dan Nedelea",
"label": "Web Developer",
"email": "dannedelea08@gmail.com",
"website": "http://dannedeleacv.atwebpages.com/",
"summary": "I consider myself a responsible person, sociable and lover of programming",
"location": {
"city": "Valencia",
"country": "Spain",
},
},
"work": [
{
"company": "Ceesi Asesores S.L.",
"position": "Analist Software Developer in practice",
"startDate": "2021-03-08",
"endDate": "2021-06-05",
"summary": "Working with vue.js to make application completely responsive",
"skills": ["Vue", "TypeScript", "JavaScript", "SQLServer", "Bootstrap", "DevExtreme"]
}
],
"education": [
{
"institution": "IES Fuente San Luis",
"area": "Web application development",
"studyType": "GS",
"startDate": "2019-09-01",
"endDate": "2021-06-01"
},
{
"institution": "IES Pablo Gargallo",
"area": "Bachelor degree",
"studyType": "Course",
"startDate": "2016-09-01",
"endDate": "2018-06-01"
},
],
"skills": [
{
"name": "Software Development",
"level": "Junior",
"keywords": ["HTML", "CSS", "SCSS", "Javascript", "Angular", "Vue", "MySQL"]
}
],
"languages": [
{
"language": "Spanish",
"fluency": "Native speaker"
},
{
"language": "Roumanian",
"fluency": "Native speaker"
},
{
"language": "English",
"fluency": "Fluent"
},
{
"language": "French",
"fluency": "Basics"
}
],
"meta": {
"theme": "elegant"
}
}
