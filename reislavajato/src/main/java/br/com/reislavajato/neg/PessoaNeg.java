package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.neg.excessao.DadosInvalidosException;

public interface PessoaNeg extends Negocio<Pessoa> {

	List<Pessoa> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException;

	List<Pessoa> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws DadosInvalidosException;

	Pessoa consultarPorEmail(String email) throws DadosInvalidosException;
}
