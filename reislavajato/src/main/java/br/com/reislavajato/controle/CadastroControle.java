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

import br.com.reislavajato.dao.CadastroDao;
import br.com.reislavajato.dao.MunicipioDao;
import br.com.reislavajato.entidade.Cadastro;
import br.com.reislavajato.entidade.Municipio;
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
public class CadastroControle implements Serializable {

	private CadastroDao cadastroDao = new CadastroDao();
	private MunicipioDao municipioDao = new MunicipioDao();
	private Cadastro cadastro = new Cadastro();
	private List<Cadastro> cadastros;

	private String opcao;

	private Boolean isRederiza = false;

	@PostConstruct
	public void listar() {
		try {
			cadastros = cadastroDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar a(s) cadastro(s)!");
			erro.printStackTrace();
		}
	}

	public List<Municipio> getMunicipios() {
		return municipioDao.listarPorUf(cadastro.getMunicipio().getUf());
	}

	public void novo() {
		try {
			cadastro = new Cadastro();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			cadastroDao.merge(cadastro);
			novo();
			cadastros = cadastroDao.listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cadastro = (Cadastro) evento.getComponent().getAttributes().get("registroSelecionado");
			cadastroDao.excluir(cadastro);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cadastro = (Cadastro) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/cadastro.jasper");
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

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Boolean getIsRederiza() {
		return isRederiza;
	}

	public void setIsRederiza(Boolean isRederiza) {
		this.isRederiza = isRederiza;
	}

}
