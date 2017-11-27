package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ServicoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class ServicoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private ServicoNeg servicoNeg = context.getBean(ServicoNeg.class);
	private Servico servico;
	private List<Servico> servicos;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			servicos = servicoNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) serviço(s)!");
			erro.printStackTrace();
		}
	}

	@Override
	protected String novo() {
		servico = new Servico();
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			servicoNeg.incluir(servico);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso! ");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			servico = (Servico) evento.getComponent().getAttributes().get("registroSelecionado");
			servicoNeg.excluir(servico);
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			servico = (Servico) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

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

}
