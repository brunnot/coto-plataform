package br.coto.plataform.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

	@Bean
	public KeyResolver clientIdKeyResolver() {
		return exchange -> {
			return getClientIdFromToken();
		};
	}

	private Mono<String> getClientIdFromToken() {
		
		return ReactiveSecurityContextHolder.getContext()
			.map( context -> {
				Authentication authentication = context.getAuthentication();
				
	            if (authentication instanceof JwtAuthenticationToken) {
	                
	            	JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
	                String tokenValue = (String) jwtAuth.getTokenAttributes().get( "client_id" );
	                return tokenValue;
	            }

	            return null;
			} );
		
//		Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getCredentials();
//		return ( jwt != null ? jwt.getClaimAsString("clientId") : null );
	}
}
