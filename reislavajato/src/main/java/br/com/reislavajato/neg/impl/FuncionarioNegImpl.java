package br.com.reislavajato.neg.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Transactional
	public List<Funcionario> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		return ((FuncionarioDao) persistencia).listarPorCpfOuNome(cpf, nome);
	}

	@Transactional
	public List<Funcionario> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		return ((FuncionarioDao) persistencia).listarPorCnpjOuNome(cnpj, nomeFantasia);
	}

	@Transactional
	public Funcionario consultarPorEmail(String email) throws DadosInvalidosException {
		return ((FuncionarioDao) persistencia).consultarPorEmail(email);
	}

}