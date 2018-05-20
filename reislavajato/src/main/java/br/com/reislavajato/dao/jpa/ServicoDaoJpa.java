/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.ServicoDao;
import br.com.reislavajato.entidade.Servico;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class ServicoDaoJpa extends PersistenciaJpa<Servico> implements ServicoDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicoDaoJpa() {
		super(Servico.class);
	}
}
