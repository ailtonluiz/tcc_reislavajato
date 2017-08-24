/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.CargoDao;
import br.com.reislavajato.entidade.Cargo;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
//teste Delmondes
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class CargoControle implements Serializable {
	CargoDao cargoDao = new CargoDao();
//Teste
	private Cargo cargo;
	private List<Cargo> cargos;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@PostConstruct
	public void listar() {
		try {
			cargos = cargoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) cargo(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		cargo = new Cargo();
	}

	public void salvar() {
		try {
			cargoDao.merge(cargo);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("registroSelecionado");
			cargoDao.excluir(cargo);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

}
