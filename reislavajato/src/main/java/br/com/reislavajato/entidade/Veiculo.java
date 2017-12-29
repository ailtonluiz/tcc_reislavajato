package br.com.reislavajato.entidade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import br.com.reislavajato.enumeradores.EnumMarca;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Veiculo extends GenericEntity {

	@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Servico> servicos = new HashSet<Servico>();

	private String placa;

	private String cor;

	private Long km;

	@Enumerated(EnumType.STRING)
	private EnumMarca marca = EnumMarca.FIAT;

	private String modelo;

	@Temporal(TemporalType.DATE)
	private Date dataHoraEntrada;

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaAgendada;

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaReal;

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
	}

	public EnumMarca getMarca() {
		return marca;
	}

	public void setMarca(EnumMarca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaidaAgendada() {
		return dataHoraSaidaAgendada;
	}

	public void setDataHoraSaidaAgendada(Date dataHoraSaidaAgendada) {
		this.dataHoraSaidaAgendada = dataHoraSaidaAgendada;
	}

	public Date getDataHoraSaidaReal() {
		return dataHoraSaidaReal;
	}

	public void setDataHoraSaidaReal(Date dataHoraSaidaReal) {
		this.dataHoraSaidaReal = dataHoraSaidaReal;
	}

}
