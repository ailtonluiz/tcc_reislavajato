package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import br.com.reislavajato.enumeradores.EnumFormaPagamento;
import br.com.reislavajato.enumeradores.EnumStatusServico;

@Entity
@Table(name = "ordemServico")
public class OrdemServico extends GenericEntity {
	private static final long serialVersionUID = -1028738456860340307L;

	//@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordemServico_ID")
	private Long codigo;

	@OneToMany(mappedBy = "ordemServico", orphanRemoval = true)
	private List<Servico> servicos = new ArrayList<>();

	private Long numeroOrdemServico;

	@OneToOne(orphanRemoval = true, fetch = FetchType.EAGER)
	private Cliente cliente = new Cliente();

	@OneToOne(orphanRemoval = true, fetch = FetchType.EAGER)
	private Veiculo veiculo = new Veiculo();

	@Enumerated(EnumType.STRING)
	private EnumStatusServico statusServico = EnumStatusServico.PARADO;

	@Temporal(TemporalType.DATE)
	private Date dataHoraEntrada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaAgendada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaReal = new Date();

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(mappedBy = "ordemServico", orphanRemoval = true)
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@Enumerated(EnumType.STRING)
	private EnumFormaPagamento formaPagamento = EnumFormaPagamento.DINHEIRO;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_total")
	private BigDecimal valorTotal;

	@Column(precision = 10, scale = 2)
	private BigDecimal descontoServico;

	private String observacao;

	// getters and setters

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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

}