
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.entidade.Endereco;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.entidade.PessoaJuridica;
import br.com.reislavajato.entidade.Telefone;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.EmpresaNeg;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.util.CepWs;
import br.com.reislavajato.util.JavaMail;
import br.com.reislavajato.util.Numero;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de fevereiro de 2018
 */


@ViewScoped
@Controller
public class EmpresaControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = -7622599240385845530L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private EmpresaNeg empresaNeg = context.getBean(EmpresaNeg.class);
	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Empresa empresa;
	private List<Empresa> empresas;
	private PessoaJuridica pessoaJuridica;
	private Endereco endereco;
	private Telefone telefone;

	private String cnpjConsulta;
	private String razaoConsulta;
	private String nomeFantasiaConsulta;

	public EmpresaControle() {
		this.novo();
	}

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			empresas = empresaNeg.listar();

		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	@Override
	public String novo() {
		empresa = new Empresa();
		empresas = new ArrayList<Empresa>();
		pessoaJuridica = new PessoaJuridica();
		endereco = new Endereco();
		telefone = new Telefone();

		// cnpjConsulta = "";
		// razaoConsulta = "";
		// nomeFantasiaConsulta = "";
		return "sucesso";
	}

	public void listarEmpresas() throws DadosInvalidosException {
		try {
			empresas = empresaNeg.listarPorCnpjOuNomeFantasiaOuRazaoSocial(Numero.removerFormatoCNPJ(cnpjConsulta),
					nomeFantasiaConsulta, razaoConsulta);

		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			empresaNeg.alterar(empresa);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("registroSelecionado");
			empresaNeg.excluir(empresa);
			addMensagemInfo(msgExcluidoSucesso);

		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("registroSelecionado");
			if (empresa.getEndereco().getMunicipio() == null) {
				empresa.getEndereco().setMunicipio(new Municipio());

			}
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			empresa.setEndereco(CepWs.getEnderecoPorCep(Numero.removerFormatoCEP(empresa.getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {
		if (empresa.getEndereco().getMunicipio().getCodigo() == null
				|| empresa.getEndereco().getMunicipio().getCodigo() == 0L) {
			return municipioNeg.listarPorUf(empresa.getEndereco().getMunicipio().getUf());
		} else {
			return municipioNeg.listarPorNome(empresa.getEndereco().getMunicipio().getNome());
		}
	}

	public void testarEnvioEmail() {
		JavaMail mail = new JavaMail();

		try {
			mail.javaMail("nathyalmeidagyn@gmail.com", "rubendelmondes@bol.com.br", "Lavajato Reis",
					"Seu carro está pronto!");

		} catch (Exception e) {
			addMensagemErroFatal(e);
			e.printStackTrace();
		}
	}

	// getters and setters

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the empresas
	 */
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	/**
	 * @param empresas
	 *            the empresas to set
	 */
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	/**
	 * @return the pessoaJuridica
	 */
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	/**
	 * @param pessoaJuridica
	 *            the pessoaJuridica to set
	 */
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public Telefone getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the cnpjConsulta
	 */
	public String getCnpjConsulta() {
		return cnpjConsulta;
	}

	/**
	 * @param cnpjConsulta
	 *            the cnpjConsulta to set
	 */
	public void setCnpjConsulta(String cnpjConsulta) {
		this.cnpjConsulta = cnpjConsulta;
	}

	/**
	 * @return the razaoConsulta
	 */
	public String getRazaoConsulta() {
		return razaoConsulta;
	}

	/**
	 * @param razaoConsulta
	 *            the razaoConsulta to set
	 */
	public void setRazaoConsulta(String razaoConsulta) {
		this.razaoConsulta = razaoConsulta;
	}

	/**
	 * @return the nomeFantasiaConsulta
	 */
	public String getNomeFantasiaConsulta() {
		return nomeFantasiaConsulta;
	}

	/**
	 * @param nomeFantasiaConsulta
	 *            the nomeFantasiaConsulta to set
	 */
	public void setNomeFantasiaConsulta(String nomeFantasiaConsulta) {
		this.nomeFantasiaConsulta = nomeFantasiaConsulta;
	}

}
