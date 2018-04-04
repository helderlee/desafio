package pro.helderlee.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import pro.helderlee.desafio.integration.PlanetaIntegration;
import pro.helderlee.desafio.modelo.Planeta;
import pro.helderlee.desafio.repository.PlanetaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = {"test"})
public class DesafioApplicationTests {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Before
	public void setUp() throws Exception {
		Planeta p1 = new Planeta("Tatooine", "arid", "desert");
		Planeta p2 = new Planeta("Alderaan", "temperate", "grasslands, mountains");
		assertNull(p1.getId());
		assertNull(p2.getId());
		p1.setId(new BigInteger("1"));
		p2.setId(new BigInteger("2"));
		this.planetaRepository.save(p1);
		this.planetaRepository.save(p2);
		assertNotNull(p1.getId());
		assertNotNull(p2.getId());
	}
	
	@Test
	public void testFindAll() {
		List<Planeta> planetas = this.planetaRepository.findAll();
		assertEquals(2, planetas.size());
	}
	
	@Test
	public void testSave() {
		Planeta p3 = new Planeta("Yavin IV", "temperate, tropical", "jungle, rainforests");
		assertNull(p3.getId());
		this.planetaRepository.save(p3);
		assertNotNull(p3.getId());
		List<Planeta> planetas = this.planetaRepository.findAll();
		assertEquals(3, planetas.size());
	}
	
	@Test
	public void testFindByNome() {
		List<Planeta> lista = this.planetaRepository.findAllByNome("Tatooine");
		assertEquals(1, lista.size());
	}
	
	@Test
	public void testFindById() {
		Optional<Planeta> p1 = this.planetaRepository.findById(new BigInteger("1"));
		assertTrue(p1.isPresent());
	}
	
	@Test
	public void testDelete() {
		Optional<Planeta> p1 = this.planetaRepository.findById(new BigInteger("1"));
		assertTrue(p1.isPresent());
		this.planetaRepository.delete(p1.get());
		p1 = this.planetaRepository.findById(new BigInteger("1"));
		assertFalse(p1.isPresent());
	}

	/*
	@Test
	public void testIntegracaoSwapi() {
		PlanetaIntegration integracao = new PlanetaIntegration();
		Integer qtd = integracao.buscarNumeroAparicoesSwapiPorId(1L);
		assertEquals(10, qtd.intValue());
	}
	*/

	@After
	public void tearDown() throws Exception {
		this.planetaRepository.deleteAll();
	}

}
