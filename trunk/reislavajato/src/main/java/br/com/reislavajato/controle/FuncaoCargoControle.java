package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.FuncaoCargo;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncaoCargoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class FuncaoCargoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private FuncaoCargoNeg funcaoCargoNeg = context.getBean(FuncaoCargoNeg.class);

	private FuncaoCargo funcaoCargo;
	private List<FuncaoCargo> funcoesCargo;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			funcoesCargo = funcaoCargoNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) cargo(s)!");
			erro.printStackTrace();
		}
	}

	@Override
	public String novo() {
		funcaoCargo = new FuncaoCargo();
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			funcaoCargoNeg.alterar(funcaoCargo);
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
			funcaoCargo = (FuncaoCargo) evento.getComponent().getAttributes().get("registroSelecionado");
			funcaoCargoNeg.excluir(funcaoCargo);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			funcaoCargo = (FuncaoCargo) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public FuncaoCargo getFuncaoCargo() {
		return funcaoCargo;
	}

	public void setFuncaoCargo(FuncaoCargo funcaoCargo) {
		this.funcaoCargo = funcaoCargo;
	}

	public List<FuncaoCargo> getFuncoesCargo() {
		return funcoesCargo;
	}

	public void setFuncoesCargo(List<FuncaoCargo> funcoesCargo) {
		this.funcoesCargo = funcoesCargo;
	}

}
