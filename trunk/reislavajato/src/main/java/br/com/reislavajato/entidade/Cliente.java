package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

/**
 * @author ailtonluiz
 *
 */
@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericEntity {

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Pessoa pessoa = new Pessoa();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();

	@Transient
	private Veiculo veiculo = new Veiculo();

	@Column(precision = 10, scale = 2)
	private BigDecimal descontoServico;

	// getters and setters
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public BigDecimal getDescontoServico() {
		return descontoServico;
	}

	public void setDescontoServico(BigDecimal descontoServico) {
		this.descontoServico = descontoServico;
	}
}
