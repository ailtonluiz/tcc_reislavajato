package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.EstadoDao;
import br.com.reislavajato.entidade.Estado;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@ManagedBean
@ViewScoped
public class EstadoControle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EstadoDao estadoDao = new EstadoDao();

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			estados = estadoDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar os estados!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			estadoDao.merge(estado);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar os estados!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {

			estado = (Estado) evento.getComponent().getAttributes().get("registroSelecionado");
			estadoDao.excluir(estado);
			listar();

			Messages.addGlobalInfo("Registro removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível excluir o registro! ");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("registroSelecionado");
	}
}
