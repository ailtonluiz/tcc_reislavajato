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
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.VeiculoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("veiculoControle")
@ViewScoped
public class VeiculoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private VeiculoNeg veiculoNeg = context.getBean(VeiculoNeg.class);

	private Veiculo veiculo;
	private List<Veiculo> veiculos;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			veiculos = veiculoNeg.listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	@Override
	@PostConstruct
	public String novo() {
		veiculo = new Veiculo();
		veiculos = new ArrayList<Veiculo>();
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			veiculoNeg.alterar(veiculo);
			novo();
			listar();
			addMensagemInfo(msgSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			veiculo = (Veiculo) evento.getComponent().getAttributes().get("registroSelecionado");
			veiculoNeg.excluir(veiculo);
			listar();
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			veiculo = (Veiculo) evento.getComponent().getAttributes().get("registroSelecionado");
			veiculoNeg.alterar(veiculo);
			addMensagemInfo(msgAlteradoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	// getters and setters

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
