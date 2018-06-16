/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.FinanceiroDao;
import br.com.reislavajato.entidade.Financeiro;
import br.com.reislavajato.enumeradores.EnumStatusFinanceiro;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class FinanceiroDaoJpa extends PersistenciaJpa<Financeiro> implements FinanceiroDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinanceiroDaoJpa() {
		super(Financeiro.class);
	}

	@Override
	public List<Financeiro> listarPorStatus(EnumStatusFinanceiro statusFinanceiro) throws DadosInvalidosException {
		
		return null;
	}
}
