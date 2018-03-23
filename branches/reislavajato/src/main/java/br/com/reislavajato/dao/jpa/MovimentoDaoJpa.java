/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import br.com.reislavajato.entidade.Movimento;

/**
 * @Criado por: ailto
 * @Data: 20 de mar de 2018
 */
public class MovimentoDaoJpa extends PersistenciaJpa(Movimento) implements MovimentoDao{
	public MovimentoDaoJpa() {
		super(Movimento.class);
	}

}
