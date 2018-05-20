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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @19 de mai de 2018 @17:15:27
 */
@Entity
@Table(name = "servico_aud")
public class ServicoAuditoria {

	@Id
	@Column(name = "servico_aud_id")
	@GeneratedValue
	private Long servicoAudId;

	@Column(nullable = false)
	private String descricao;

	@Column(name = "servico_id", nullable = false)
	private Long servicoId;

	@Column(name = "pct_comissao", precision = 10, scale = 2)
	private BigDecimal percentualComissao;

	@Column(name = "vlr_servico", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorServico;

	private String observacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_operacao")
	private Date dtOperacao;

	@Column(name = "processo_operacao", nullable = false, length = 80)
	private String processoOperacao;

	@Column(name = "usuario_operacao", nullable = false, length = 80)
	private String usuarioOperacao;

	@Column(nullable = false, length = 30)
	private String tela;

	public Long getServicoAudId() {
		return servicoAudId;
	}

	public void setServicoAudId(Long servicoAudId) {
		this.servicoAudId = servicoAudId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}

	public BigDecimal getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(BigDecimal percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDtOperacao() {
		return dtOperacao;
	}

	public void setDtOperacao(Date dtOperacao) {
		this.dtOperacao = dtOperacao;
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

}
