/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Servico extends GenericEntity {

	@Column(length = 80, nullable = false)
	private String descricao;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_servico")
	private BigDecimal vlrServico;

	@Column(precision = 10, scale = 2, name = "perc_comissao")
	private BigDecimal percComissao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getVlrServico() {
		return vlrServico;
	}

	public void setVlrServico(BigDecimal vlrServico) {
		this.vlrServico = vlrServico;
	}

	public BigDecimal getPercComissao() {
		return percComissao;
	}

	public void setPercComissao(BigDecimal percComissao) {
		this.percComissao = percComissao;
	}

}
