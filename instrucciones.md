## Test de código

Requerimientos: para poder correr la aplicación para se necesita tener instalado previamente php y mysql en el hambiente donde se quiere probar

```
https://linuxize.com/post/how-to-install-php-8-on-ubuntu-20-04/
```

Teniendo esto funcionando correctamente requiere montar la base de datos que se encuentra dajunta o en su defecto el framework <br>
contiene un comando que se encarga de crear tablas necesarias, de todas maneras se adjunta una copia de la misma y se tendria que poner manual

```
php artisan migrate
```

Una vez teniendo esto dentro de la aplicación en la carpeta src se corre el siguiente comando para poder visualizar la aplicacion correctamente de

```
php artisan serve
```
