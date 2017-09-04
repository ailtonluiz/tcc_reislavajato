package br.com.reislavajato.controle;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.reislavajato.dao.CidadeDao;
import br.com.reislavajato.dao.EstadoDao;
import br.com.reislavajato.entidade.Cidade;
import br.com.reislavajato.entidade.Estado;
import br.com.reislavajato.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class CidadeControle implements Serializable {

	CidadeDao cidadeDao = new CidadeDao();
	EstadoDao estadoDao = new EstadoDao();

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

	@PostConstruct
	public void listar() {
		try {
			cidades = cidadeDao.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar as cidades!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			cidade = new Cidade();
			estados = estadoDao.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			cidadeDao.merge(cidade);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("registroSelecionado");
			cidadeDao.excluir(cidade);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("registroSelecionado");
			estados = estadoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("frmListagem:tabela");
			Map<String, Object> filtros = tabela.getFilters();
			String estadoNome = (String) filtros.get("estado.nome");

			String caminho = Faces.getRealPath("/reports/cidade.jasper");
			Map<String, Object> parametros = new HashMap<>();
			if (estadoNome == null) {
				parametros.put("CIDADE", "%%");
			} else {
				parametros.put("CIDADE", "%" + estadoNome + "%");
			}

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperViewer.viewReport(relatorio);

		} catch (JRException erro) {
			Messages.addGlobalError("Não foi possível gerar o relatório!");
			erro.printStackTrace();
		}
	}
}
