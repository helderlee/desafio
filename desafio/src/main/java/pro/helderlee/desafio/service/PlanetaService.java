package pro.helderlee.desafio.service;

import java.math.BigInteger;
import java.util.List;

import pro.helderlee.desafio.modelo.Planeta;

public interface PlanetaService {

	List<Planeta> listarPlanetas();
	
	void adicionarPlaneta(Planeta planeta);
	
	void removerPlaneta(BigInteger id);
	
	List<Planeta> buscarPorNome(String nome);
	
	Planeta buscarPorId(BigInteger id);
}
