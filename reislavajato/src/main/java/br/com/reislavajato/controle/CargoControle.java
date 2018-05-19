package br.com.reislavajato.controle;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cargo;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.CargoNeg;
import br.com.reislavajato.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Controller
public class CargoControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 2611869376413469275L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Cargo cargo;
	private List<Cargo> cargos;

	public CargoControle() {
		this.novo();
	}

	@Override
	@PostConstruct
	public String novo() {
		cargos = new ArrayList<Cargo>();
		cargo = new Cargo();

		try {
			this.listar();
		} catch (DadosInvalidosException e) {
			addMensagemErroFatal(e);
		}
		return "sucesso";
	}

	public void listar() throws DadosInvalidosException {
		
		try {
			cargos = context.getBean(CargoNeg.class).listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			context.getBean(CargoNeg.class).alterar(cargo);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("registroSelecionado");
			context.getBean(CargoNeg.class).excluir(cargo);
			novo();
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/pessoa.jasper");
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
