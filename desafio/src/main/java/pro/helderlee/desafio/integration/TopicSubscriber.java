package pro.helderlee.desafio.integration;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import pro.helderlee.desafio.modelo.SwapiPlanetMessage;

@Component
public class TopicSubscriber {
	
	private static int tentativas = 0;

	@JmsListener(destination = TopicPublisher.TOPIC)
	public void receive(SwapiPlanetMessage message) {
		tentativas++;
		System.out.println("Tentativas: " + tentativas);
		System.out.println("Id recebido pelo subscriber: " + message.getId());
		PlanetaIntegration integracao = new PlanetaIntegration();
		Integer numero = integracao.buscarNumeroAparicoesSwapiPorId(message.getId());
		System.out.println("Numero de aparicoes: " + numero);
	}
}
