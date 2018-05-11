package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity(name = "pessoa_juridica")
public class PessoaJuridica extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Column(length = 80, name = "razao_social")
	private String razaoSocial;

	@Column(length = 100, name = "nome_fantasia")
	private String nomeFantasia;

	@CNPJ
	private String cnpj;

	@Column(name = "insc_estadual")
	private String inscricaoEstadual;

	@Column(name = "insc_municipal")
	private String inscricaoMunicipal;

	@Column(name ="contato_empresa")
	private String contatoEmpresa;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_abertura")
	private Date dataAberturaEmpresa;

	// getters and setters

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getContatoEmpresa() {
		return contatoEmpresa;
	}

	public void setContatoEmpresa(String contatoEmpresa) {
		this.contatoEmpresa = contatoEmpresa;
	}

	public Date getDataAberturaEmpresa() {
		return dataAberturaEmpresa;
	}

	public void setDataAberturaEmpresa(Date dataAberturaEmpresa) {
		this.dataAberturaEmpresa = dataAberturaEmpresa;
	}

}
