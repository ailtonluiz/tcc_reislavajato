package br.com.reislavajato.controle;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MunicipioNeg;
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
@Controller("MunicipioControle")
public class MunicipioControle implements Serializable {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Municipio municipio = new Municipio();
	private List<Municipio> municipios;

	public void listarPorUf() throws DadosInvalidosException {
		try {
			municipios = municipioNeg.listarPorUf(municipio.getUf());
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar as Municipios!");
			erro.printStackTrace();
		}
	}

	public String novo() {
		try {
			municipio = new Municipio();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
		return "sucess";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			municipioNeg.incluir(municipio);
			this.novo();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			municipio = (Municipio) evento.getComponent().getAttributes().get("registroSelecionado");
			municipioNeg.excluir(municipio);
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			municipio = (Municipio) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("frmListagem:tabela");
			Map<String, Object> filtros = tabela.getFilters();

			// String estadoNome = (String) filtros.get("estado.nome");

			String caminho = Faces.getRealPath("/reports/municipio.jasper");

			Map<String, Object> parametros = new HashMap<>();
			// if (estadoNome == null) {
			// parametros.put("municipio", "%%");
			// } else {
			// parametros.put("municipio", "%" + estadoNome + "%");
			// }

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperViewer.viewReport(relatorio);

		} catch (JRException erro) {
			Messages.addGlobalError("Não foi possível gerar o relatório!");
			erro.printStackTrace();
		}
	}

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
