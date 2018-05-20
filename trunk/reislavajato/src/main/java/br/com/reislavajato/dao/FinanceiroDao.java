
package br.com.reislavajato.dao;

import java.util.List;

import br.com.reislavajato.entidade.Financeiro;
import br.com.reislavajato.enumeradores.EnumStatusFinanceiro;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface FinanceiroDao extends Persistencia<Financeiro> {

	public List<Financeiro> listarPorStatus(EnumStatusFinanceiro statusFinanceiro) throws DadosInvalidosException;

}
