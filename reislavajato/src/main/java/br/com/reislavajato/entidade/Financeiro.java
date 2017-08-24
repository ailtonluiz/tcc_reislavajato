package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Financeiro extends GenericEntity {

	@Column(nullable = false, name = "dt_lacto")
	@Temporal(TemporalType.DATE)
	private Date dtLacto;

	@Column(nullable = false, name = "dt_vecto")
	@Temporal(TemporalType.DATE)
	private Date dtVecto;

	@Column(nullable = false, length = 25)
	private String documento;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_docto")
	private BigDecimal vlrDocto;

	@Column(nullable = false)
	private Character status;

	@Column(nullable = false, length = 2, name = "tipo_docto")
	private String tipoDocto;

	@OneToOne
	@JoinColumn(nullable = true)
	private Fornecedor fornecedor;

	@OneToOne
	@JoinColumn(nullable = true)
	private Cliente cliente;

	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	public Date getDtLacto() {
		return dtLacto;
	}

	public void setDtLacto(Date dtLacto) {
		this.dtLacto = dtLacto;
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public String getTipoDocto() {
		return tipoDocto;
	}

	public void setTipoDocto(String tipoDocto) {
		this.tipoDocto = tipoDocto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
