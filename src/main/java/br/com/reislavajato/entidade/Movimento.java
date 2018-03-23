/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.reislavajato.enumeradores.EnumFormaPagamento;
import br.com.reislavajato.enumeradores.EnumStatusServico;

/**
 * @Criado por: ailtonluiz
 * @Data: 20 de mar de 2018
 */

@SuppressWarnings("serial")
@Entity
public class Movimento extends GenericEntity {

	private Boolean estepe;

	private Boolean alarme;

	private Boolean ferramentas;

	private Boolean triangulo;

	private Boolean extintor;

	private Boolean som;

	private Boolean tapetes;

	private Boolean arranhoes;

	private Long km;

	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente = new Cliente();

	@OneToOne(fetch = FetchType.EAGER)
	private Veiculo veiculo = new Veiculo();

	@Enumerated(EnumType.STRING)
	private EnumStatusServico statusServico = EnumStatusServico.PARADO;

	@Temporal(TemporalType.DATE)
	private Date dataHoraEntrada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaAgendada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaReal = new Date();

	@Enumerated(EnumType.STRING)
	private EnumFormaPagamento formaPagamento = EnumFormaPagamento.DINHEIRO;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_total")
	private BigDecimal valorTotal;

	public Boolean getEstepe() {
		return estepe;
	}

	public void setEstepe(Boolean estepe) {
		this.estepe = estepe;
	}

	public Boolean getAlarme() {
		return alarme;
	}

	public void setAlarme(Boolean alarme) {
		this.alarme = alarme;
	}

	public Boolean getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(Boolean ferramentas) {
		this.ferramentas = ferramentas;
	}

	public Boolean getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(Boolean triangulo) {
		this.triangulo = triangulo;
	}

	public Boolean getExtintor() {
		return extintor;
	}

	public void setExtintor(Boolean extintor) {
		this.extintor = extintor;
	}

	public Boolean getSom() {
		return som;
	}

	public void setSom(Boolean som) {
		this.som = som;
	}

	public Boolean getTapetes() {
		return tapetes;
	}

	public void setTapetes(Boolean tapetes) {
		this.tapetes = tapetes;
	}

	public Boolean getArranhoes() {
		return arranhoes;
	}

	public void setArranhoes(Boolean arranhoes) {
		this.arranhoes = arranhoes;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
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

}
