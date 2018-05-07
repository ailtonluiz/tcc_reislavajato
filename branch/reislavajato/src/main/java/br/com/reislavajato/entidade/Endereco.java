package br.com.reislavajato.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {//extends GenericEntity {
//	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "endereco_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enderecoId;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = true)
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

	/**
	 * @return the enderecoId
	 */
	public Long getEnderecoId() {
		return enderecoId;
	}

	/**
	 * @param enderecoId the enderecoId to set
	 */
	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getEnderecoId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enderecoId == null) ? 0 : enderecoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (enderecoId == null) {
			if (other.enderecoId != null)
				return false;
		} else if (!enderecoId.equals(other.enderecoId))
			return false;
		return true;
	}
}
