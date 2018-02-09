/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface OrdemServicoNeg extends Negocio<OrdemServico> {

	public List<OrdemServico> listarPorStatus(EnumStatusServico statusServico) throws DadosInvalidosException;
}
