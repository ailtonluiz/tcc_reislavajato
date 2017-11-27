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

	@Column
	private String km;

	@Column(precision = 10, scale = 2, nullable = false, name = "vlr_total")
	private BigDecimal vlrTotal;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Veiculo veiculo;

	@Column
	private Boolean alarme;

	@Column
	private Boolean vidro;

	@Column
	private Boolean chave;

	@Column
	private Boolean macaco;

	@Column
	private Boolean triangulo;

	@Column
	private Boolean estepe;

	@Column
	private Boolean extintor;

	@Column
	private Boolean tapetes;

	@Column(length = 255)
	private String observacao;

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

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Boolean getAlarme() {
		return alarme;
	}

	public void setAlarme(Boolean alarme) {
		this.alarme = alarme;
	}

	public Boolean getVidro() {
		return vidro;
	}

	public void setVidro(Boolean vidro) {
		this.vidro = vidro;
	}

	public Boolean getChave() {
		return chave;
	}

	public void setChave(Boolean chave) {
		this.chave = chave;
	}

	public Boolean getMacaco() {
		return macaco;
	}

	public void setMacaco(Boolean macaco) {
		this.macaco = macaco;
	}

	public Boolean getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(Boolean triangulo) {
		this.triangulo = triangulo;
	}

	public Boolean getEstepe() {
		return estepe;
	}

	public void setEstepe(Boolean estepe) {
		this.estepe = estepe;
	}

	public Boolean getExtintor() {
		return extintor;
	}

	public void setExtintor(Boolean extintor) {
		this.extintor = extintor;
	}

	public Boolean getTapetes() {
		return tapetes;
	}

	public void setTapetes(Boolean tapetes) {
		this.tapetes = tapetes;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
