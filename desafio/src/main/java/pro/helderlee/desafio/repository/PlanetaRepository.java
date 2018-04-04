package pro.helderlee.desafio.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pro.helderlee.desafio.modelo.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, BigInteger> {
	
	List<Planeta> findAllByNome(String nome);

}
