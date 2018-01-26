/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.PessoaJuridica;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.PessoaJuridicaNeg;

/**
 * @Criado por: Unint
 * @Data: 26 de jan de 2018
 */

@SuppressWarnings("serial")
@Controller
public class PessoaJuridicaControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private PessoaJuridicaNeg pessoaJuridicaNeg = context.getBean(PessoaJuridicaNeg.class);

	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private List<PessoaJuridica> pessoasJuridicas;

	@Override
	public String novo() {
		pessoaJuridica = new PessoaJuridica();
		// pessoasJuridicas = new ArrayList<PessoaJuridica>();
		return "sucesso";
	}

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			pessoasJuridicas = pessoaJuridicaNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar a(s) Pessoas Jurídicas(s)!");
			erro.printStackTrace();
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			pessoaJuridicaNeg.incluir(pessoaJuridica);
			novo();
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			pessoaJuridica = (PessoaJuridica) evento.getComponent().getAttributes().get("registroSelecionado");
			pessoaJuridicaNeg.excluir(pessoaJuridica);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		// try{
		// pessoaJuridica = (PessoaJuridica)
		// evento.getComponent().getAttributes().get("registroSelecionado");
		// pessoaJuridicaNeg.alterar(pessoaJuridica);
		// listar();
		// Messages.addGlobalInfo("Operação realizada com sucesso!");
		// }
		// catch (RuntimeException erro) {
		// Messages.addGlobalError("Não foi possível realizar está operação!");
		// erro.printStackTrace();
		// }
		try {
			pessoaJuridica = (PessoaJuridica) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	// getters and setters

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
		this.pessoasJuridicas = pessoasJuridicas;
	}
}
