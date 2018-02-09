/**
 * 
 */
package br.com.reislavajato.dao;

import java.util.List;

import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface OrdemServicoDao extends Persistencia<OrdemServico> {

	public List<OrdemServico> listarPorStatus(EnumStatusServico statusServico) throws DadosInvalidosException;

	public List<OrdemServico> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException;

	public List<OrdemServico> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException;

}
