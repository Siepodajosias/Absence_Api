package org.upb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService  userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void authenticationManager(AuthenticationManagerBuilder auth) throws Exception{
		 auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder).and().build();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.formLogin();
		http.authorizeHttpRequests().antMatchers("/login/**","/api/upb/inscriptions/**").permitAll();
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST,"/api/upb/absences/**").hasAnyAuthority("ENSEIGNANT","ADMINISTRATEUR");
		http.authorizeHttpRequests().antMatchers(
				"/api/upb/etudiants/**"
				,"/api/upb/absences/**"
				,"/api/upb/administrateurs/**"
				,"/api/upb/enseignants/**"
				,"/api/upb/filieres/**"
				,"/api/upb/niveaux/**"
				,"/api/upb/parents/**"
				,"/api/upb/justifications/**"
				,"/api/upb/semestres/**"
				,"/api/upb/anneeAcademiques/**"
				,"/api/upb/ecues/**"
				,"/api/upb/roles/**"
				,"/api/upb/utilisateurs/**"
				).authenticated();
	
		http.addFilter(new JWTAuthenticationFiller(authenticationManager));
		http.addFilterBefore(new JWTAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
		
	  return (web) -> web.ignoring().antMatchers("/swagger-ui/**");
		
	}

}
