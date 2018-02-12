# **GuardarPunto**

En esta aplicación distribuida los usuarios dispondrán de un espacio online donde compartir sus opiniones de videojuegos, así como establecer puntuaciones, ver la de sus amigos, anotar que juegos quieren jugar en un futuro y cuáles son aquellos que estan aún no han terminado.

En cuanto a las partes de la aplicación, **la parte privada** será toda aquella relacionada con el perfil del cliente, es decir, las listas de juegos, las listas de amigos, valoraciones,etc.
**La parte pública** serían la posibilidad de ver perfiles de otros usuarios, valoraciones globales de los juegos...

## **Entidades**

Las entidades serían:
1. Usuario
2. Juego
3. Review
4. Comentarios

## **Descripción del servicio interno**

Los usuarios podrán compartir imágenes que podrán ser escalables. ASí mismo, se enviará un mensaje vía e-mail una vez un usuario se haya registrado.

## **Diagrama Entidad/Relación**
A continuación se muestra el diagrama Entidad/Relación de la base de datos de la web:
![](https://github.com/mfms5/guardarpunto/blob/master/Diagrama/Entidad_Relacion.png)

## **Integrantes**

1. Marta Fernández de la Mela Salcedo
2. Susana Pineda de Luelmo
3. Adrián David Morillas Marco

## **Pantallas** 
Contamos con 9 pantallas diferentes, dos de ellas modales pero que se han incluido como pantallas diferentes.
  ## **Inicio** 
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/inicio.png?raw=true)
  
  Desde la pantalla de inicio el usuario podrá registrarse o hacer login en la página. Así mismo podrá acceder a una lista de juegos       destacados y a noticias de otras páginas. Desde la barra de navegación podrá acceder a Juegos, Perfil, Reviews, Amigos y realizar       búsquedas (estas opciones serán comunes para todas las pantallas menos para las modales).
  
  ## **Registro**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/registro.png?raw=true)
  
  Pantalla modal desde la que el usuario podrá registrarse.
  
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

