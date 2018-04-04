package pro.helderlee.desafio.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import pro.helderlee.desafio.modelo.SwapiPlanetMessage;

@Component
public class TopicPublisher {
	
	public static final String TOPIC = "planeta-salvo";
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(SwapiPlanetMessage message) {
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.convertAndSend(TOPIC, message);
	}

}
