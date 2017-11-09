package br.com.reislavajato.neg.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.PessoaDao;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.PessoaNeg;

@Service
public class PessoaNegImpl extends NegocioGenerico<Pessoa> implements PessoaNeg {

	@Autowired
	public PessoaNegImpl(PessoaDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Pessoa> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		return ((PessoaDao) persistencia).listarPorCpfOuNome(cpf, nome);
	}

	@Transactional
	public List<Pessoa> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		return ((PessoaDao) persistencia).listarPorCnpjOuNome(cnpj, nomeFantasia);
	}

	@Transactional
	public Pessoa consultarPorEmail(String email) throws DadosInvalidosException {
		return ((PessoaDao) persistencia).consultarPorEmail(email);
	}

}
