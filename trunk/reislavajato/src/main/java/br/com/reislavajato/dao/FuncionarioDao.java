package br.com.reislavajato.dao;

import java.util.List;

import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;

public interface FuncionarioDao extends Persistencia<Funcionario> {

	List<Funcionario> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException;

	List<Funcionario> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException;

	Funcionario consultarPorEmail(String email) throws DadosInvalidosException;
	
	Funcionario autenticar(String email, String senha) throws DadosInvalidosException;
}
