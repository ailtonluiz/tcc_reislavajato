package br.com.reislavajato.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.reislavajato.enumeradores.EnumCor;
import br.com.reislavajato.enumeradores.EnumMarca;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
@SuppressWarnings("serial")
@Entity
public class Veiculo extends GenericEntity {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Servico> servicos = new HashSet<Servico>();

	@Transient
	private Servico servico = new Servico();

	private String placa;

	@Enumerated(EnumType.STRING)
	private EnumCor cor = EnumCor.BRANCO;

	private Long km;

	@Enumerated(EnumType.STRING)
	private EnumMarca marca = EnumMarca.FIAT;

	private String modelo;

	@Temporal(TemporalType.DATE)
	private Date dataHoraEntrada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaAgendada = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataHoraSaidaReal = new Date();

	// getters and setters
	public void addServico(Servico servico) {
		servicos.add(servico);
	}

	public void removeServico(Servico servico) {
		servicos.remove(servico);
	}

	public List<Servico> getServicosLista() {
		List<Servico> lista = new ArrayList<Servico>(servicos);
		return lista;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

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

	public EnumCor getCor() {
		return cor;
	}

	public void setCor(EnumCor cor) {
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
