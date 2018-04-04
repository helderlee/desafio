package pro.helderlee.desafio.integration;

import java.math.BigInteger;

import org.springframework.web.client.RestTemplate;

import pro.helderlee.desafio.modelo.SwapiPlanet;

public class PlanetaIntegration {
	
	public Integer buscarNumeroAparicoesSwapiPorId(BigInteger id) {
		RestTemplate restTemplate = new RestTemplate();
		SwapiPlanet planet = restTemplate.getForObject("https://swapi.co/api/planets/" + id.toString(), SwapiPlanet.class);
		if (planet != null) {
			return planet.getFilms().size();
		} else {
			return null;
		}
	}

}
