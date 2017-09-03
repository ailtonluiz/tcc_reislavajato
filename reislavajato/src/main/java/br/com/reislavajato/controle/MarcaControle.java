package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.MarcaDao;
import br.com.reislavajato.entidade.Marca;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({  "serial" })
@ManagedBean
@ViewScoped
public class MarcaControle implements Serializable {

	MarcaDao marcaDao = new MarcaDao();
	private Marca marca;
	private List<Marca> marcas;

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	@PostConstruct
	public void listar() {
		try {
			marcas = marcaDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar a(s) marca(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		marca = new Marca();
	}

	public void salvar() {
		try {
			marcaDao.merge(marca);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			marca = (Marca) evento.getComponent().getAttributes().get("registroSelecionado");
			marcaDao.excluir(marca);
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			marca = (Marca) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}
}
