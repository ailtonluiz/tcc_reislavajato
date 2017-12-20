
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cargo;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.CargoNeg;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.MunicipioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("funcionarioControle")
@ViewScoped
public class FuncionarioControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);
	private CargoNeg cargoNeg = context.getBean(CargoNeg.class);
	// private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	private List<Cargo> cargos;

	/**
	 * public List<Municipio> getMunicipios() throws DadosInvalidosException {
	 * List<Municipio> municipios =
	 * municipioNeg.listarPorUf(funcionario.getEndereco().getMunicipio().getUf());
	 * return municipios; }
	 */

	// @PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			funcionarios = funcionarioNeg.listar();
			cargos = cargoNeg.listar();
			// municipios = new ArrayList<Municipio>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) funcionário(s)!");
			erro.printStackTrace();
		}

	}

	@Override
	public String novo() {
		try {
			funcionario = new Funcionario();
			funcionarios = new ArrayList<Funcionario>();
			cargos = cargoNeg.listar();
		} catch (RuntimeException | DadosInvalidosException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			funcionarioNeg.incluir(funcionario);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			funcionarioNeg.excluir(funcionario);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

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

	// public List<Municipio> getMunicipios() {
	// return municipios;
	// }
	//
	// public void setMunicipios(List<Municipio> municipios) {
	// this.municipios = municipios;
	// }

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
