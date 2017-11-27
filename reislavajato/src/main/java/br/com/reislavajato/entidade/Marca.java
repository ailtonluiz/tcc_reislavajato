
package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Marca extends GenericEntity {

	@Column(nullable = false, length = 20)
	private String nome;

	@Column(nullable = false, length = 20)
	private String abreviada;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbreviada() {
		return abreviada;
	}

	public void setAbreviada(String abreviada) {
		this.abreviada = abreviada;
	}

}
