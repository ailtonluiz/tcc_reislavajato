
package br.com.reislavajato.controle;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.UsuarioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 1 de out de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@SessionScoped
public class AutenticacaoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private UsuarioNeg usuarioNeg = context.getBean(UsuarioNeg.class);

	private Usuario usuario;
	private Usuario usuarioLogado;

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() throws DadosInvalidosException {
		try {
			usuarioLogado = usuarioNeg.autenticar(usuario.getUsername(), usuario.getSenha());
			if (usuarioLogado == null) {
				Messages.addGlobalError("Usuário e/ou senha inválido!");
				return;
			} else {
				Faces.redirect("./pages/principal.xhtml");
				Messages.addGlobalInfo("Seja bem vindo!");
			}
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
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
