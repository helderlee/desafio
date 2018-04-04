package pro.helderlee.desafio.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import pro.helderlee.desafio.resource.PlanetaResource;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(PlanetaResource.class);
	}
	
}
