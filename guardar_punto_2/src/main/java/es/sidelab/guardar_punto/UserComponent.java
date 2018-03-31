package es.sidelab.guardar_punto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserComponent implements Serializable {

	private Usuarios user;

	public Usuarios getLoggedUser() {
		return user;
	}

	public void setLoggedUser(Usuarios user) {
		this.user = user;
	}

	public boolean isLoggedUser() {
		return this.user != null;
	}	
}
