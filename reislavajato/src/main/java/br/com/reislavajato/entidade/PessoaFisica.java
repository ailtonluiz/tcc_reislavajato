package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

import br.com.reislavajato.enumeradores.EnumEscolaridade;
import br.com.reislavajato.enumeradores.EnumEstadoCivil;
import br.com.reislavajato.enumeradores.EnumOrgaoRG;
import br.com.reislavajato.enumeradores.EnumSexo;
import br.com.reislavajato.enumeradores.EnumUf;

@Entity(name = "pessoa_fisica")
public class PessoaFisica { 
	
	@Id
	@Column(name = "pessoa_fisica_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaFisicaId;
	
	@CPF
	private String cpf;

	@Column(length = 25, nullable = true)
	private String rg;

	@Column(length = 100, nullable = false)
	private String nome = "";

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Date dataNascimento;
	
	@Column(name ="nome_pai")
	private String nomeMae;
	@Column(name = "nome_mae")
	private String nomePai;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_exp_rg")
	private Date dataExpedicaoRG;

	@Enumerated(EnumType.STRING)
	private EnumSexo sexo = EnumSexo.MASCULINO;

	@Enumerated(EnumType.STRING)
	@Column(name ="uf_exp_rg")
	private EnumUf ufExpedicaoRg = EnumUf.GO;

	@Enumerated(EnumType.STRING)
	@Column(name ="orgao_rg")
	private EnumOrgaoRG orgaoRG = EnumOrgaoRG.SSP;

	@Enumerated(EnumType.STRING)
	@Column(name ="estado_civil")
	private EnumEstadoCivil estadoCivil = EnumEstadoCivil.CASADO;

	@Enumerated(EnumType.STRING)
	private EnumEscolaridade escolaridade = EnumEscolaridade.SEGUNDO_GRAU;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataExpedicaoRG() {
		return dataExpedicaoRG;
	}

	public void setDataExpedicaoRG(Date dataExpedicaoRG) {
		this.dataExpedicaoRG = dataExpedicaoRG;
	}

	public EnumUf getUfExpedicaoRg() {
		return ufExpedicaoRg;
	}

	public void setUfExpedicaoRg(EnumUf ufExpedicaoRg) {
		this.ufExpedicaoRg = ufExpedicaoRg;
	}

	public EnumOrgaoRG getOrgaoRG() {
		return orgaoRG;
	}

	public void setOrgaoRG(EnumOrgaoRG orgaoRG) {
		this.orgaoRG = orgaoRG;
	}

	public EnumEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public EnumEscolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EnumEscolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	/**
	 * @return the pessoaFisicaId
	 */
	public Long getPessoaFisicaId() {
		return pessoaFisicaId;
	}

	/**
	 * @param pessoaFisicaId the pessoaFisicaId to set
	 */
	public void setPessoaFisicaId(Long pessoaFisicaId) {
		this.pessoaFisicaId = pessoaFisicaId;
	}

	@Override
	public String toString() {
		return String.format("%scodigo=%d]", getClass().getSimpleName(), getPessoaFisicaId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoaFisicaId == null) ? 0 : pessoaFisicaId.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (pessoaFisicaId == null) {
			if (other.pessoaFisicaId != null)
				return false;
		} else if (!pessoaFisicaId.equals(other.pessoaFisicaId))
			return false;
		return true;
	}
}
