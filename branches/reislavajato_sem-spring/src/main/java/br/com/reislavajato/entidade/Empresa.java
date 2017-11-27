package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.br.CNPJ;

@SuppressWarnings("serial")
@Entity
public class Empresa extends GenericEntity {

	@Column(nullable = false, length = 100, name = "razao_social")
	private String razaoSocial;

	@Column(nullable = false, length = 100, name = "fantasia")
	private String fantasia;

	@CNPJ
	@Column(length = 18)
	private String cnpj;

	@Column(length = 25, nullable = true, name = "insc_estadual")
	private String inscEstadual;

	@Column(length = 100)
	private String endereco;

	@Column(length = 5)
	private String numero;

	@Column(length = 40)
	private String bairro;

	@Column(length = 10)
	private String cep;

	@Column(length = 25)
	private String complemento;

	@Column(length = 13)
	private String telefone;

	@Column(length = 70)
	private String email;

	@Column(length = 70)
	private String smtp;

	@Column(length = 4, name = "porta_smtp")
	private String portaSmtp;

	@Column(length = 50, name = "senha_mail")
	private String senhaMail;

	@Column(length = 80)
	private String contato;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;

	@Column
	private Boolean ativo = true;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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

	public String getPortaSmtp() {
		return portaSmtp;
	}

	public void setPortaSmtp(String portaSmtp) {
		this.portaSmtp = portaSmtp;
	}

	public String getSenhaMail() {
		return senhaMail;
	}

	public void setSenhaMail(String senhaMail) {
		this.senhaMail = senhaMail;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
