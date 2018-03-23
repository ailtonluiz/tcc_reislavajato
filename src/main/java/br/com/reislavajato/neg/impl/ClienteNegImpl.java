/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reislavajato.dao.ClienteDao;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class ClienteNegImpl extends NegocioGenerico<Cliente> implements ClienteNeg {

	@Autowired
	public ClienteNegImpl(ClienteDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Cliente> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		return ((ClienteDao) persistencia).listarPorCpfOuNome(cpf, nome);
	}

	@Transactional
	public List<Cliente> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		return ((ClienteDao) persistencia).listarPorCnpjOuNomeFantasia(cnpj, nomeFantasia);
	}

	@Transactional
	public List<Cliente> listarPorTipoPessoa(EnumTipoPessoa tipoPessoa) throws DadosInvalidosException {
		return ((ClienteDao) persistencia).listarPorTipoPessoa(tipoPessoa);
	}
}
