package br.com.reislavajato.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * @author ailtonluiz
 *
 */
@Entity
public class Cliente extends GenericEntity {
	private static final long serialVersionUID = 4833347857185877728L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pessoa pessoa = new Pessoa();

	// getters and setters

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
