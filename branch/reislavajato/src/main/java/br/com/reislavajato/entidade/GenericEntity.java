package br.com.reislavajato.entidade;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.reislavajato.enumeradores.EnumTela;

@SuppressWarnings("serial")
@MappedSuperclass
public class GenericEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private  EnumTela tela = EnumTela.INCLUIR;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getCodigo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		GenericEntity other = (GenericEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public EnumTela getTela() {
		return tela;
	}

	public void setTela(EnumTela tela) {
		this.tela = tela;
	}

}
