/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reislavajato.dao.OrdemServicoDao;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.OrdemServicoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class OrdemServicoNegImpl extends NegocioGenerico<OrdemServico> implements OrdemServicoNeg {

	@Autowired
	public OrdemServicoNegImpl(OrdemServicoDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<OrdemServico> listarPorStatus(EnumStatusServico statusServico) throws DadosInvalidosException {
		return ((OrdemServicoDao) persistencia).listarPorStatus(statusServico);
	}

	@Transactional
	public List<OrdemServico> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		return ((OrdemServicoDao) persistencia).listarPorCpfOuNome(cpf, nome);
	}

	@Transactional
	public List<OrdemServico> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		return ((OrdemServicoDao) persistencia).listarPorCnpjOuNomeFantasia(cnpj, nomeFantasia);
	}
}
