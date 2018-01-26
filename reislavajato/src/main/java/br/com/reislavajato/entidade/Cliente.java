package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Veiculo> veiculos = new HashSet<Veiculo>();

	@Transient // usado para popular a lista de veiculos
	private Veiculo veiculo = new Veiculo();

	@Column(precision = 10, scale = 2)
	private BigDecimal descontoServico;
	

	// getters and setters
	public void addVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

	public void removeVeiculo(Veiculo veiculo) {
		veiculos.remove(veiculo);
	}

	public List<Veiculo> getVeiculosLista() {
		List<Veiculo> lista = new ArrayList<Veiculo>(veiculos);
		return lista;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public BigDecimal getDescontoServico() {
		return descontoServico;
	}

	public void setDescontoServico(BigDecimal descontoServico) {
		this.descontoServico = descontoServico;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
