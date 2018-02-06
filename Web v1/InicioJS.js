//Ocultar el panel de login para mostrar el de mis juegos
function ocultarLogin() {
    var login = document.getElementById("login");
    var tusJuegos = document.getElementById("tusJuegos");

    login.style.display = "none";
    tusJuegos.style.display = "block";
}