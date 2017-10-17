/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.EmpresaDao;
import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @Criado por: ailtonluiz
 * @Data: 5 de set de 2017
 */
@ViewScoped
@ManagedBean
@SuppressWarnings("serial")
public class EmpresaControle implements Serializable {

	private EmpresaDao empresaDao = new EmpresaDao();

	private Empresa empresa;
	private List<Empresa> empresas;
	private List<Municipio> municipios;

	@PostConstruct
	public void listar() {
		try {
			empresas = empresaDao.listar();
			municipios = new ArrayList<Municipio>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível listar!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			empresa = new Empresa();
			municipios = new ArrayList<Municipio>();
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
			listar();
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

	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/empresa.jasper");
			Map<String, Object> parametros = new HashMap<>();
			Connection conexao = HibernateUtil.getConexao();
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			// JasperPrintManager.printReport(relatorio, true);
			JasperViewer.viewReport(relatorio);

		} catch (JRException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível gerar o relatório!");
		}
	}

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

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

}
