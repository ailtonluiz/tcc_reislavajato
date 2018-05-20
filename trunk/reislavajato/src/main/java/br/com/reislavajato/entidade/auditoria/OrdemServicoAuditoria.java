/**
 * 
 */
package br.com.reislavajato.entidade.auditoria;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @19 de mai de 2018 @17:49:42
 */

@Entity(name = "ordem_servico_aud")
public class OrdemServicoAuditoria {

	@Id
	@GeneratedValue
	@Column(name = "ordem_servico_aud_id")
	private Long ordemServicoAudId;

	@Column(name = "os_id", nullable = false)
	private Long ordemServicoId;

	@Column(name = "status_servico", nullable = false)
	private String statusServico;

	@Column(precision = 10, scale = 2, name = "vlr_total")
	private BigDecimal valorTotal;

	@Column(precision = 10, scale = 2, name = "pct_desconto")
	private BigDecimal descontoServico;

	@Column(name = "obs_os")
	private String obsOrdemServico;

	@Column(name = "processo_operacao", nullable = false, length = 80)
	private String processoOperacao;

	@Column(name = "usuario_operacao", nullable = false, length = 80)
	private String usuarioOperacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_operacao")
	private Date dtOperacao;

	@Column(nullable = false, length = 30)
	private String tela;

	public Long getOrdemServicoAudId() {
		return ordemServicoAudId;
	}

	public void setOrdemServicoAudId(Long ordemServicoAudId) {
		this.ordemServicoAudId = ordemServicoAudId;
	}

	public Long getOrdemServicoId() {
		return ordemServicoId;
	}

	public void setOrdemServicoId(Long ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}

	public String getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
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

	public Date getDtOperacao() {
		return dtOperacao;
	}

	public void setDtOperacao(Date dtOperacao) {
		this.dtOperacao = dtOperacao;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

}
