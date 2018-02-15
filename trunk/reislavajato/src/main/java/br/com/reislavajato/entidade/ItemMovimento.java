/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity(name = "item_movimento")
public class ItemMovimento extends GenericEntity {

	@Column(nullable = false)
	private Short quantidade;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_parcial")
	private BigDecimal vlrParcial;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_comissao")
	private BigDecimal vlrComissao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Servico servico;

	@ManyToOne
	@JoinColumn(nullable = false)
	private OrdemServico ordemServico;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getVlrParcial() {
		return vlrParcial;
	}

	public void setVlrParcial(BigDecimal vlrParcial) {
		this.vlrParcial = vlrParcial;
	}

	public BigDecimal getVlrComissao() {
		return vlrComissao;
	}

	public void setVlrComissao(BigDecimal vlrComissao) {
		this.vlrComissao = vlrComissao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
