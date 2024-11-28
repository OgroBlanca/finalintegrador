package pe.edu.utp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pe.edu.utp.security.CustomAccessDeniedHandler;
import pe.edu.utp.security.CustomUserDetailsService;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Autowired
	CustomUserDetailsService customUserDetailsServices;

	private final CustomAccessDeniedHandler customAccessDeniedHandler;
    @Autowired
	public SecurityConfig(CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/autenticacion/**").permitAll()
		.requestMatchers("/**").permitAll()
		.requestMatchers("/admin/**").hasRole("ADMIN")
		.requestMatchers("/home").permitAll().and()	
		.formLogin()
		.loginPage("/usuario/login")
		.loginProcessingUrl("/usuario/login")
		.usernameParameter("correo")
		.passwordParameter("contraseña")
		.defaultSuccessUrl("/home", true).permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
		.and()
		.logout()
		.invalidateHttpSession(true)
	     .clearAuthentication(true)
	     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	     .logoutSuccessUrl("/usuario/login?logout").permitAll();
		
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserDetailsServices).passwordEncoder(passwordEncoder());
	}
}