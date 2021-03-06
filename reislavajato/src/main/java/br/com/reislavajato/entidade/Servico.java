package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@Entity
public class Servico {

	@Id
	@Column(name = "servico_id")
	@GeneratedValue
	private Long servicoId;

	@Column(name = "vlr_servico", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorServico;

	@Column(name = "pct_comissao", precision = 10, scale = 2)
	private BigDecimal percentualComissao;

	private String observacao;
	private String descricao;

	// getters and setters

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public BigDecimal getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(BigDecimal percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getServicoId());
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Servico))
			return false;

		Servico servico = (Servico) obj;

		return (servico.getDescricao() != null && servico.getDescricao().equals(descricao));
	}

	public int hashCode() {
		int hash = 1;
		if (descricao != null)
			hash = hash * 31 + descricao.hashCode();
		return hash;
	}

}