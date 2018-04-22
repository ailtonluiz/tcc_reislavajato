
package br.com.reislavajato.controle.relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.controle.ReisLavajatoControle;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.util.ReisLavajatoUtil;
import net.sf.jasperreports.engine.JRException;

@Controller("RelFuncionario")
public class RelFuncionario extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 2830538108928145303L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private String cpfConsulta;
	private String nomeConsulta;

	public RelFuncionario() {
		this.novo();
	}

	@Override
	protected String novo() {
		funcionario = new Funcionario();
		cpfConsulta = "";
		nomeConsulta = "";
		return "sucesso";
	}

	private void atualizarListaEntidades() throws Exception {
		try {
			funcionarios = context.getBean(FuncionarioNeg.class).listar();
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public String realizarImpressao() throws Exception {
		this.atualizarListaEntidades();

		Map parametros = new HashMap();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (funcionarios.size() == 0) {
				throw new DadosInvalidosException("Não foram encontrados Funcionarios!");
			}

			String caminhoSubreport = ((ServletContext) context.getExternalContext().getContext()).getRealPath("jasper")
					+ "/";
			parametros.put("SUBREPORT_DIR", caminhoSubreport);

			String caminhoImagem = ((ServletContext) context.getExternalContext().getContext()).getRealPath("imagens")
					+ "/";
			parametros.put("IMAGES_DIR", caminhoImagem);

			String caminhoRelatorio = "reports/funcionario.jasper";

			ReisLavajatoUtil.gerarRelatorioFaces("reports/funcionario.jasper", funcionarios, parametros);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (DadosInvalidosException e) {
			addMensagemAviso(e.getMessage());
		}
		return null;
	}

	// exemplo de uso de Download via Primefaces
	private StreamedContent file;

	public void getArquivo() {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("/home/telmo/arquivo.pdf");
		file = new DefaultStreamedContent(stream, "application/pdf", "downloaded_arquivo.pdf");
	}

	public StreamedContent getFile() {
		return file;
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

	public String getCpfConsulta() {
		return cpfConsulta;
	}

	public void setCpfConsulta(String cpfConsulta) {
		this.cpfConsulta = cpfConsulta;
	}

	public String getNomeConsulta() {
		return nomeConsulta;
	}

	public void setNomeConsulta(String nomeConsulta) {
		this.nomeConsulta = nomeConsulta;
	}

}