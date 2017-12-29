/**
 * 
 */
package br.com.reislavajato.dao;

import java.util.List;

import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface MovimentoDao extends Persistencia<Movimento> {

	public List<Movimento> listarPorStatusServico(EnumStatusServico statusServico) throws DadosInvalidosException;
}
