package es.sidelab.guardar_punto;

import java.io.Serializable;

public class EstadoId implements Serializable {


private Usuarios estado_user; //Usuario que tiene el juego
private Juego juegos_estado; //juego del usuario

public EstadoId() {
	
}
public EstadoId(Usuarios user, Juego game) {
	super();
	estado_user = user;
	juegos_estado = game;
}


public Usuarios getEstado_user() {
	return estado_user;
}
public void setEstado_user(Usuarios estado_user) {
	this.estado_user = estado_user;
}
public Juego getJuegos_estado() {
	return juegos_estado;
}
public void setJuegos_estado(Juego juegos_estado) {
	this.juegos_estado = juegos_estado;
}

}
