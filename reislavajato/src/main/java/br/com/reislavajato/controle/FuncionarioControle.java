
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cargo;
import br.com.reislavajato.entidade.Endereco;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.CargoNeg;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.util.CepWs;
import br.com.reislavajato.util.Numero;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@Controller("funcionarioControle") // anotação do Spring para classe controladora, é uma especialização do
									// @Conponent
public class FuncionarioControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = -1615057246414126565L;

	// habilitado pelo @Configuration, permitindo o Scan de classes do Appconfig, e
	// a chamade de classes por apelido dentro dos métodos
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;

	private String cpfConsulta;
	private String nomeConsulta;
	private String cnpjConsulta;
	private String nomeFantasiaConsulta;

	public FuncionarioControle() throws DadosInvalidosException {
		this.novo();
	}
	// A anotação PostConstruct é usada em um método que precisa ser executado após
	// a injeção de dependência ser feita para executar qualquer inicialização. Este
	// método DEVE ser chamado antes que a classe seja colocada em serviço.

	@Override
	@PostConstruct
	public String novo() {
		funcionario = new Funcionario();
		funcionario.setPessoa(new Pessoa());
		funcionario.getPessoa().setEndereco(new Endereco());
		funcionario.getPessoa().getEndereco().setMunicipio(new Municipio());
		funcionarios = new ArrayList<Funcionario>();

		cpfConsulta = "";
		nomeConsulta = "";
		cnpjConsulta = "";
		nomeFantasiaConsulta = "";

		return "sucesso";
	}

	@PostConstruct
	public void listarFuncionarios() throws DadosInvalidosException {
		try {
			funcionarios = context.getBean(FuncionarioNeg.class).listarPorCpfOuNome(cpfConsulta, nomeConsulta);
			funcionarios = context.getBean(FuncionarioNeg.class).listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			funcionario.getPessoa().setPessoaJuridica(null);
			context.getBean(FuncionarioNeg.class).alterar(funcionario);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			context.getBean(FuncionarioNeg.class).excluir(funcionario);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			if (funcionario.getPessoa().getEndereco().getMunicipio() == null) {
				funcionario.getPessoa().getEndereco().setMunicipio(new Municipio());
			}
			context.getBean(FuncionarioNeg.class).alterar(funcionario);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {
		if (funcionario.getPessoa().getEndereco().getMunicipio().getCodigo() == null
				|| funcionario.getPessoa().getEndereco().getMunicipio().getCodigo() == 0L) {
			return context.getBean(MunicipioNeg.class)
					.listarPorUf(funcionario.getPessoa().getEndereco().getMunicipio().getUf());
		} else {
			return context.getBean(MunicipioNeg.class)
					.listarPorNome(funcionario.getPessoa().getEndereco().getMunicipio().getNome());
		}
	}

	public List<Cargo> getCargos() throws DadosInvalidosException {
		return context.getBean(CargoNeg.class).listar();
	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			funcionario.getPessoa().setEndereco(
					CepWs.getEnderecoPorCep(Numero.removerFormatoCEP(funcionario.getPessoa().getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	// getters and setters

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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

}
