/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.PessoaJuridicaDao;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.PessoaJuridica;

/**
 * @Criado por: Unint
 * @Data: 26 de jan de 2018
 */

@Repository
public class PessoaJuridicaDaoJpa extends PersistenciaJpa<PessoaJuridica> implements PessoaJuridicaDao {
	public PessoaJuridicaDaoJpa() {
		super(PessoaJuridica.class);
	}
}
