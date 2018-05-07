package br.com.reislavajato.controle.relatorio;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.controle.ReisLavajatoControle;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.util.ReisLavajatoUtil;
import net.sf.jasperreports.engine.JRException;

@Controller("RelMunicipioControle")
public class RelMunicipio extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 2830538108928145303L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Municipio municipio = new Municipio();
	private List<Municipio> municipios;

	public RelMunicipio() {
		this.novo();
	}

	@Override
	protected String novo() {
		municipio = new Municipio();
		municipios = new ArrayList<Municipio>();
		return "sucesso";
	}

	protected void atualizarListaEntidades() throws Exception {
		try {
			municipios = municipioNeg.listarPorUf(municipio.getUf());
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public String atualizarLista() {
		try {
			atualizarListaEntidades();
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
		return null;
	}

	public String realizarImpressao() {
		this.atualizarLista();

		Map parametros = new HashMap();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (municipios.size() == 0) {
				throw new DadosInvalidosException("Não foram encontrados Municipios!");
			}

			String caminhoSubreport = ((ServletContext) context.getExternalContext().getContext()).getRealPath("jasper") + "/";
			parametros.put("SUBREPORT_DIR", caminhoSubreport);
			String caminhoImagem = ((ServletContext) context.getExternalContext().getContext()).getRealPath("imagens") + "/";
			parametros.put("IMAGES_DIR", caminhoImagem);

			ReisLavajatoUtil.gerarRelatorioFaces("jasper/relDiscentes.jasper", municipios, parametros);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (DadosInvalidosException e) {
			addMensagemAviso(e.getMessage());
		}
		return null;
	}

	// public void imprimir() {
	// try {
	// DataTable tabela = (DataTable)
	// Faces.getViewRoot().findComponent("frmListagem:tabela");
	// @SuppressWarnings("unused")
	// Map<String, Object> filtros = tabela.getFilters();
	//
	// // String estadoNome = (String) filtros.get("estado.nome");
	//
	// String caminho = Faces.getRealPath("/reports/municipio.jasper");
	//
	// Map<String, Object> parametros = new HashMap<>();
	// // if (estadoNome == null) {
	// // parametros.put("municipio", "%%");
	// // } else {
	// // parametros.put("municipio", "%" + estadoNome + "%");
	// // }
	//
	// Connection conexao = HibernateUtil.getConexao();
	//
	// JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros,
	// conexao);
	// JasperViewer.viewReport(relatorio);
	//
	// } catch (JRException erro) {
	// addMensagemAviso("Não foi possível gerar o relatório!");
	// addMensagemErroFatal(erro);
	// }
	// }

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