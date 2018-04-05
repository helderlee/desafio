package pro.helderlee.desafio.integration;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import pro.helderlee.desafio.modelo.Planeta;
import pro.helderlee.desafio.modelo.SwapiPlanetMessage;
import pro.helderlee.desafio.repository.PlanetaRepository;

@Component
public class TopicSubscriber {

	private final Logger slf4jLogger = LoggerFactory.getLogger(TopicSubscriber.class);

	@Autowired
	private PlanetaRepository planetaRepository;

	@JmsListener(destination = TopicPublisher.TOPIC)
	public void receive(SwapiPlanetMessage message) {
		PlanetaIntegration integracao = new PlanetaIntegration();
		Integer numero = integracao.buscarNumeroAparicoesSwapiPorId(message.getId());
		slf4jLogger.info("Numero de aparicoes: " + numero);
		Optional<Planeta> op = this.planetaRepository.findById(message.getId());
		if (op.isPresent()) {
			Planeta planeta = op.get();
			planeta.setNumeroAparicoes(numero);
			this.planetaRepository.save(planeta);
		}
	}
}
