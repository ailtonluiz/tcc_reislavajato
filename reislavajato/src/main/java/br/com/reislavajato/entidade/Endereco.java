package br.com.reislavajato.entidade;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Endereco extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private Municipio municipio = new Municipio();

	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private boolean ativo = true;

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
