package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.dao.PessoaDao;
import br.com.reislavajato.entidade.Pessoa;

public class PessoaNeg extends PessoaDao {
	public List<Pessoa> listarPorCpfOuNome(Long cpf, String nome) throws Exception {
		return listarPorCpfOuNome(cpf, nome);
	}

	public List<Pessoa> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws Exception {
		return listarPorCnpjOuNome(cnpj, nomeFantasia);
	}

	public Pessoa consultarPorEmail(String email) throws Exception {
		return consultarPorEmail(email);
	}
}
