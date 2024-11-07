package br.coto.plataform.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain securityFilterChain( ServerHttpSecurity http ) throws Exception {
		
		 http.authorizeExchange(requests ->
         	requests
         		.pathMatchers("/**")
         			.authenticated()
         		.anyExchange()
         			.permitAll()
         	)
		 	.oauth2ResourceServer(oAuth -> oAuth.jwt(Customizer.withDefaults()));
		
		return http.build(); // Necessário para compilar o filtro
	}
}
