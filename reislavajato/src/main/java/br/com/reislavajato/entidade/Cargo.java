package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity
public class Cargo extends GenericEntity {

	private String nomeCargo;

	//@ManyToMany(fetch = FetchType.EAGER)
	//private Set<FuncaoCargo> funcoesCargo = new HashSet<FuncaoCargo>();

	@Column(precision = 10, scale = 2)
	private BigDecimal salario;

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

//	public Set<FuncaoCargo> getFuncoesCargo() {
//		return funcoesCargo;
//	}
//
//	public void setFuncoesCargo(Set<FuncaoCargo> funcoesCargo) {
//		this.funcoesCargo = funcoesCargo;
//	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
