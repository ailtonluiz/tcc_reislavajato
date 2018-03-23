/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumMarca;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface VeiculoNeg extends Negocio<Veiculo> {

	List<Veiculo> listarVeiculoPorMarca(EnumMarca marca) throws DadosInvalidosException;

}
