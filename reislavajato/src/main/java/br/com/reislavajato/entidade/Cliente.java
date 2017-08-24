/**
 * 
 */
package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericEntity {

	@Column(nullable = false, name ="dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;
	
	
}
