/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Fornecedor;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailto
 * @Data: 29 de abr de 2018
 */
public interface FornecedorNeg extends Negocio<Fornecedor> {
	
	public List<Fornecedor> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException;

	public List<Fornecedor> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException;

	public List<Fornecedor> listarPorTipoPessoa(EnumTipoPessoa tipoPessoa) throws DadosInvalidosException;

}
