package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CNPJ;

@SuppressWarnings("serial")
@Entity
public class Cadastro extends GenericEntity {

	@Column(nullable = false, length = 80, name = "razao_social")
	private String razaoSocial;

	@Column(length = 100, name = "nome_fantasia")
	private String nomeFantasia;

	@Column(length = 14)
	private String cpf;

	@CNPJ
	@Column(length = 18)
	private String cnpj;

	@Column(length = 25, nullable = true)
	private String rg;

	@Column(length = 20, name = "insc_estadual")
	private String inscEstadual;

	@Column(length = 65)
	private String rua;

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

	@Column(length = 16)
	private String celular;

	@Column(length = 70)
	private String email;

	@Column(nullable = false, name = "tipo_pessoa")
	private Character tipoPessoa;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Municipio municipio = new Municipio();

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Character tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
