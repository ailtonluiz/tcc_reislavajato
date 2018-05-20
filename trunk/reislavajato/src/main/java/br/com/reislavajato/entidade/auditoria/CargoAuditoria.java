/**
 * 
 */
package br.com.reislavajato.entidade.auditoria;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @19 de mai de 2018 @18:24:13
 */
@Entity
@Table(name = "cargo_aud")
public class CargoAuditoria {

	@Id
	@GeneratedValue
	@Column(name = "cargo_aud_id")
	private Long cargoAudId;

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

	@Column(nullable = false, name = "desc_cargo")
	private String nomeCargo;

	public Long getCargoAudId() {
		return cargoAudId;
	}

	public void setCargoAudId(Long cargoAudId) {
		this.cargoAudId = cargoAudId;
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

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	@Override
	public String toString() {
		return String.format("CargoAuditoria [cargoAudId=%s]", cargoAudId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargoAudId == null) ? 0 : cargoAudId.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dtOperacao == null) ? 0 : dtOperacao.hashCode());
		result = prime * result + ((nomeCargo == null) ? 0 : nomeCargo.hashCode());
		result = prime * result + ((processoOperacao == null) ? 0 : processoOperacao.hashCode());
		result = prime * result + ((tela == null) ? 0 : tela.hashCode());
		result = prime * result + ((usuarioOperacao == null) ? 0 : usuarioOperacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoAuditoria other = (CargoAuditoria) obj;
		if (cargoAudId == null) {
			if (other.cargoAudId != null)
				return false;
		} else if (!cargoAudId.equals(other.cargoAudId))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dtOperacao == null) {
			if (other.dtOperacao != null)
				return false;
		} else if (!dtOperacao.equals(other.dtOperacao))
			return false;
		if (nomeCargo == null) {
			if (other.nomeCargo != null)
				return false;
		} else if (!nomeCargo.equals(other.nomeCargo))
			return false;
		if (processoOperacao == null) {
			if (other.processoOperacao != null)
				return false;
		} else if (!processoOperacao.equals(other.processoOperacao))
			return false;
		if (tela == null) {
			if (other.tela != null)
				return false;
		} else if (!tela.equals(other.tela))
			return false;
		if (usuarioOperacao == null) {
			if (other.usuarioOperacao != null)
				return false;
		} else if (!usuarioOperacao.equals(other.usuarioOperacao))
			return false;
		return true;
	}

	

}
