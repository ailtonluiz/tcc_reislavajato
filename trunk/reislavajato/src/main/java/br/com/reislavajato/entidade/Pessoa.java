package br.com.reislavajato.entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.reislavajato.enumeradores.EnumPerfil;
import br.com.reislavajato.enumeradores.EnumSimNao;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;

@Entity
public class Pessoa extends GenericEntity {
	private static final long serialVersionUID = 1L;

	private String observacao;

	private Boolean cadastroAtivo = true;

	@Enumerated(EnumType.STRING)
	private EnumSimNao permitirEnvioEmail = EnumSimNao.SIM;

	@Enumerated(EnumType.STRING)
	private EnumSimNao usuarioSistema = EnumSimNao.NAO;

	@Enumerated(EnumType.STRING)
	private EnumPerfil perfil = EnumPerfil.LAVADOR;

	@Column(length = 70)
	private String email;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro = new Date();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PessoaFisica pessoaFisica = new PessoaFisica();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();

	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoPessoa = EnumTipoPessoa.PF;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco endereco = new Endereco();

	@OneToOne(cascade = CascadeType.ALL)
	private Telefone telefone = new Telefone();

	public Boolean getCadastroAtivo() {
		return cadastroAtivo;
	}

	public void setCadastroAtivo(Boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
	}

	public EnumSimNao getPermitirEnvioEmail() {
		return permitirEnvioEmail;
	}

	public void setPermitirEnvioEmail(EnumSimNao permitirEnvioEmail) {
		this.permitirEnvioEmail = permitirEnvioEmail;
	}

	public EnumSimNao getUsuarioSistema() {
		return usuarioSistema;
	}

	public void setUsuarioSistema(EnumSimNao usuarioSistema) {
		this.usuarioSistema = usuarioSistema;
	}

	public EnumPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(EnumPerfil perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
