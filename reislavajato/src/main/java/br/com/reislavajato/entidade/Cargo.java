package br.com.reislavajato.entidade;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Cargo extends GenericEntity {

	private String nomeCargo;



	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}



}
