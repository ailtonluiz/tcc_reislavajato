package br.com.reislavajato.entidade;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@Entity
@Table(name = "Servico")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "servico_id")
	@GeneratedValue
	private Long servicoId;// = 0L;

	@ManyToOne
	@JoinColumn(name = "ordemServico_id")
	private OrdemServico ordemServico;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	private Funcionario funcionario;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valorServico;// = new BigDecimal(0.0);

	@Column(precision = 10, scale = 2)
	private BigDecimal percentualComissao;// = new BigDecimal(0.0);

	private String observacao;// = "";
	private String descricao;// = "";

	// getters and setters

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
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