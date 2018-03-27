package br.com.reislavajato.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.reislavajato.enumeradores.EnumFormaPagamento;
import br.com.reislavajato.enumeradores.EnumStatusServico;

@Entity
@Table(name = "OrdemServico")
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordemServico_id")
	private Long ordemServicoId;

	private Long numeroOrdemServico;

	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente = new Cliente();

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private Veiculo veiculo = new Veiculo();

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private CheckList checkList = new CheckList();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ordemServico")
	@Cascade(CascadeType.ALL)
	private Set<Servico> servicos = new HashSet<Servico>();

	@Enumerated(EnumType.STRING)
	private EnumStatusServico statusServico = EnumStatusServico.PARADO;

	@Temporal(TemporalType.DATE)
	private Date dataHoraEntrada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaAgendada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaReal = new Date();

	@Enumerated(EnumType.STRING)
	private EnumFormaPagamento formaPagamento = EnumFormaPagamento.CARTAO_CREDITO;

	@Column(precision = 10, scale = 2)
	private BigDecimal valorTotal;

	@Column(precision = 10, scale = 2)
	private BigDecimal descontoServico;

	private String observacao;

	// getters and setters

	public Long getOrdemServicoId() {
		return ordemServicoId;
	}

	public void setOrdemServicoId(Long ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}

	public Long getNumeroOrdemServico() {
		return numeroOrdemServico;
	}

	public void setNumeroOrdemServico(Long numeroOrdemServico) {
		this.numeroOrdemServico = numeroOrdemServico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public CheckList getCheckList() {
		return checkList;
	}

	public void setCheckList(CheckList checkList) {
		this.checkList = checkList;
	}

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public EnumStatusServico getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(EnumStatusServico statusServico) {
		this.statusServico = statusServico;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaidaAgendada() {
		return dataHoraSaidaAgendada;
	}

	public void setDataHoraSaidaAgendada(Date dataHoraSaidaAgendada) {
		this.dataHoraSaidaAgendada = dataHoraSaidaAgendada;
	}

	public Date getDataHoraSaidaReal() {
		return dataHoraSaidaReal;
	}

	public void setDataHoraSaidaReal(Date dataHoraSaidaReal) {
		this.dataHoraSaidaReal = dataHoraSaidaReal;
	}

	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getDescontoServico() {
		return descontoServico;
	}

	public void setDescontoServico(BigDecimal descontoServico) {
		this.descontoServico = descontoServico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getOrdemServicoId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordemServicoId == null) ? 0 : ordemServicoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (ordemServicoId == null) {
			if (other.ordemServicoId != null)
				return false;
		} else if (!ordemServicoId.equals(other.ordemServicoId))
			return false;
		return true;
	}

}