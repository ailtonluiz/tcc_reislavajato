package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Cargo extends GenericEntity {

	@Column(unique = true)
	private String nomeCargo;

	//getters and setters
	
	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
