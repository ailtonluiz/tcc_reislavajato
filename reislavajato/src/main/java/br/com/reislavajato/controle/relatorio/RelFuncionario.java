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
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.util.ReisLavajatoUtil;
import net.sf.jasperreports.engine.JRException;

@Controller("RelPessoaControle")
public class RelFuncionario extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 2830538108928145303L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios;

	public RelFuncionario() {
		this.novo();
	}

	@Override
	protected String novo() {
		funcionario = new Funcionario();
		funcionarios = new ArrayList<Funcionario>();
		return "sucesso";
	}

	protected void atualizarListaEntidades() throws Exception {
		try {
			funcionarios = funcionarioNeg.listar();
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

	/*
	 * try { String caminho = Faces.getRealPath("/reports/pessoa.jasper");
	 * Map<String, Object> parametros = new HashMap<>(); Connection conexao =
	 * HibernateUtil.getConexao(); JasperPrint relatorio =
	 * JasperFillManager.fillReport(caminho, parametros, conexao); //
	 * JasperPrintManager.printReport(relatorio, true);
	 * JasperViewer.viewReport(relatorio);
	 * 
	 * } catch (JRException erro) { erro.printStackTrace();
	 * Messages.addGlobalError("Não foi possível gerar o relatório!"); }
	 */
	public String realizarImpressao() {
		this.atualizarLista();

		Map parametros = new HashMap();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (funcionarios.size() == 0) {
				throw new DadosInvalidosException("Não foram encontrados Pessoas!");
			}

			String caminhoSubreport = ((ServletContext) context.getExternalContext().getContext()).getRealPath("jasper")
					+ "/";
			parametros.put("SUBREPORT_DIR", caminhoSubreport);
			String caminhoImagem = ((ServletContext) context.getExternalContext().getContext()).getRealPath("imagens")
					+ "/";
			parametros.put("IMAGES_DIR", caminhoImagem);

			ReisLavajatoUtil.gerarRelatorioFaces("jasper/relDiscentes.jasper", funcionarios, parametros);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (DadosInvalidosException e) {
			addMensagemAviso(e.getMessage());
		}
		return null;
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

}