package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PessoaJuridica extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Column(length = 80)
	private String razaoSocial;

	@Column(length = 100)
	private String nomeFantasia;

	private String cnpj;

	private String inscricaoEstadual;
	private String inscricaoMunicipal;

	@Temporal(TemporalType.DATE)
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

	public Date getDataAberturaEmpresa() {
		return dataAberturaEmpresa;
	}

	public void setDataAberturaEmpresa(Date dataAberturaEmpresa) {
		this.dataAberturaEmpresa = dataAberturaEmpresa;
	}

}
