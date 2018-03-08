package es.sidelab.guardar_punto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		
		//Paginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/juego/{id}").permitAll();
		http.authorizeRequests().antMatchers("/Juegos").permitAll();
		http.authorizeRequests().antMatchers("/buscar").permitAll();
		http.authorizeRequests().antMatchers("/Usuario/{id}").permitAll();
		
		//Paginas privadas
		http.authorizeRequests().antMatchers("/Amigos").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/Perfil").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/Reviews").hasAnyRole("USER");
		
		//Login form
		http.formLogin().loginPage("/");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");
        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
	}

}
