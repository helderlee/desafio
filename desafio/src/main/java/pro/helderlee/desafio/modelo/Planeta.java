package pro.helderlee.desafio.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planetas")
public class Planeta implements Serializable {

	private static final long serialVersionUID = 3852334900503349502L;

	@Id
	private BigInteger id;

	private String nome;

	private String clima;

	private String terreno;

	private Integer aparicoes;

	public Planeta() {
	}

	public Planeta(String nome, String clima, String terreno, Integer aparicoes) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.aparicoes = aparicoes;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getAparicoes() {
		return aparicoes;
	}

	public void setAparicoes(Integer aparicoes) {
		this.aparicoes = aparicoes;
	}

}
