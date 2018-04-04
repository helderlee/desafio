package pro.helderlee.desafio.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pro.helderlee.desafio.modelo.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, BigInteger> {
	
	Planeta findByNome(String nome);

}
