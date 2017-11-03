package br.com.reislavajato.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import br.com.reislavajato.enumeradores.EnumSimNao;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;

@SuppressWarnings("serial")
@Entity
public class Pessoa extends GenericEntity {

	private Boolean cadastroAtivo = true;
	
	@Enumerated(EnumType.STRING)
	private EnumSimNao permitirEnvioEmail = EnumSimNao.SIM;
	
	@Column(length = 70)
	private String email;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private PessoaFisica pessoaFisica = new PessoaFisica();

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();

	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoPessoa = EnumTipoPessoa.PF;

	@Transient
	private Endereco endereco = new Endereco();

	@Transient
	private Telefone telefone = new Telefone();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id")
	private Set<Endereco> enderecos = new HashSet<Endereco>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id")
	private Set<Telefone> telefones = new HashSet<Telefone>();

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

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecosLista() {
		List<Endereco> lista = new ArrayList<Endereco>(enderecos);
		return lista;
	}

	public List<Telefone> getTelefonesLista() {
		List<Telefone> lista = new ArrayList<Telefone>(telefones);
		return lista;
	}

	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}

	public void addTelefone(Telefone telefone) {
		telefones.add(telefone);
	}

	public void removeEndereco(Endereco endereco) {
		enderecos.remove(endereco);
	}

	public void removeTelefone(Telefone telefone) {
		telefones.remove(telefone);
	}

}
