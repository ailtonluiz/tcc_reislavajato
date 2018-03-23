package br.com.reislavajato.entidade;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Endereco extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Municipio municipio = new Municipio();

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String numero;

	// getters and setters

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
