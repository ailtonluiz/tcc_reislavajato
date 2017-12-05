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
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.PessoaNeg;
import br.com.reislavajato.util.ReisLavajatoUtil;
import net.sf.jasperreports.engine.JRException;

@Controller("RelPessoaControle")
public class RelPessoaControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 2830538108928145303L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private PessoaNeg pessoaNeg = context.getBean(PessoaNeg.class);

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas;

	public RelPessoaControle() {
		this.novo();
	}

	@Override
	protected String novo() {
		pessoa = new Pessoa();
		pessoas = new ArrayList<Pessoa>();
		return "sucesso";
	}

	protected void atualizarListaEntidades() throws Exception {
		try {
			pessoas = pessoaNeg.listar();
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
			if (pessoas.size() == 0) {
				throw new DadosInvalidosException("Não foram encontrados Pessoas!");
			}

			String caminhoSubreport = ((ServletContext) context.getExternalContext().getContext()).getRealPath("jasper") + "/";
			parametros.put("SUBREPORT_DIR", caminhoSubreport);
			String caminhoImagem = ((ServletContext) context.getExternalContext().getContext()).getRealPath("imagens") + "/";
			parametros.put("IMAGES_DIR", caminhoImagem);

			ReisLavajatoUtil.gerarRelatorioFaces("jasper/relDiscentes.jasper", pessoas, parametros);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (DadosInvalidosException e) {
			addMensagemAviso(e.getMessage());
		}
		return null;
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the pessoas
	 */
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	/**
	 * @param pessoas
	 *            the pessoas to set
	 */
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}