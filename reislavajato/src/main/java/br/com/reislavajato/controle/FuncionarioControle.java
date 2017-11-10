
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

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class FuncionarioControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);
	private CargoNeg cargoNeg = context.getBean(CargoNeg.class);

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Municipio> municipios;
	private List<Cargo> cargos;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			funcionarios = funcionarioNeg.listar();
			cargos = cargoNeg.listar();
			municipios = new ArrayList<Municipio>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) funcionário(s)!");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {
			funcionario = new Funcionario();
			municipios = new ArrayList<Municipio>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
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

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.reislavajato.controle.ReisLavajatoControle#criarEntidade()
	 */
	@Override
	protected void criarEntidade() {
		// TODO Auto-generated method stub

	}

}
