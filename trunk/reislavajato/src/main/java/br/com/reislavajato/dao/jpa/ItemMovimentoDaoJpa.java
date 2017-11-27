/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.ItemMovimentoDao;
import br.com.reislavajato.entidade.ItemMovimento;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class ItemMovimentoDaoJpa extends PersistenciaJpa<ItemMovimento> implements ItemMovimentoDao {

	public ItemMovimentoDaoJpa() {
		super(ItemMovimento.class);
	}
}
