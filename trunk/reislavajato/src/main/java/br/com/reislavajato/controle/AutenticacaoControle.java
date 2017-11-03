/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.entidade.Usuario;

/**
 * @Criado por: ailtonluiz
 * @Data: 1 de out de 2017
 */
@ManagedBean
@SessionScoped
public class AutenticacaoControle {
	private Usuario usuario;
	private Usuario usuarioLogado;

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioLogado = usuarioDao.autenticar(usuario.getUsername(), usuario.getSenha());
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

}
