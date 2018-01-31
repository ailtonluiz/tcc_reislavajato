package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.reislavajato.enumeradores.EnumUf;

@Entity
public class Municipio extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
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

}
