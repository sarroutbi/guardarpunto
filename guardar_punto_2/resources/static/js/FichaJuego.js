
//Array de estrellas que asigna el usuario
var estrellas = document.getElementsByClassName("estrellaUsuario");

function puntuacion(n) {
    //Recorrer array de estrellas y cambiar el color segun n
    for (i = 0; i < estrellas.length; i++) {
        if(i <= (n-1))
            estrellas[i].style.color = "orange";
        else
            estrellas[i].style.color = "black";
    }

    //enviar puntuacion usario y recalcular la media
}

//Ocultar el panel de login para mostrar el de mis juegos
function ocultarLogin() {
    var login = document.getElementById("login");
    var tusJuegos = document.getElementById("tusJuegos");

    login.style.display = "none";
    tusJuegos.style.display = "block";
}