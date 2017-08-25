/**
 * 
 */
package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Movimento extends GenericEntity {

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horario;

	@Column(nullable = false)
	private Long numeroOrdem;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_total")
	private BigDecimal vlrTotal;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Veiculo veiculo;

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Long getNumeroOrdem() {
		return numeroOrdem;
	}

	public void setNumeroOrdem(Long numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
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

}
