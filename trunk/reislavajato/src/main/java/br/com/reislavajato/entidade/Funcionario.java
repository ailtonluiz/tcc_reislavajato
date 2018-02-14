package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.reislavajato.enumeradores.EnumCategoriaCNH;
import br.com.reislavajato.enumeradores.EnumFatorRH;
import br.com.reislavajato.enumeradores.EnumTipoSanguineo;

/**
 * @author ailtonluiz
 *
 */
@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericEntity {

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa = new Pessoa();

	@ManyToOne(cascade = CascadeType.ALL)
	private Cargo cargo;

	private String carteiraTrabalho;

	private String tituloEleitor;

	private String zona;

	private String secao;

	private String cnh;

	private Date dataEntradaExercicio;

	@Column(length = 150)
	private String observacao;

	@Column(precision = 10, scale = 2)
	private BigDecimal salario;

	@Enumerated(EnumType.STRING)
	private EnumCategoriaCNH categoriaCNH = EnumCategoriaCNH.A;

	@Enumerated(EnumType.STRING)
	private EnumTipoSanguineo tipoSanguineo = EnumTipoSanguineo.O;

	@Enumerated(EnumType.STRING)
	private EnumFatorRH fatorRH = EnumFatorRH.POSITIVO;

	@Column(length = 60)
	private String senha;

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

	public Date getDataEntradaExercicio() {
		return dataEntradaExercicio;
	}

	public void setDataEntradaExercicio(Date dataEntradaExercicio) {
		this.dataEntradaExercicio = dataEntradaExercicio;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
