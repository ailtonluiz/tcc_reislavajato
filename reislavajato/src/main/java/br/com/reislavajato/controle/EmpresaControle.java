/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.CidadeDao;
import br.com.reislavajato.dao.EmpresaDao;
import br.com.reislavajato.dao.EstadoDao;
import br.com.reislavajato.entidade.Cidade;
import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.entidade.Estado;

/**
 * @Criado por: ailtonluiz
 * @Data: 5 de set de 2017
 */
@ViewScoped
@ManagedBean
@SuppressWarnings("serial")
public class EmpresaControle implements Serializable {

	EmpresaDao empresaDao = new EmpresaDao();
	EstadoDao estadoDao = new EstadoDao();
	CidadeDao cidadeDao = new CidadeDao();

	private Empresa empresa;
	private List<Empresa> empresas;
	private Estado estado;
	private List<Estado> estados;
	private List<Cidade> cidades;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {
		try {
			empresas = empresaDao.listar();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível listar!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			empresa = new Empresa();
			estado = new Estado();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
		}
	}

	public void salvar() {
		try {
			empresaDao.merge(empresa);
			novo();
			empresas = empresaDao.listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
		}

	}

	public void editar(ActionEvent evento) {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("registroSelecionado");
			estado = empresa.getCidade().getEstado();
			listar();
			popular();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("registroSelecionado");
			empresaDao.excluir(empresa);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
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

}
