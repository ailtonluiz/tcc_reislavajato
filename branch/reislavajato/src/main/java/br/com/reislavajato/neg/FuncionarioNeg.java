package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;

public interface FuncionarioNeg extends Negocio<Funcionario> {

	List<Funcionario> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException;

	Funcionario autenticar(String email, String senha) throws DadosInvalidosException;

	Funcionario consultarPorEmail(String email) throws DadosInvalidosException;
}
