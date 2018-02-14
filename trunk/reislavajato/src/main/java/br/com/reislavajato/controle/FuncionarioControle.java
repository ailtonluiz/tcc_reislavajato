
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
public class FuncionarioControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);
	private CargoNeg cargoNeg = context.getBean(CargoNeg.class);
	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	private String cpfConsulta, nomeConsulta, cnpjConsulta, nomeFantasiaConsulta;

	public FuncionarioControle() throws DadosInvalidosException {
		this.novo();
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {
		if (funcionario.getPessoa().getEndereco().getMunicipio().getCodigo() == null || funcionario.getPessoa().getEndereco().getMunicipio().getCodigo() == 0L) {
			return municipioNeg.listarPorUf(funcionario.getPessoa().getEndereco().getMunicipio().getUf());
		} else {
			return municipioNeg.listarPorNome(funcionario.getPessoa().getEndereco().getMunicipio().getNome());
		}
	}

	public List<Cargo> getCargos() throws DadosInvalidosException {
		return cargoNeg.listar();
	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			funcionario.getPessoa().setEndereco(CepWs.getEnderecoPorCep(Numero.removerFormatoCEP(funcionario.getPessoa().getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public void listarFuncionarios() throws DadosInvalidosException {
		try {
			if (!ReisLavajatoUtil.ehVazio(cpfConsulta) || !ReisLavajatoUtil.ehVazio(nomeConsulta)) {
				funcionarios = funcionarioNeg.listarPorCpfOuNome(Numero.removerFormatoCPF(cpfConsulta), nomeConsulta);
			} else if (!ReisLavajatoUtil.ehVazio(cnpjConsulta) || !ReisLavajatoUtil.ehVazio(nomeFantasiaConsulta)) {
				funcionarios = funcionarioNeg.listarPorCnpjOuNomeFantasia(Numero.removerFormatoCNPJ(cnpjConsulta), nomeFantasiaConsulta);
			}
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	@Override
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

	public void salvar() throws DadosInvalidosException {
		try {
			funcionario.getPessoa().setPessoaJuridica(null);
			funcionarioNeg.alterar(funcionario);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			funcionarioNeg.excluir(funcionario);
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
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
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
