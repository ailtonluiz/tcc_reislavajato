/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @21 de mai de 2018 @13:26:44
 */
@Entity
@Table(name = "comissao")
public class Comissao {

	@Id
	@GeneratedValue
	@Column(name = "comissao_id")
	private Long comissaoId;

	@Column(name = "os_id")
	private Long osId;

	@Column(name = "funcionario_id")
	private Long funcionarioId;

	@Column(name = "cliente_id")
	private Long clienteId;

	@Column(name = "vlr_comissao", precision = 10, scale = 2)
	private BigDecimal vlrComissao;

	public Long getComissaoId() {
		return comissaoId;
	}

	public void setComissaoId(Long comissaoId) {
		this.comissaoId = comissaoId;
	}

	public Long getOsId() {
		return osId;
	}

	public void setOsId(Long osId) {
		this.osId = osId;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public BigDecimal getVlrComissao() {
		return vlrComissao;
	}

	public void setVlrComissao(BigDecimal vlrComissao) {
		this.vlrComissao = vlrComissao;
	}

}
