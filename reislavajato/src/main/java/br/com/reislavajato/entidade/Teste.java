/**
 * 
 */
package br.com.reislavajato.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Criado por: ailto
 * @Data: 21 de nov de 2017
 */

@SuppressWarnings("serial")
@Entity
public class Teste extends GenericEntity{
	
	@Column(length = 20, name = "teste_telmo_certim", nullable = false)
	private String nomeTeste;

	public String getNomeTeste() {
		return nomeTeste;
	}

	public void setNomeTeste(String nomeTeste) {
		this.nomeTeste = nomeTeste;
	}
	
	

}
