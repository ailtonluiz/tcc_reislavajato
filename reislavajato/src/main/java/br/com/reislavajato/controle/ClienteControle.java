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

import br.com.reislavajato.dao.ClienteDao;
import br.com.reislavajato.dao.PessoaDao;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.Pessoa;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "deprecation", "serial" })
@ManagedBean
@ViewScoped
public class ClienteControle implements Serializable {
	ClienteDao clienteDao = new ClienteDao();
	PessoaDao pessoaDao = new PessoaDao();

	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Pessoa> pessoas;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {
		try {
			clientes = clienteDao.listar();
			pessoas = pessoaDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) cliente(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			cliente = new Cliente();
			pessoas = pessoaDao.listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			clienteDao.merge(cliente);
			listar();
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("registroSelecionado");
			clienteDao.excluir(cliente);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}
}
