/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Endereco;
import br.com.reislavajato.entidade.Fornecedor;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.entidade.PessoaFisica;
import br.com.reislavajato.entidade.PessoaJuridica;
import br.com.reislavajato.entidade.Telefone;
import br.com.reislavajato.enumeradores.EnumPerfil;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FornecedorNeg;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.util.CepWs;
import br.com.reislavajato.util.Numero;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 29 de abr de 2018
 */
@Controller("FornecedorControle")
public class FornecedorControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = -7622599240385845530L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
	private Endereco endereco;
	private Telefone telefone;

	private String cpfConsulta;
	private String nomeConsulta;
	private String cnpjConsulta;
	private String nomeFantasiaConsulta;


	public FornecedorControle() {
		this.novo();
	}

	@Override
	@PostConstruct
	public String novo() {
		fornecedor = new Fornecedor();
		fornecedores = new ArrayList<Fornecedor>();
		pessoaFisica = new PessoaFisica();
		pessoaJuridica = new PessoaJuridica();
		endereco = new Endereco();
		telefone = new Telefone();

		cpfConsulta = "";
		nomeConsulta = "";
		cnpjConsulta = "";
		nomeFantasiaConsulta = "";
		return "sucesso";
	}

	public void listarFornecedores() throws DadosInvalidosException {
		try {
			if (!ReisLavajatoUtil.ehVazio(cpfConsulta) || !ReisLavajatoUtil.ehVazio(nomeConsulta)) {
				fornecedores = context.getBean(FornecedorNeg.class).listarPorCpfOuNome(cpfConsulta, nomeConsulta);
			} else if (!ReisLavajatoUtil.ehVazio(cnpjConsulta) || !ReisLavajatoUtil.ehVazio(nomeFantasiaConsulta)) {
				fornecedores = context.getBean(FornecedorNeg.class).listarPorCnpjOuNomeFantasia(cnpjConsulta,
						nomeFantasiaConsulta);
			}
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	private void setarAntesPersistir(Fornecedor fornecedor) throws DadosInvalidosException {
		if (fornecedor.getPessoa().getTipoPessoa().equals(EnumTipoPessoa.PJ)) {
			fornecedor.getPessoa().setPessoaJuridica(null);
		} else {
			fornecedor.getPessoa().setPessoaFisica(null);
		}
		fornecedor.getPessoa().setPerfil(EnumPerfil.FORNECEDOR);
	}

	public void salvar() throws DadosInvalidosException {
		try {
			this.setarAntesPersistir(fornecedor);
			context.getBean(FornecedorNeg.class).alterar(fornecedor);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("registroSelecionado");
			context.getBean(FornecedorNeg.class).excluir(fornecedor);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("registroSelecionado");
			if (fornecedor.getPessoa().getEndereco().getMunicipio() == null) {
				fornecedor.getPessoa().getEndereco().setMunicipio(new Municipio());
			}

		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			fornecedor.getPessoa().setEndereco(
					CepWs.getEnderecoPorCep(Numero.removerFormatoCEP(fornecedor.getPessoa().getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {
		if (fornecedor.getPessoa().getEndereco().getMunicipio().getCodigo() == null
				|| fornecedor.getPessoa().getEndereco().getMunicipio().getCodigo() == 0L) {
			return context.getBean(MunicipioNeg.class)
					.listarPorUf(fornecedor.getPessoa().getEndereco().getMunicipio().getUf());
		} else {
			return context.getBean(MunicipioNeg.class)
					.listarPorNome(fornecedor.getPessoa().getEndereco().getMunicipio().getNome());
		}
	}

	// getters and setters

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String getCpfConsulta() {
		return cpfConsulta;
	}

	public void setCpfConsulta(String cpfConsulta) {
		this.cpfConsulta = cpfConsulta;
	}

	public String getNomeConsulta() {
		return nomeConsulta;
	}

	public void setNomeConsulta(String nomeConsulta) {
		this.nomeConsulta = nomeConsulta;
	}

	public String getCnpjConsulta() {
		return cnpjConsulta;
	}

	public void setCnpjConsulta(String cnpjConsulta) {
		this.cnpjConsulta = cnpjConsulta;
	}

	public String getNomeFantasiaConsulta() {
		return nomeFantasiaConsulta;
	}

	public void setNomeFantasiaConsulta(String nomeFantasiaConsulta) {
		this.nomeFantasiaConsulta = nomeFantasiaConsulta;
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



}
