# CeibaTest

Este proyecto es una solucion de una prueba planteada por Ceiba Software House.

## ¿Como se realiza la solucion del Test?

Se crea un proyecto de Android utilizando JetPack Compose, al terminar la creacion para continuar con el proceso se aplica clean architecture y MVVM, esto con la finalidad de poder desacoplar la logica de negocio de la vista y la infraestructura, ademÃ¡s de garantizar que se genera un codigo limpio, estructurado y legible.

Este proyecto tambiÃ©n cuenta con pruebas unitarias basadas en resolver la logica de negocio y no en cumplir con covertura, en su interior encontramos patrones de diseno y buenas practicas.

Por ultimo, este proyecto aplica buenas practicas de codigo y principios para garantizar el proceso.


## ¿Que arquitecturas se utiliza?

A continuacion se presenta un diagrama de como se ve Clean Architecture:

![Clean Architecture](https://mahedee.net/assets/images/posts/2021/clean.png)
**Nota:** Para este proyecto no se esta utilizando la capa de Application ni de Persistence.

Para poder implementar la arquitectura limpia debemos crear dos modulos o capas mas para el proyecto, los cuales son **Domain** y **Infrastructure**, ademas se renombra la capa **App** por **Presentation**:
* **Presentation:** Se encuentra todo lo que va de cara al usuario.
* **Domain:** Encontramos toda la logica de negocio.
* **Infrastructure:** Se implementa la conexion a API's o bases de datos para la obtencion de data.

TambiÃ©n se aplica **MVVM** como arquitectura de diseÃ±o que nos ayuda a aplicar reactividad de una manera mÃ¡s simple:

![MVVM](https://www.adictosaltrabajo.com/wp-content/uploads/2020/06/MVVMPattern.png)

Internamente se aplica diferentes patrones de diseno que se ven explicados posteriormente.

## ¿Que patrones de diseno usamos?

Los patrones de diseÃ±o se utilizan para resolver problemas de los cuales se necesita estandarizar una solucion que ayude a disminuir la friccion en cuando al entendimiento de la solucion, en este caso utilizamos:
* **Repository pattern:** Nos ayuda a transportar la informacion desde la capa de infraestructura evitando acoplamiento de capaz.
  ![RepositoryPattern](https://miro.medium.com/max/981/1*5kNXJ7aFSGJvuh4r4egpTg.png)
* **Translate pattern:** Al recibir DTO cuando consumimos el API, nos ayuda a transformar este objeto a uno de Dominio facilmente.
* **DataBuilder pattern:** Nos ayuda a construir objetos con caracteristicas especiales dependiendo las pruebas que deseemos realizar.
* **Dependency injection:** Nos ayuda a crear los objetos de una manera Ãºtil, escalable y nos permite desacoplar completamente el dominio de las demÃ¡s capaz.

## ¿Que librerias se utilizaron en el proyecto?

Las librerias cumplen con el proposito de solucionar problemas que a menudo se encuentran en el desarrollo, haciendo mucho mÃ¡s fÃ¡cil la implementacion, para el caso de este proyecto se utilizaron:

* **Hilt:** Inyeccion de dependencias.
* **Retrofit2:** Realiza la estructura para las peticiones a las API's.
* **LiveData:** Nos ayuda a crear valores reactivos.
* **Mockito:** Crea informacion fake para las pruebas unitarias que se realizan.

## Consideraciones adicionales

El repositorio es publico, por lo cual no hay necesidad de manejar credenciales adicionales ni solicitar permisos al dueno del repositorio @felipevelasquez1717 para poder acceder a su contenido.

El proyecto tiene dos variantes de construccion **PROD**  y **MOCK**:
* **PROD:** Tiene toda la configuracion necesaria para realizar las peticiones al servicio.
* **MOCK:** Tiene la informacion mockeada desde la infraestructura.


# Ejecucion del proyecto

Inicialmente necesitamos crear una carpeta con en la cual almacenaremos el repositorio:
### Windows
> md projects
### Linux/Mac
> mkdir projects

Procedemos a entrar a la carpeta de la siguiente manera:
### Windows/Linux/Mac
> cd projects

Ahora clonamos el repositorio:
### Windows/Linux/Mac
> git clone https://github.com/FelipeVelasquez1802/RecipeBook.git

**Nota:** Para realizar este proceso debemos tener git instalado en nuestro equipo.

### Ahora con nuestro IDE de confianza procedemos a abrir el proyecto y ejecutar el aplicativo.
