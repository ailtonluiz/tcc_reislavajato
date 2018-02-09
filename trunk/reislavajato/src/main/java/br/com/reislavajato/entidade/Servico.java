package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@Entity
@Table(name = "servico")
public class Servico extends GenericEntity {
	private static final long serialVersionUID = 7671468455131367941L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servico_ID")
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "ordemServico_ID")
	private OrdemServico ordemServico;
	
	//getters and setters
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	private String descricao;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valorServico;

	@Column(precision = 10, scale = 2)
	private BigDecimal percentualComissao;

	private String observacao;

	// getters and setters

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

}