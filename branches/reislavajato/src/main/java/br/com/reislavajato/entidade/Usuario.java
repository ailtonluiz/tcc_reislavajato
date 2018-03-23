package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
	private String password;

	@Transient
	private String senhaSemCriptografia;

	@Column(nullable = false, name = "tipo_usuario")
	private Character tipoUsuario;

	@Column(nullable = false)
	private Boolean status = true;

	@OneToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
