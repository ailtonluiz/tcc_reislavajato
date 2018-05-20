/**
 * 
 */
package br.com.reislavajato.entidade.auditoria;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @19 de mai de 2018 @18:30:55
 */
@Entity(name = "cliente_aud")
public class ClienteAuditoria {

	@Id
	@GeneratedValue
	@Column(name = "cliente_aud_id")
	private Long clienteAudId;

	@Column(nullable = false)
	private Long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_operacao")
	private Date dtOperacao;

	@Column(name = "processo_operacao", nullable = false, length = 80)
	private String processoOperacao;

	@Column(name = "usuario_operacao", nullable = false, length = 80)
	private String usuarioOperacao;

	@Column(nullable = false, length = 30)
	private String tela;

	@Column(name = "nome_cliente")
	private String nomeCliente;

	private String telefone;

	public Long getClienteAudId() {
		return clienteAudId;
	}

	public void setClienteAudId(Long clienteAudId) {
		this.clienteAudId = clienteAudId;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
