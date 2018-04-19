# **GuardarPunto**

En esta aplicación distribuida los usuarios dispondrán de un espacio online donde compartir sus opiniones de videojuegos, así como establecer puntuaciones, ver la de sus amigos, anotar que juegos quieren jugar en un futuro y cuáles son aquellos que estan aún no han terminado.

En cuanto a las partes de la aplicación, **la parte privada** será toda aquella relacionada con el perfil del cliente, es decir, las listas de juegos, las listas de amigos, valoraciones,etc.
**La parte pública** serían la posibilidad de ver perfiles de otros usuarios, valoraciones globales de los juegos...

## **Descripción del servicio interno**

Se ha implementado un servicio interno de correo con una API REST. Este servicio consiste en enviar un correo de bienvenida cuando el usuario se registra. Para ello, el cliente debe enviar al servicio REST el nombre y el e-mail del usuario. Mediante un protocolo SMTP, se envía un mensaje al usuario.   

## **Instrucciones Fase 4**
Para la fase 4 se han creado 5 máquinas virtuales: balanceador de carga, dos aplicaciones web, servicio interno y base de datos.

### 1) Aplicaciones web y servicio interno
1. Instalar Java 8 y el cliente de MySQL (MySQL sólo es necesario en las MV de la aplicación web):  
`sudo apt-get update`   
`sudo add-apt-repository ppa:openjdk-r/ppa`   
`sudo apt-get install -y oracle-java8-installer`   
`sudo apt-get install -y openjdke-8-jre`  

2. En el *vagrantfile*, descomentar la siguiente línea y cambiar la IP si es necesario:  
`config.vm.network "private_network", ip: "192.168.33.12"`   
En nuestro caso, las IPs de las máquinas virtuales que contienen la aplicación son 192.168.33.11 y 192.168.33.12. La del servicio interno es 192.168.33.14.

### 2) Base de datos
1. Instalar MySQL:   
`sudo apt-get update`  
`sudo apt-get install -y mysql-server`   
La contraseña del usuario root debe ser la misma que tenemos en el application.properties (en nuestro caso "enjutomojamuto").   

2. Crear la base de datos *guardarpuntodb*. 

3. Crear dos usuarios con las IPs de las VMs de la aplicación web y concederles todos los permisos:   
`create user root@192.168.33.11 identified by 'enjutomojamuto';`   
`grant all privileges on guardarpuntodb.* to root@192.168.33.11;`   
`flush privileges;`   

4. Editar el archivo de configuración de MySQL para que atienda las peticiones realizadas a su IP privada:   
`sudo pico /etc/mysql/my.cnf`   
`bind-address = 192.168.33.10` (esta es la IP de la máquina virtual en la que vamos a tener la base de datos).   

5. Reiniciar el servicio: `sudo service mysql restart`.

### 3) Balanceador de carga
1. Instalar HAProxy 1.8:   
`sudo add-apt-repository ppa:vbernat/haproxy-1.8`
`sudo apt-get update`
`sudo apt-get install haproxy`   

