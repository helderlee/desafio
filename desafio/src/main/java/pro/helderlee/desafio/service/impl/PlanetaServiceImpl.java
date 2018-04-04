package pro.helderlee.desafio.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.helderlee.desafio.integration.TopicPublisher;
import pro.helderlee.desafio.modelo.Planeta;
import pro.helderlee.desafio.modelo.SwapiPlanetMessage;
import pro.helderlee.desafio.repository.PlanetaRepository;
import pro.helderlee.desafio.service.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Autowired
	private TopicPublisher publisher;

	@Override
	public List<Planeta> listarPlanetas() {
		List<Planeta> planetas = this.planetaRepository.findAll();
		if (planetas == null) {
			return new ArrayList<Planeta>();
		}
		return planetas;
	}

	@Override
	public void adicionarPlaneta(Planeta planeta) {
		Planeta planetaSalvo = this.planetaRepository.save(planeta);
		
		SwapiPlanetMessage message = new SwapiPlanetMessage();
		message.setId(planetaSalvo.getId());
		publisher.send(message);

	}

	@Override
	public void removerPlaneta(BigInteger id) {
		Optional<Planeta> op = this.planetaRepository.findById(id);
		if (op.isPresent()) {
			this.planetaRepository.delete(op.get());
		}
	}

	@Override
	public List<Planeta> buscarPorNome(String nome) {
		return this.planetaRepository.findAllByNome(nome);
	}

	@Override
	public Planeta buscarPorId(BigInteger id) {
		Optional<Planeta> op = this.planetaRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

}
