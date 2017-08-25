/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.dao.CadastroDao;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Cadastro;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "deprecation", "serial" })
@ManagedBean
@ViewScoped
public class FuncionarioControle implements Serializable {

	FuncionarioDao funcionarioDao = new FuncionarioDao();
	CadastroDao cadastroDao = new CadastroDao();

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Cadastro> cadastros;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Cadastro> getPessoas() {
		return cadastros;
	}

	public void setPessoas(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	@PostConstruct
	public void listar() {
		try {
			funcionarios = funcionarioDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) funcionário(s)!");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {
			funcionario = new Funcionario();
			cadastros = cadastroDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			funcionarioDao.merge(funcionario);
			novo();
			listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			funcionarioDao.excluir(funcionario);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			cadastros = cadastroDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

}
