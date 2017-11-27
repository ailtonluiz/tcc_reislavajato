
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.CargoDao;
import br.com.reislavajato.dao.CidadeDao;
import br.com.reislavajato.dao.EstadoDao;
import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.entidade.Cargo;
import br.com.reislavajato.entidade.Cidade;
import br.com.reislavajato.entidade.Estado;
import br.com.reislavajato.entidade.Funcionario;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class FuncionarioControle implements Serializable {

	FuncionarioDao funcionarioDao = new FuncionarioDao();
	CidadeDao cidadeDao = new CidadeDao();
	EstadoDao estadoDao = new EstadoDao();
	CargoDao cargoDao = new CargoDao();

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private Estado estado;
	private List<Cidade> cidades;
	private List<Estado> estados;
	private List<Cargo> cargos;

	@PostConstruct
	public void listar() {
		try {
			funcionarios = funcionarioDao.listar();
			cargos = cargoDao.listar();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) funcionário(s)!");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {
			funcionario = new Funcionario();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			funcionarioDao.merge(funcionario);
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
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			funcionarioDao.excluir(funcionario);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("registroSelecionado");
			estado = funcionario.getCidade().getEstado();
			listar();
			popular();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void popular() {
		try {
			if (estado != null) {
				cidades = cidadeDao.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
