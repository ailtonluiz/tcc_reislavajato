/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 20 de mar de 2018
 */
public interface MovimentoNeg extends Negocio<Movimento> {
	
	public List<Movimento> listar() throws DadosInvalidosException;

}
