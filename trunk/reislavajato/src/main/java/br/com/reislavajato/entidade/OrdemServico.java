package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.reislavajato.enumeradores.EnumFormaPagamento;
import br.com.reislavajato.enumeradores.EnumSimNao;
import br.com.reislavajato.enumeradores.EnumStatusServico;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "os_id")
	private Long ordemServicoId;

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "num_os_servico")
	private Long numeroOrdemServico;

	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente = new Cliente();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Veiculo veiculo = new Veiculo();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CheckList checkList = new CheckList();

	@Enumerated(EnumType.STRING)
	@Column(name = "status_servico")
	private EnumStatusServico statusServico = EnumStatusServico.EXECUCAO;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_hr_entrada")
	private Date dataHoraEntrada = new Date();

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_hr_saida_agendada")
	private Date dataHoraSaidaAgendada = new Date();

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_hr_saida_real")
	private Date dataHoraSaidaReal = new Date();

	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pagto")
	private EnumFormaPagamento formaPagamento = EnumFormaPagamento.DINHEIRO;

	@Column(precision = 10, scale = 2, name = "vlr_total")
	private BigDecimal valorTotal;

	@Column(precision = 10, scale = 2, name = "pct_desconto")
	private BigDecimal descontoServico;
	
	@Column(name = "obs_os")
	private String obsOrdemServico;

	@Column(name = "obs_check_list")
	private String obsCheckList;

	private EnumSimNao estepe = EnumSimNao.SIM;

	private EnumSimNao alarme = EnumSimNao.SIM;

	private EnumSimNao ferramentas = EnumSimNao.SIM;

	private EnumSimNao triangulo = EnumSimNao.SIM;

	private EnumSimNao extintor = EnumSimNao.SIM;

	private EnumSimNao som = EnumSimNao.SIM;

	private EnumSimNao tapetes = EnumSimNao.SIM;

	private EnumSimNao arranhoes = EnumSimNao.SIM;

	private Long km;
	
	

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


	public String getObsOrdemServico() {
		return obsOrdemServico;
	}

	public void setObsOrdemServico(String obsOrdemServico) {
		this.obsOrdemServico = obsOrdemServico;
	}

	public String getObsCheckList() {
		return obsCheckList;
	}

	public void setObsCheckList(String obsCheckList) {
		this.obsCheckList = obsCheckList;
	}

	public EnumSimNao getEstepe() {
		return estepe;
	}

	public void setEstepe(EnumSimNao estepe) {
		this.estepe = estepe;
	}

	public EnumSimNao getAlarme() {
		return alarme;
	}

	public void setAlarme(EnumSimNao alarme) {
		this.alarme = alarme;
	}

	public EnumSimNao getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(EnumSimNao ferramentas) {
		this.ferramentas = ferramentas;
	}

	public EnumSimNao getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(EnumSimNao triangulo) {
		this.triangulo = triangulo;
	}

	public EnumSimNao getExtintor() {
		return extintor;
	}

	public void setExtintor(EnumSimNao extintor) {
		this.extintor = extintor;
	}

	public EnumSimNao getSom() {
		return som;
	}

	public void setSom(EnumSimNao som) {
		this.som = som;
	}

	public EnumSimNao getTapetes() {
		return tapetes;
	}

	public void setTapetes(EnumSimNao tapetes) {
		this.tapetes = tapetes;
	}

	public EnumSimNao getArranhoes() {
		return arranhoes;
	}

	public void setArranhoes(EnumSimNao arranhoes) {
		this.arranhoes = arranhoes;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
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