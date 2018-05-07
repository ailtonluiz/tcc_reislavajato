package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.reislavajato.enumeradores.EnumUf;

@Entity
public class Municipio {//extends GenericEntity {
//	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "municipio_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long municipioId;

	private Long codigo;

	@Column(nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	private EnumUf uf = EnumUf.GO;

	// getters and setters

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnumUf getUf() {
		return uf;
	}

	public void setUf(EnumUf uf) {
		this.uf = uf;
	}

	/**
	 * @return the municipioId
	 */
	public Long getMunicipioId() {
		return municipioId;
	}

	/**
	 * @param municipioId
	 *            the municipioId to set
	 */
	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getMunicipioId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((municipioId == null) ? 0 : municipioId.hashCode());
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
		Municipio other = (Municipio) obj;
		if (municipioId == null) {
			if (other.municipioId != null)
				return false;
		} else if (!municipioId.equals(other.municipioId))
			return false;
		return true;
	}
}
