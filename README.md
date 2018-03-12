# **GuardarPunto**

En esta aplicación distribuida los usuarios dispondrán de un espacio online donde compartir sus opiniones de videojuegos, así como establecer puntuaciones, ver la de sus amigos, anotar que juegos quieren jugar en un futuro y cuáles son aquellos que estan aún no han terminado.

En cuanto a las partes de la aplicación, **la parte privada** será toda aquella relacionada con el perfil del cliente, es decir, las listas de juegos, las listas de amigos, valoraciones,etc.
**La parte pública** serían la posibilidad de ver perfiles de otros usuarios, valoraciones globales de los juegos...

## **Instrucciones**

1. Instalar una máquina virtual con Vagrant, Ubuntu y MySql, como se detalla en el tema 4 de la asignatura.
2. Generar los jar de la aplicación y del servicio interno, y copiarlos en la carpeta compartida con la MV.
3. Desde el directorio en el que se encuentra el archivo *Vagranfile*, iniciar la MV con los comandos *vagrant up* y *vagrant ssh*.
4. Una vez dentro de la MV, **si es la primera vez que se inicia la aplicación**, crear una nueva base de datos :
  1. *mysql -u root -p* (introducir la contraseña que se haya escogido al instalar el servidor de MySQL).
  2. *CREATE DATABASE guardarpuntodb*
5. Desde el directorio raíz, acceder a la carpeta compartida con *cd vagrant*.
6. Iniciar primero el servicio interno en segundo plano: *java -jar ServicioMail-0.0.1-SNAPSHOT &*.
7. Después iniciar la aplicación: *java -jar guardar_punto-0.0.1-SNAPSHOT*.
8. Finalmente, desde el navegador acceder a la dirección https://192.168.33.10:8443

## **Entidades**

Las entidades serían:
1. Usuario: Datos del usuario como nombre, correo, contraseña, amigos, juegos...
2. Juego: Datos de los juegos como título, compañía, año de lanzamiento, género, reviews...
3. Review: Opinión y puntuación de un usuario sobre un juego.
4. Comentarios: Publicaciones más cortas que las reviews (y sin puntuación), que realiza un usuario sobre un juego.

## **Descripción del servicio interno**

Se ha implentado un servidor que, al registrarse un usuario, enviará un correo de bienvenida. Esto se realiza en el proyecto ServicioMail, que crea un servidor, con sockets, que espera la conexión de un cliente. Desde el proyecto de Guardar Punto, se conecta creando un objeto EnviarMail, que envía al servidor el nombre de usuario y el e-mail del usuario que se ha registrado. 
Tras esto, el servidor, mediante el protocolo SMTP, manda con el correo guardarpuntomail@gmail.com un correo al usuario, dándole la bienvenida. 

