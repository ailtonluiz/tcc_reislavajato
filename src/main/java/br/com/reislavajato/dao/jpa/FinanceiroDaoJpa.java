/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.FinanceiroDao;
import br.com.reislavajato.entidade.Financeiro;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class FinanceiroDaoJpa extends PersistenciaJpa<Financeiro> implements FinanceiroDao {

	public FinanceiroDaoJpa() {
		super(Financeiro.class);
	}
}
