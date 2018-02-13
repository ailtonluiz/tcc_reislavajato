package br.com.reislavajato.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Empresa extends GenericEntity {

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco endereco = new Endereco();

	@OneToOne(cascade = CascadeType.ALL)
	private Telefone telefone = new Telefone();

	@Column(length = 100)
	private String email;

	@Column(length = 80)
	private String smtp;

	@Column(length = 60)
	private String senhaEmail;

	@Column(length = 6)
	private Integer portaSmtp;

	@Column(length = 100)
	private String txtMail;

	private Boolean utilizaAutenticacao = true;

	private Boolean requerSSL = true;

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getSenhaEmail() {
		return senhaEmail;
	}

	public void setSenhaEmail(String senhaEmail) {
		this.senhaEmail = senhaEmail;
	}

	public Integer getPortaSmtp() {
		return portaSmtp;
	}

	public void setPortaSmtp(Integer portaSmtp) {
		this.portaSmtp = portaSmtp;
	}

	public String getTxtMail() {
		return txtMail;
	}

	public void setTxtMail(String txtMail) {
		this.txtMail = txtMail;
	}

	public Boolean getUtilizaAutenticacao() {
		return utilizaAutenticacao;
	}

	public void setUtilizaAutenticacao(Boolean utilizaAutenticacao) {
		this.utilizaAutenticacao = utilizaAutenticacao;
	}

	public Boolean getRequerSSL() {
		return requerSSL;
	}

	public void setRequerSSL(Boolean requerSSL) {
		this.requerSSL = requerSSL;
	}

}
