package pro.helderlee.desafio.modelo;

import java.io.Serializable;
import java.math.BigInteger;

public class SwapiPlanetMessage implements Serializable {

	private static final long serialVersionUID = -2938278228377602732L;

	private BigInteger id;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

}
