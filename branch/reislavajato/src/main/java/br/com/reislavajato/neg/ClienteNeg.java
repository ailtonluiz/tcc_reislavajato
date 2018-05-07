/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface ClienteNeg extends Negocio<Cliente> {

	public List<Cliente> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException;

	public List<Cliente> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException;

	public List<Cliente> listarPorTipoPessoa(EnumTipoPessoa tipoPessoa) throws DadosInvalidosException;
}
