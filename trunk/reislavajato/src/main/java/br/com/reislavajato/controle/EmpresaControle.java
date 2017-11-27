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
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.EmpresaNeg;
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
@Controller
@SuppressWarnings("serial")
public class EmpresaControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private EmpresaNeg empresaNeg = context.getBean(EmpresaNeg.class);

	private Empresa empresa;
	private List<Empresa> empresas;
	private List<Municipio> municipios;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			empresas = empresaNeg.listar();
			municipios = new ArrayList<Municipio>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível listar!");
			erro.printStackTrace();
		}
	}

	@Override
	protected String novo() {
		try {
			empresa = new Empresa();
			municipios = new ArrayList<Municipio>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
		}
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			empresaNeg.incluir(empresa);
			novo();
			empresas = empresaNeg.listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
		}

	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("registroSelecionado");
			empresaNeg.excluir(empresa);
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
