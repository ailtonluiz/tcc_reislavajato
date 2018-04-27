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

import br.com.reislavajato.enumeradores.EnumStatusFinanceiro;
import br.com.reislavajato.enumeradores.EnumTipoFinanceiro;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Financeiro extends GenericEntity {

	@Column(name = "tipo_documento")
	@Enumerated(EnumType.STRING)
	private EnumTipoFinanceiro tipoFinanceiro = EnumTipoFinanceiro.CONTA_PAGAR;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EnumStatusFinanceiro statusFinanceiro = EnumStatusFinanceiro.ABERTO;

	@Column(nullable = true, name = "dt_baixa")
	@Temporal(TemporalType.DATE)
	private Date dtBaixa = new Date();

	@Column(nullable = false, name = "dt_vecto")
	@Temporal(TemporalType.DATE)
	private Date dtVecto;

	@Column(nullable = false, length = 25)
	private String documento;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_docto")
	private BigDecimal vlrDocto;

	@Column(length = 80)
	private String observacao;

	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente = new Cliente();

	public EnumTipoFinanceiro getTipoFinanceiro() {
		return tipoFinanceiro;
	}

	public void setTipoFinanceiro(EnumTipoFinanceiro tipoFinanceiro) {
		this.tipoFinanceiro = tipoFinanceiro;
	}

	public EnumStatusFinanceiro getStatusFinanceiro() {
		return statusFinanceiro;
	}

	public void setStatusFinanceiro(EnumStatusFinanceiro statusFinanceiro) {
		this.statusFinanceiro = statusFinanceiro;
	}

	public Date getDtBaixa() {
		return dtBaixa;
	}

	public void setDtBaixa(Date dtBaixa) {
		this.dtBaixa = dtBaixa;
	}

	public Date getDtVecto() {
		return dtVecto;
	}

	public void setDtVecto(Date dtVecto) {
		this.dtVecto = dtVecto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public BigDecimal getVlrDocto() {
		return vlrDocto;
	}

	public void setVlrDocto(BigDecimal vlrDocto) {
		this.vlrDocto = vlrDocto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
