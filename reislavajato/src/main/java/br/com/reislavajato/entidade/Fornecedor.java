/**
 * 
 */
package br.com.reislavajato.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * @Criado por: ailtonluiz
 * @Data: 29 de abr de 2018
 */
@Entity
public class Fornecedor extends GenericEntity {
	private static final long serialVersionUID = 4833347857185877728L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pessoa pessoa = new Pessoa();

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