2. Generar un certificado SSL para soportar las conexiones HTTPS: https://serversforhackers.com/c/using-ssl-certificates-with-haproxy   
![](https://github.com/mfms5/guardarpunto/blob/master/ssl.PNG)

3. Añadir la línea "ENABLED=1" en el fichero HAProxy: `sudo pico /etc/default/haproxy`   

4. Modificar el fichero de configuración para añadir las IPs de las máquinas que tienen la aplicación web:   
`sudo pico /etc/haproxy/haproxy.cfg`
![](https://raw.githubusercontent.com/mfms5/guardarpunto/master/haproxy.png)   

5. Reiniciar el servicio: `sudo service haproxy restart`   

6. Comprobar que funciona correctamete accediendo a https://192.168.33.13/haproxy?stats   

### 4) Application properties y jars   
1. En el Application.properties de la aplicación web, cambiar el método de actualización de la base de datos a *none*:   
`spring.jpa.hibernate.ddl-auto=none`   
2. Generar el jar y copiarlo a la carpeta vagrant de las dos máquinas virtuales de la web.   

### 5) Ejecución
1. Arrancar la MV y el servicio de haproxy.
2. Arrancar la MV de la base de datos.
3. Arrancar las MVs de la web y la aplicación con el comando:   
`java -jar guardar_punto-0.0.1-SNAPSHOT.jar  --spring.datasource.url="jdbc:mysql://192.168.33.10:3306/guardarpuntodb?verifyServerCertificate=false&useSSL=true" --spring.datasource.username="root" --spring.datasource.password="enjutomojamuto"`   
**Nota**: Si es la primera vez que se arranca la aplicación y **la base de datos no ha sido creada**, al final de este comando hay que añadir: `--spring.jpa.hibernate.ddl-auto="create"`
4. Arancar la MV del servicio interno y el ejecutable con el comando:    
`java -jar MailRestPost-0.0.1-SNAPSHOT`   
5. Cuando se hayan iniciado todos los ejecutables, acceder a la web **desde la IP del balanceador de carga**: https://192.168.33.13/

## **Instrucciones Fase 3**

1. Instalar una máquina virtual con Vagrant y Ubuntu 14.04 como se detalla en el tema 4 de la asignatura.
2. Generar los jar de la aplicación y del servicio interno, y copiarlos en la carpeta compartida con la MV.
3. Desde el directorio en el que se encuentra el archivo *Vagrantfile*, iniciar la MV con los comandos *vagrant up* y *vagrant ssh*.
4. Una vez dentro de la MV, instalar Java 8 y MySQL con los siguientes comandos:
   1. *sudo apt-get update*
   2. *sudo apt-get install -y openjdk-8-jre*   
   3. *sudo apt-get install mysql-server*
4. **Si es la primera vez que se inicia la aplicación**, crear una nueva base de datos :
   1. *mysql -u root -p;* (introducir la contraseña que se haya escogido al instalar el servidor de MySQL).
   2. *CREATE DATABASE guardarpuntodb;*   
6. Desde el directorio raíz, acceder a la carpeta compartida con *cd vagrant*.
7. Iniciar primero el servicio interno en segundo plano: *java -jar MailRestPost-0.0.1-SNAPSHOT &*.
8. Después iniciar la aplicación: *java -jar guardar_punto-0.0.1-SNAPSHOT*.
9. Finalmente, desde el navegador acceder a la dirección https://192.168.33.10:8443

## **Entidades**

Las entidades serían:
1. Usuario: Datos del usuario como nombre, correo, contraseña, amigos, juegos...
2. Juego: Datos de los juegos como título, compañía, año de lanzamiento, género, reviews...
3. Review: Opinión y puntuación de un usuario sobre un juego.
4. Comentarios: Publicaciones más cortas que las reviews (y sin puntuación), que realiza un usuario sobre un juego.

## **Diagrama de clases**
![](https://raw.githubusercontent.com/mfms5/guardarpunto/master/Diagrama/clases_f3.jpg)

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
  
  Desde la pantalla de inicio el usuario podrá registrarse o hacer login en la página. Así mismo podrá acceder a una lista de juegos       destacados y a noticias de otras páginas. Desde la barra de navegación podrá acceder a Juegos y realizar búsquedas sin iniciar sesión   y a Perfil, Reviews y Amigos habiendo iniciado sesión (estas opciones serán comunes para todas las pantallas menos para las modales). 
  Si no se ha iniciadio sesión al hacer clic sobre las pestañas privadas (Perfil, Reviews o Amigos) se nos redirige al inicio.
  Al hacer login, se sustituiría el panel de login por uno que muestra los juegos jugados del usuario.
  
  ## **Registro**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/registro.png?raw=true)
  
  Pantalla modal desde la que el usuario podrá registrarse. Se añadiría un nuevo usuario a la base de datos.
  
  ## **Juegos**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/juegos.png?raw=true)
  
  Pantalla desde la cual el usuario podrá ver todos los juegos y desde donde podrá acceder a las diferentes fichas de los juegos. Desde   esta pantalla también podrá acceder a noticias de otras páginas. También podrá hacer uso de la barra de navegación para ir a las         pantallas para las que tenga permiso según haya iniciado sesión o no.
  En el caso de haber iniciado sesión aparecerá un icono en la barra superior desde el cual podrá cerrar sesión.
  
  ## **Ficha de Juego**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/fichaJuego.png?raw=true)
  
  Desde esta pantalla el usuario podrá ver todas las especificaciones del juego (compañía, año, género, plataforma, resumen y             puntuación), también podrá añadirlo a una de sus listas (pendiente, jugado o jugando) y ver y hacer comentarios y reviews sobre el       juego. Desde esta pantalla podrá navegar por las paginas con la barra de navegación de la misma forma que en las pantallas anteriores.
  En el caso de haber iniciado sesión aparecerá un icono en la barra superior desde el cual podrá cerrar sesión.
  
  ## **Perfil**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/perfil.png?raw=true)
  captura de pantalla del perfil personal.
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/perfilAmigo.png?raw=true)
  captura de pantalla del perfil de otro usuario.
  
  Desde esta pantalla el usuario podrá ver su información de perfil o de otro usuario (nombre, biografía, juegos jugando, jugados y       pendientes, amigos, comentarios y reviews). En caso de ser tu perfil el que estas visitando podrás acceder a los ajustes de perfil. 
  Se podrá acceder a las fichas de los juegos que están en las listas y a los perfiles de los amigos y se podrá utilizar la barra de       navegación al igual que en el resto de pantallas.
  
  ## **Editar Perfil**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/editarPerfil.png?raw=true)
  
  Pantalla modal desde la cual el usuario podrá modificar su foto de perfil mediante una url y su biografía.
  
  ## **Reviews**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/reviews.png?raw=true)
  
  Pantalla desde la cual el usuario podrá ver todas las reviews que ha hecho y acceder a los juegos de dichas reviews. Igualmente podrá   navegar mediante la barra de navegación. Solo se puede acceder si se ha iniciado sesión.
 
  ## **Amigos**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/amigos.png?raw=true)

  Pantalla desde la cual el usuario podrá ver todos los amigos que tiene (foto de perfil, nombre y biografía) y acceder a su perfil.       Podrá navegar desde la barra de navegación a las pantallas de Inicio, Juegos, Perfil, Reviews, Amigos y realizar búsquedas. Solo se     puede acceder si se ha iniciado sesión.
  
  ## **Búsquedas**
  ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/busqueda.png?raw=true)
  
  Al realizar una búsqueda se nos muestra una pantalla en la cual aparecerán las coincidencias con la búsqueda tanto entre los usuarios   como entre los juegos. Desde esta pantalla podremos acceder al perfil del usuario o del juego buscado y podremos redirigirnos a         noticias de otras páginas. Cuenta igual que el resto de pantallas con la navegación a partir de la barra de navegación. 
  
  ## **Error Login**
   ![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/error.png?raw=true)
   
   Pantalla a la que seremos redirigidos en caso de que se produzca un error al iniciar sesión (usuario o contraseña incorrectos)
  
## **Navegación entre páginas**
![](https://github.com/mfms5/guardarpunto/blob/master/Capturas%20pantalla/DiagramaPantallas.png?raw=true)
(Páginas en negrita solo si has iniciado sesión)

  ## **Inicio** 
  Desde inicio se puede acceder a:
    - Juegos
    - **Perfil (propio)**
    - **Reviews**
    - **Amigos**
    - Ficha de juego
    - Busqueda
    - Registro
    - Noticias Externas
  
  ## **Juegos** 
  Desde juegos se puede acceder a:
    - Inicio
    - **Perfil (propio)**
    - **Reviews**
    - **Amigos**
    - Ficha de juego
    - Busqueda
    - Noticias Externas
    
  ## **Perfil** (solo se puede acceder si has iniciado sesión)
  Desde perfil se puede acceder a:
    - Inicio
    - Juegos
    - Perfil (otro jugador)
    - Reviews
    - Amigos
    - EditarPerfil (solo si es tu perfil)
    - Ficha de juego
    - Busqueda
  
  ## **Reviews** (solo se puede acceder si has iniciado sesión)
  Desde reviews se puede acceder a:
    - Inicio
    - Juegos
    - Perfil
    - Amigos
    - Busqueda
    
  ## **Amigos** (solo se puede acceder si has iniciado sesión)
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
    - Juegos
    - **Perfil**
    - **Reviews**
    - **Amigos**
    - Busqueda
 
  ## **Busqueda**
  Desde busqueda se puede acceder a:
    - Inicio
    - Juegos
    - **Perfil(propio** y ajeno)
    - **Reviews**
    - **Amigos**
    - otra busqueda
    - ficha Juego
    - noticias externas
    




