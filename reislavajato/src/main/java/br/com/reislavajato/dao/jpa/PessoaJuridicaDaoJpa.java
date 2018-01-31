/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.PessoaJuridicaDao;
import br.com.reislavajato.entidade.PessoaJuridica;

/**
 * @Criado por: Unint
 * @Data: 26 de jan de 2018
 */

@Repository
public class PessoaJuridicaDaoJpa extends PersistenciaJpa<PessoaJuridica> implements PessoaJuridicaDao {
	private static final long serialVersionUID = -3341732872646374640L;

	public PessoaJuridicaDaoJpa() {
		super(PessoaJuridica.class);
	}
}
