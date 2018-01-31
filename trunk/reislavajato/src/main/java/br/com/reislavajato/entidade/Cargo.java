package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Cargo extends GenericEntity {

	private String nomeCargo;

	@Column(precision = 10, scale = 2)
	private BigDecimal salario;

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
