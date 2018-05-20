package br.com.reislavajato.entidade.auditoria;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ailton Luiz
 * 
 **/
@Entity
@Table(name = "financeiro_aud")
public class FinanceiroAuditoria {

	@Id
	@Column(name = "financeiro_aud_id")
	@GeneratedValue
	private Long financeiroAudId;

	@Column(nullable = false)
	private Long codigo;

	@Column(length = 25)
	private String documento;

	@Column(nullable = false, name = "dt_baixa")
	@Temporal(TemporalType.DATE)
	private Date dtBaixa;

	@Column(nullable = false, name = "dt_vecto")
	@Temporal(TemporalType.DATE)
	private Date dtVecto;

	@Column(length = 80)
	private String observacao;

	@Column(length = 30, nullable = false, name = "status")
	private String statusFinanceiro;

	@Column(name = "tipo_documento", length = 30)
	private String tipoDocumento;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_docto")
	private BigDecimal vlrDocto;

	@Column(name = "cliente_codigo", nullable = false)
	private Long clienteCodigo;

	@Column(name = "processo_operacao", nullable = false, length = 80)
	private String processoOperacao;

	@Column(name = "usuario_operacao", nullable = false, length = 80)
	private String usuarioOperacao;

	@Column(nullable = false, name = "dt_operacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtOperacao;

	@Column(nullable = false, length = 30)
	private String tela;

	public Long getFinanceiroAudId() {
		return financeiroAudId;
	}

	public void setFinanceiroAudId(Long financeiroAudId) {
		this.financeiroAudId = financeiroAudId;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatusFinanceiro() {
		return statusFinanceiro;
	}

	public void setStatusFinanceiro(String statusFinanceiro) {
		this.statusFinanceiro = statusFinanceiro;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public BigDecimal getVlrDocto() {
		return vlrDocto;
	}

	public void setVlrDocto(BigDecimal vlrDocto) {
		this.vlrDocto = vlrDocto;
	}

	public Long getClienteCodigo() {
		return clienteCodigo;
	}

	public void setClienteCodigo(Long clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
	}

	public String getProcessoOperacao() {
		return processoOperacao;
	}

	public void setProcessoOperacao(String processoOperacao) {
		this.processoOperacao = processoOperacao;
	}

	public String getUsuarioOperacao() {
		return usuarioOperacao;
	}

	public void setUsuarioOperacao(String usuarioOperacao) {
		this.usuarioOperacao = usuarioOperacao;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public Date getDtOperacao() {
		return dtOperacao;
	}

	public void setDtOperacao(Date dtOperacao) {
		this.dtOperacao = dtOperacao;
	}

}
