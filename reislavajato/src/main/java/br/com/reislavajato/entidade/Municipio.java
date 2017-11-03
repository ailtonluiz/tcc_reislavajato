package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.reislavajato.enumeradores.EnumUf;

@SuppressWarnings("serial")
@Entity
public class Municipio extends GenericEntity {

	@Column(nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	private EnumUf uf = EnumUf.GO;

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

}
