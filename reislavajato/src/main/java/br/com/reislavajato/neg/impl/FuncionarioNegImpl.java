package br.com.reislavajato.neg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;

@Service
public class FuncionarioNegImpl extends NegocioGenerico<Funcionario> implements FuncionarioNeg {

	@Autowired
	public FuncionarioNegImpl(FuncionarioDao persistencia) {
		super(persistencia);
	}

	@Transactional // possibilita adicionar atributos relacionadas à transação do método como
					// propagation, rollbackfor...
	public List<Funcionario> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		return ((FuncionarioDao) persistencia).listarPorCpfOuNome(cpf, nome);
	}

	@Transactional
	public List<Funcionario> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia)
			throws DadosInvalidosException {
		return ((FuncionarioDao) persistencia).listarPorCnpjOuNomeFantasia(cnpj, nomeFantasia);
	}

	@Transactional
	public Funcionario consultarPorEmail(String email) throws DadosInvalidosException {
		return ((FuncionarioDao) persistencia).consultarPorEmail(email);
	}

	@Transactional
	public Funcionario autenticar(String login, String senha) throws DadosInvalidosException {

		return ((FuncionarioDao) persistencia).autenticar(login, senha);

	}

}
