/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.Financeiro;
import br.com.reislavajato.enumeradores.EnumStatusFinanceiro;
import br.com.reislavajato.enumeradores.EnumTipoFinanceiro;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FinanceiroNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 25 de abr de 2018
 */
/**
 * @Criado por: ailto
 * @Data: 25 de abr de 2018
 */
@Controller("financeiroControle")
public class FinanceiroControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = -1615057246414126565L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Financeiro financeiro;
	private List<Financeiro> financeiros;
	private Cliente cliente;
	private List<Cliente> clientes;
	private EnumStatusFinanceiro statusFinanceiro;
	private EnumTipoFinanceiro tipoFinanceiro;

	public FinanceiroControle() throws DadosInvalidosException {
		this.novo();
	}

	@Override
	@PostConstruct
	public String novo() {
		financeiro = new Financeiro();
		financeiros = new ArrayList<Financeiro>();

		try {
			this.listar();
		} catch (DadosInvalidosException e) {
			addMensagemErroFatal(e);
		}

		return "sucesso";
	}

	public void listar() throws DadosInvalidosException {
		try {
			financeiros = context.getBean(FinanceiroNeg.class).listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			context.getBean(FinanceiroNeg.class).incluir(financeiro);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			financeiro = (Financeiro) evento.getComponent().getAttributes().get("registroSelecionado");
			context.getBean(FinanceiroNeg.class).excluir(financeiro);
			novo();
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) {
		try {
			financeiro = (Financeiro) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public Financeiro getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(Financeiro financeiro) {
		this.financeiro = financeiro;
	}

	public List<Financeiro> getFinanceiros() {
		return financeiros;
	}

	public void setFinanceiros(List<Financeiro> financeiros) {
		this.financeiros = financeiros;
	}

	public EnumStatusFinanceiro getStatusFinanceiro() {
		return statusFinanceiro;
	}

	public void setStatusFinanceiro(EnumStatusFinanceiro statusFinanceiro) {
		this.statusFinanceiro = statusFinanceiro;
	}

	public EnumTipoFinanceiro getTipoFinanceiro() {
		return tipoFinanceiro;
	}

	public void setTipoFinanceiro(EnumTipoFinanceiro tipoFinanceiro) {
		this.tipoFinanceiro = tipoFinanceiro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