## **Diagrama de clases**
Generado con la herramienta ObjectAid UML para Eclipse:
![](https://raw.githubusercontent.com/mfms5/guardarpunto/master/Diagrama/diagrama_clases_f3.jpg)

## **Diagrama Entidad/Relación**
A continuación se muestra el diagrama Entidad/Relación de la base de datos de la web:
![](https://github.com/mfms5/guardarpunto/blob/master/Diagrama/Entidad_Relacion.png)

## **Integrantes**

1. Marta Fernández de la Mela Salcedo (mfms5), mm.fernandezs@alumnos.urjc.es. 
2. Susana Pineda de Luelmo (SusanaPineda), s.pinedad@alumnos.urjc.es. 
3. Adrián David Morillas Marco (AdrianMorillas2), ad.morillas@alumnos.urjc.es. 

## **Pantallas** 
Contamos con 9 pantallas diferentes, dos de ellas modales pero que se han incluido como pantallas diferentes.
  ## **Inicio** 
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/inicio.png?raw=true)
  
  Desde la pantalla de inicio el usuario podrá registrarse o hacer login en la página. Así mismo podrá acceder a una lista de juegos       destacados y a noticias de otras páginas. Desde la barra de navegación podrá acceder a Juegos, Perfil, Reviews, Amigos y realizar       búsquedas (estas opciones serán comunes para todas las pantallas menos para las modales).  
  Al hacer login, se sustituiría este panel por uno que muestra los juegos jugados del usuario. En la fase 2 simplemente se finge que ha iniciado sesión el usuario 1 (también para las pantallas de Perfil, Amigos y Reviews).
  
  ## **Registro**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/registro.png?raw=true)
  
  Pantalla modal desde la que el usuario podrá registrarse. Se añadiría un nuevo usuario a la base de datos.
  
  ## **Juegos**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/juegos.png?raw=true)
  
  Pantalla desde la cual el usuario podrá ver todos los juegos y desde donde podrá acceder a las diferentes fichas de los juegos. Desde   esta pantalla también podrá iniciar sesión o registrarse y acceder a noticias de otras páginas. También podrá hacer uso de la barra de   navegación para ir a las pantallas de Juegos, Perfil, Reviews, Amigos y realizar búsquedas.
  
  ## **Ficha de Juego**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/fichaJuego.png?raw=true)
  
  Desde esta pantalla el usuario podrá ver todas las especificaciones del juego (compañía, año, género, plataforma, resumen y             puntuación), también podrá añadirlo a una de sus listas (pendiente, jugado o jugando) y ver y hacer comentarios y reviews sobre el       juego. Desde esta pantalla se podrá registrar o iniciar sesión y navegar por las paginas por la barra de navegación de la misma forma   que en las pantallas anteriores. 
  
  ## **Perfil**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/perfil.png?raw=true)
  
  Desde esta pantalla el usuario podrá ver su información de perfil o de otro usuario (nombre, biografía, juegos jugando, jugados y       pendientes, amigos, comentarios y reviews). En caso de ser tu perfil el que estas visitando podrás acceder a los ajustes de perfil       (por implementar). Se podrá acceder a las fichas de los juegos que están en las listas y a los perfiles de los amigos y a la             navegación con la barra de navegación.
  
  ## **Editar Perfil**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/editarPerfil.png?raw=true)
  
  Pantalla modal desde la cual el usuario podrá modificar su foto de perfil mediante una url y su biografía.
  
  ## **Reviews**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/reviews.png?raw=true)
  
  Pantalla desde la cual el usuario podrá ver todas las reviews que ha hecho y acceder a los juegos de dichas reviews. Igualmente podrá   navegar mediante la barra de navegación.
 
  ## **Amigos**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/amigos.png?raw=true)

  Pantalla desde la cual el usuario podrá ver todos los amigos que tiene (foto de perfil, nombre y biografía) y acceder a su perfil.       Podrá navegar desde la barra de navegación a las pantallas de Inicio, Juegos, Perfil, Reviews, Amigos y realizar búsquedas.
  
  ## **Búsquedas**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/busqueda.png?raw=true)
  
  Al realizar una búsqueda se nos muestra una pantalla en la cual aparecerán las coincidencias con la búsqueda tanto entre los usuarios   como entre los juegos. Desde esta pantalla podremos acceder al perfil del usuario o del juego buscado, podremos registrarnos o iniciar   sesión y podremos redirigirnos a noticias de otras páginas. Cuenta igual que el resto de pantallas con la navegación a partir de la     barra de navegación.
  
## **Navegación entre páginas**
![](https://github.com/mfms5/guardarpunto/blob/master/Diagrama/diagrama%20Navegacion.png?raw=true)

  ## **Inicio**
  Desde inicio se puede acceder a:
    - Juegos
    - Perfil (propio)
    - Reviews
    - Amigos
    - Ficha de juego
    - Busqueda
    - Registro
    - Noticias Externas
  
  ## **Juegos**
  Desde juegos se puede acceder a:
    - Inicio
    - Perfil (propio)
    - Reviews
    - Amigos
    - Ficha de juego
    - Busqueda
    - Registro
    - Noticias Externas
    
  ## **Perfil**
  Desde perfil se puede acceder a:
    - Inicio
    - Juegos
    - Perfil (otro jugador)
    - Reviews
    - Amigos
    - EditarPerfil
    - Ficha de juego
    - Busqueda
    - Registro
  
  ## **Reviews**
  Desde reviews se puede acceder a:
    - Inicio
    - Juegos
    - Perfil
    - Amigos
    - Busqueda
    
  ## **Amigos**
  Desde amigos se puede acceder a:
    - Inicio
    - Perfil (propio y ajeno)
    - Reviews
    - Amigos
    - Juegos
    - Busqueda
    
  ## **Ficha de Juego**
  Desde ficha de juego se puede acceder a:
    - Inicio
    - Registro
    - Juegos
    - Perfil
    - Reviews
    - Amigos
    - Busqueda
 
  ## **Busqueda**
  Desde busqueda se puede acceder a:
    - Inicio
    - Juegos
    - Perfil(propio y ajeno)
    - Reviews
    - Amigos
    - otra busqueda
    - ficha Juego
    - Registro
    - noticias externas




