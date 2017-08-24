package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ailtonluiz
 *
 */
@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericEntity {

	@Column(nullable = false, length = 18)
	private String username;

	@Column(nullable = false, length = 50)
	private String senha;

	@Column(nullable = false, name = "tipo_usuario")
	private Character tipoUsuario;

	@Column(nullable = false)
	private Boolean status;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Character tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
