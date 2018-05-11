/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @9 de mai de 2018 @15:04:54
 */
@Entity(name = "ordem_servico_movimento")
public class OrdemServicoMovimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_movimento_id")
	private Long ordemServicoMovimentoId;

	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ordem_servico_movimento", joinColumns = @JoinColumn(name = "os_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
	private List<Servico> servicos = new ArrayList<Servico>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Column(name = "vlr_unitario", precision = 10, scale = 2)
	private BigDecimal vlrUnitario;

	@Column(name = "pct_comissao", precision = 10, scale = 2)
	private BigDecimal pctComissao;

	@ManyToOne
	@JoinColumn(name = "os_id")
	private OrdemServico ordemServico;

	public Long getOrdemServicoMovimentoId() {
		return ordemServicoMovimentoId;
	}

	public void setOrdemServicoMovimentoId(Long ordemServicoMovimentoId) {
		this.ordemServicoMovimentoId = ordemServicoMovimentoId;
	}


	public List<Servico> getServicos() {
		if(servicos == null) servicos = new ArrayList<>();
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public BigDecimal getPctComissao() {
		return pctComissao;
	}

	public void setPctComissao(BigDecimal pctComissao) {
		this.pctComissao = pctComissao;
	}

}
