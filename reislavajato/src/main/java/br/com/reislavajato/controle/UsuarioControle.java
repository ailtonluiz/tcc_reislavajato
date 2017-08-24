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

import br.com.reislavajato.dao.PessoaDao;
import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.entidade.Usuario;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "deprecation", "serial" })
@ManagedBean
@ViewScoped
public class UsuarioControle implements Serializable {
	UsuarioDao usuarioDao = new UsuarioDao();
	PessoaDao pessoaDao = new PessoaDao();

	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
			usuarios = usuarioDao.listar();
			pessoas = pessoaDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) usuário(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			usuario = new Usuario();
			pessoas = pessoaDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			usuarioDao.merge(usuario);
			listar();
			novo();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("registroSelecionado");
			usuarioDao.excluir(usuario);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("registroSelecionado");
			pessoas = pessoaDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}

	}
}
