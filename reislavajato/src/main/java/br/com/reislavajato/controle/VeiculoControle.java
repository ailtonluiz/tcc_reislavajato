package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
@Controller ("veiculoControle")
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
			addMensagemErroFatal(erro);
		}
	}

	@Override
	public String novo() {
		try {
			veiculo = new Veiculo();
			marcas = marcaNeg.listar();
		} catch (RuntimeException | DadosInvalidosException erro) {
			addMensagemErroFatal(erro);
		}
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			
			veiculoNeg.alterar(veiculo);
			novo();
			listar();
			addMensagemInfo(msgIncluidoSucesso);
		
		
		
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
			marcas = marcaNeg.listar();
			addMensagemInfo(msgAlteradoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}
	
	
	//getters and setters

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

}
