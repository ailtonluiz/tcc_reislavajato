/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 5 de set de 2017
 */
public interface EmpresaNeg extends Negocio<Empresa> {

	public List<Empresa> listarPorCnpjOuNomeFantasiaOuRazaoSocial(String cnpj, String nomeFantasia, String razaoSocial)
			throws DadosInvalidosException;

}
