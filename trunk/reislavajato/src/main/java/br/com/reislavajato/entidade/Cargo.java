package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Cargo extends GenericEntity {

	@Column(length = 20, name = "nome_cargo", nullable = false)
	private String nomeCargo;

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
