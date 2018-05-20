package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.auditoria.ServicoAuditoria;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.ServicoNeg;
import br.com.reislavajato.neg.ServicoNegAuditoria;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class ServicoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Servico servico;
	private List<Servico> servicos;

	private ServicoAuditoria servicoAuditoria;
	private List<ServicoAuditoria> servicoAuditorias;

	public ServicoControle() throws DadosInvalidosException {
		this.novo();
	}

	@PostConstruct
	public String novo() {
		servico = new Servico();
		servicos = new ArrayList<Servico>();
		try {
			this.listar();
		} catch (DadosInvalidosException e) {
			addMensagemErroFatal(e);
		}
		return "sucesso";
	}

	public void listar() throws DadosInvalidosException {
		try {
			servicos = context.getBean(ServicoNeg.class).listar();
			servicoAuditorias = context.getBean(ServicoNegAuditoria.class).listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			context.getBean(ServicoNeg.class).alterar(servico);
			novo();
			listar();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			servico = (Servico) evento.getComponent().getAttributes().get("registroSelecionado");
			context.getBean(ServicoNeg.class).excluir(servico);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) {
		try {
			servico = (Servico) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public List<Funcionario> getFuncionarios() throws DadosInvalidosException {
		return context.getBean(FuncionarioNeg.class).listar();
	}

	// getters and setters

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public ServicoAuditoria getServicoAuditoria() {
		return servicoAuditoria;
	}

	public void setServicoAuditoria(ServicoAuditoria servicoAuditoria) {
		this.servicoAuditoria = servicoAuditoria;
	}

	public List<ServicoAuditoria> getServicoAuditorias() {
		return servicoAuditorias;
	}

	public void setServicoAuditorias(List<ServicoAuditoria> servicoAuditorias) {
		this.servicoAuditorias = servicoAuditorias;
	}

}
