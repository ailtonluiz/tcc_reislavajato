/**
 * 
 */
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

import br.com.reislavajato.dao.CargoDao;
import br.com.reislavajato.entidade.Cargo;
import br.com.reislavajato.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
// teste Delmondes
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class CargoControle implements Serializable {
	CargoDao cargoDao = new CargoDao();
	// Teste
	private Cargo cargo;
	private List<Cargo> cargos;

	@PostConstruct
	public void listar() {
		try {
			cargos = cargoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) cargo(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		cargo = new Cargo();
	}

	public void salvar() {
		try {
			cargoDao.merge(cargo);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("registroSelecionado");
			cargoDao.excluir(cargo);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
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
