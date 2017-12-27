package br.com.reislavajato.entidade;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
}
