package br.com.reislavajato.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author ailtonluiz
 *
 */
@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericEntity {

	@Column(length = 25, name = "carteira_trabalho")
	private String carteiraTrabalho;

	@Column(length = 8, name = "titulo_eleitor")
	private String tituloEleitor;

	@Column(length = 5)
	private String zona;

	@Column(length = 5)
	private String secao;

	@Column(length = 15)
	private String cnh;

	@Column(length = 2)
	private String categoria;

	@Column(length = 4, name = "tipo_sanguineo")
	private String tipoSanguineo;

	@Column(precision = 10, scale = 2)
	private BigDecimal salario;

	@Column(precision = 10, scale = 2)
	private BigDecimal comissao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cargo cargo;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
