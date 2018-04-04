package pro.helderlee.desafio.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pro.helderlee.desafio.modelo.Planeta;
import pro.helderlee.desafio.service.PlanetaService;

@Component
@Path("/planetas")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class PlanetaResource {

	@Autowired
	private PlanetaService planetaService;

	@GET
	public List<Planeta> buscarPlanetas(@QueryParam("nome") String nome) {
		List<Planeta> planetas = null;
		if (nome == null) {
			planetas = this.planetaService.listarPlanetas();
		} else {
			planetas = this.planetaService.buscarPorNome(nome);
		}
		if (planetas == null) {
			return new ArrayList<Planeta>();
		}
		return planetas;
	}

	@GET
	@Path("/{id}")
	public Planeta buscarPlanetaPorId(@PathParam("id") Long id) {
		return this.planetaService.buscarPorId(id);
	}

	@POST
	public Response adicionarPlaneta(Planeta planeta) {
		this.planetaService.adicionarPlaneta(planeta);
		return Response.created(URI.create("/" + planeta.getId())).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removerPlaneta(@PathParam("id") Long id) {
		this.planetaService.removerPlaneta(id);
		return Response.ok().build();
	}

}
