package es.sidelab.guardar_punto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UsuariosRepository userRepository;
	
	//@Override
	public Authentication authenticate (Authentication auth) throws AuthenticationException {
		System.out.println("authenticate");
		
		Usuarios user = (Usuarios) (userRepository.findByNombre(auth.getName())).get(0); //name?
				
		if (user == null) {
			throw new BadCredentialsException("User not found");
		}
		
		String password = (String) auth.getCredentials();
		System.out.println(new BCryptPasswordEncoder().encode(password));
		System.out.println(user.getContrasenna());
		if (!new BCryptPasswordEncoder().matches(password, user.getContrasenna())) {
			System.out.println("maaaaaal");
			throw new BadCredentialsException("Wrong password");
		}

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return new UsernamePasswordAuthenticationToken(user.getEmail(), password, roles);
		
	}
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}
