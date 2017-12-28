package br.com.reislavajato.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.reislavajato.enumeradores.EnumMarca;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Veiculo extends GenericEntity {

	private String placa;

	private String cor;
	
	@Enumerated(EnumType.STRING)
	private EnumMarca marca = EnumMarca.FIAT;

	private String modelo;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public EnumMarca getMarca() {
		return marca;
	}

	public void setMarca(EnumMarca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
