package pro.helderlee.desafio.service;

import java.util.List;

import pro.helderlee.desafio.modelo.Planeta;

public interface PlanetaService {

	List<Planeta> listarPlanetas();
	
	void adicionarPlaneta(Planeta planeta);
	
	void removerPlaneta(Long id);
	
	List<Planeta> buscarPorNome(String nome);
	
	Planeta buscarPorId(Long id);
}
