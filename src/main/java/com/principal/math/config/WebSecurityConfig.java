
package com.principal.math.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
		.antMatchers("/resources/**",
				"/login",
				"/",
				"/img/**",
				"/css/**",
				"/assets/**", 
				"/js/**",
				"/registration",
				"/chat/**",
				"/eventos",
				"/conteudo/**",
				"/Conteudos/6/**",
				"/Conteudos/7/**",
				"/Conteudos/8/**",
				"/Conteudos/9/**")
			.permitAll()
		.anyRequest()
			.authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home")
			.failureUrl("/login?error=true")
			.permitAll()
		.and()
		.logout()
			.logoutSuccessUrl("/login?logout=true")
			.permitAll()
			.and()
			.httpBasic();

//		http.cors()
//			.and()
//			.authorizeRequests()
//			.antMatchers("/**")
//			.permitAll()
//			.and()
//			.csrf()
//			.disable();
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("/**", "http://localhost:8080/eventos"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "HEAD", "PUT", "OPTIONS", "MESSAGE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("*", configuration);
		return source;
	}
}