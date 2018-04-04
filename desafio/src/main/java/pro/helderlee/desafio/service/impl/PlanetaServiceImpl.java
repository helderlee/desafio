package pro.helderlee.desafio.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.helderlee.desafio.modelo.Planeta;
import pro.helderlee.desafio.repository.PlanetaRepository;
import pro.helderlee.desafio.service.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

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
		this.planetaRepository.save(planeta);
	}

	@Override
	public void removerPlaneta(Long id) {
		Optional<Planeta> op = this.planetaRepository.findById(new BigInteger(id.toString()));
		if (op.isPresent()) {
			this.planetaRepository.delete(op.get());
		}
	}

	@Override
	public List<Planeta> buscarPorNome(String nome) {
		return this.planetaRepository.findAllByNome(nome);
	}

	@Override
	public Planeta buscarPorId(Long id) {
		Optional<Planeta> op = this.planetaRepository.findById(new BigInteger(id.toString()));
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

}
