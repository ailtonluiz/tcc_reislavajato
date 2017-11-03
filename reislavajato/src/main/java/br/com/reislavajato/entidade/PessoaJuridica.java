package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class PessoaJuridica extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 80)
	private String razaoSocial;

	@Column(length = 100)
	private String nomeFantasia;

	@CNPJ
	@Column(length = 18)
	private Long cnpj;

	@Column(length = 20)
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private Date dataAberturaEmpresa;

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

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
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
