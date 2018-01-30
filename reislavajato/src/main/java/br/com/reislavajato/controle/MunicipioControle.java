package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MunicipioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("municipioControle")
public class MunicipioControle extends ReisLavajatoControle implements Serializable {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Municipio municipio;
	private List<Municipio> municipios;

	public MunicipioControle() {
		this.novo();
	}

	@Override
	public String novo() {
		try {
			municipio = new Municipio();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
		return "sucess";
	}

	
	public void listarPorUf() throws DadosInvalidosException {
		try {
			municipios = municipioNeg.listarPorUf(municipio.getUf());
		} catch (RuntimeException erro) {
			addMensagemErro("Não foi possível listar os Municípios!");
			addMensagemErroFatal(erro);
		}
	}
	
	public void listarPorNome() throws DadosInvalidosException {
		try {
			if (municipio.getNome().length() > 0 && !municipio.getNome().equals("")) {
				municipios = municipioNeg.listarPorNome(municipio.getNome());
			} else {
				listarPorUf();
			}
		} catch (RuntimeException erro) {
			addMensagemErro("Não foi possível listar os Municípios!");
			addMensagemErroFatal(erro);
		}
	}

	public void listarPorNomeeUF() throws DadosInvalidosException {
		try {
			if (municipio.getNome().length() > 0 && !municipio.getNome().equals("")) {
				municipios = municipioNeg.listarPorNomeeUF(municipio.getNome(), municipio.getUf());
			} else {
				listarPorUf();
			}
		} catch (RuntimeException erro) {
			addMensagemErro("Não foi possível listar os Municípios!");
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			municipioNeg.alterar(municipio);
			this.novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			municipio = (Municipio) evento.getComponent().getAttributes().get("registroSelecionado");
			municipioNeg.excluir(municipio);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);

		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			municipio = (Municipio) evento.getComponent().getAttributes().get("registroSelecionado");
			municipioNeg.alterar(municipio);
			addMensagemInfo(msgAlteradoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}
	
	//getters and setters

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

}
