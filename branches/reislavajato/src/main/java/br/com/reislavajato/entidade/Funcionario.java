package br.com.reislavajato.entidade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.reislavajato.enumeradores.EnumCategoriaCNH;
import br.com.reislavajato.enumeradores.EnumFatorRH;
import br.com.reislavajato.enumeradores.EnumSimNao;
import br.com.reislavajato.enumeradores.EnumTipoSanguineo;

/**
 * @author ailtonluiz
 *
 */
@Entity
@Table(name = "funcionario")
public class Funcionario { // extends GenericEntity {

	@Id
	@Column(name = "funcionario_id")
	@GeneratedValue
	private Long funcionarioId;

	@ManyToMany(mappedBy = "funcionarios")
	private Set<Servico> servicos = new HashSet<Servico>();

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa = new Pessoa();

	@ManyToOne
	private Cargo cargo;

	private String carteiraTrabalho;

	private String tituloEleitor;

	private String zona;

	private String secao;

	private String cnh;

	@Temporal(TemporalType.DATE)
	private Date dataEntradaExercicio;

	@Temporal(TemporalType.DATE)
	private Date dataSaida;

	private EnumSimNao ativo = EnumSimNao.SIM;

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

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

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

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public EnumSimNao getAtivo() {
		return ativo;
	}

	public void setAtivo(EnumSimNao ativo) {
		this.ativo = ativo;
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

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getFuncionarioId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionarioId == null) ? 0 : funcionarioId.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (funcionarioId == null) {
			if (other.funcionarioId != null)
				return false;
		} else if (!funcionarioId.equals(other.funcionarioId))
			return false;
		return true;
	}
}