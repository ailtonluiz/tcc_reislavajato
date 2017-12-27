package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import br.com.reislavajato.enumeradores.EnumCategoriaCNH;
import br.com.reislavajato.enumeradores.EnumFatorRH;
import br.com.reislavajato.enumeradores.EnumPerfil;
import br.com.reislavajato.enumeradores.EnumTipoSanguineo;

/**
 * @author ailtonluiz
 *
 */
@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericEntity {

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Pessoa pessoa = new Pessoa();

	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Cargo cargo;

	private String carteiraTrabalho;

	private String tituloEleitor;

	private String zona;

	private String secao;

	private String cnh;

	private Calendar dataEntradaExercicio;

	@Enumerated(EnumType.STRING)
	private EnumCategoriaCNH categoriaCNH = EnumCategoriaCNH.A;

	@Enumerated(EnumType.STRING)
	private EnumTipoSanguineo tipoSanguineo = EnumTipoSanguineo.O;

	@Enumerated(EnumType.STRING)
	private EnumFatorRH fatorRH = EnumFatorRH.POSITIVO;

	@Column(precision = 10, scale = 2)
	private BigDecimal comissao;

	@Enumerated(EnumType.STRING)
	private EnumPerfil perfil = EnumPerfil.LAVADOR;

	// getters and setters

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public EnumCategoriaCNH getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(EnumCategoriaCNH categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public EnumTipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(EnumTipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public EnumFatorRH getFatorRH() {
		return fatorRH;
	}

	public void setFatorRH(EnumFatorRH fatorRH) {
		this.fatorRH = fatorRH;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public EnumPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(EnumPerfil perfil) {
		this.perfil = perfil;
	}

	public Calendar getDataEntradaExercicio() {
		return dataEntradaExercicio;
	}

	public void setDataEntradaExercicio(Calendar dataEntradaExercicio) {
		this.dataEntradaExercicio = dataEntradaExercicio;
	}

}
