package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.UsuarioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class UsuarioControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private UsuarioNeg usuarioNeg = context.getBean(UsuarioNeg.class);
	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);

	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Funcionario> funcionarios;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			usuarios = usuarioNeg.listar();
			funcionarios = funcionarioNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) usuário(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() throws DadosInvalidosException {
		try {
			usuario = new Usuario();
			funcionarios = funcionarioNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			usuarioNeg.incluir(usuario);
			listar();
			novo();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("registroSelecionado");
			usuarioNeg.excluir(usuario);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("registroSelecionado");
			funcionarios = funcionarioNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}

	}

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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.reislavajato.controle.ReisLavajatoControle#criarEntidade()
	 */
	@Override
	protected void criarEntidade() {
		// TODO Auto-generated method stub

	}

}
