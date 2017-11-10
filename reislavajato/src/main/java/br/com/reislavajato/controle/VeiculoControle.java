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
import br.com.reislavajato.entidade.Marca;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MarcaNeg;
import br.com.reislavajato.neg.VeiculoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class VeiculoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private VeiculoNeg veiculoNeg = context.getBean(VeiculoNeg.class);
	private MarcaNeg marcaNeg = context.getBean(MarcaNeg.class);

	private Veiculo veiculo;
	private List<Veiculo> veiculos;
	private List<Marca> marcas;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			veiculos = veiculoNeg.listar();
			marcas = marcaNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) veículo(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() throws DadosInvalidosException {
		try {
			veiculo = new Veiculo();
			marcas = marcaNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			veiculoNeg.incluir(veiculo);
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
			veiculo = (Veiculo) evento.getComponent().getAttributes().get("registroSelecionado");
			veiculoNeg.excluir(veiculo);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			veiculo = (Veiculo) evento.getComponent().getAttributes().get("registroSelecionado");
			marcas = marcaNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

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

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
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
