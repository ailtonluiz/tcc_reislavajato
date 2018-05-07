/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reislavajato.dao.FornecedorDao;
import br.com.reislavajato.entidade.Fornecedor;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FornecedorNeg;

/**
 * @Criado por: ailto
 * @Data: 29 de abr de 2018
 */
@Service
public class FornecedorNegImpl extends NegocioGenerico<Fornecedor> implements FornecedorNeg {

	@Autowired
	public FornecedorNegImpl(FornecedorDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Fornecedor> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		return ((FornecedorDao) persistencia).listarPorCpfOuNome(cpf, nome);
	}

	@Transactional
	public List<Fornecedor> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		return ((FornecedorDao) persistencia).listarPorCnpjOuNomeFantasia(cnpj, nomeFantasia);
	}

	@Transactional
	public List<Fornecedor> listarPorTipoPessoa(EnumTipoPessoa tipoPessoa) throws DadosInvalidosException {
		return ((FornecedorDao) persistencia).listarPorTipoPessoa(tipoPessoa);
	}
}
