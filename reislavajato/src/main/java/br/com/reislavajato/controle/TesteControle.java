/**
 * 
 */
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
import br.com.reislavajato.entidade.Teste;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.TesteNeg;

/**
 * @Criado por: ailto
 * @Data: 21 de nov de 2017
 */

@SuppressWarnings({ "serial" })
@Controller
@ViewScoped
public class TesteControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private TesteNeg testeNeg = context.getBean(TesteNeg.class);

	private Teste teste;
	private List<Teste> testes;

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			testes = testeNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível...");
			erro.printStackTrace();
		}
	}

	public void novo() {
		teste = new Teste();
	}

	public void salvar() throws DadosInvalidosException {
		try {
			testeNeg.incluir(teste);
			novo();
			listar();
			addMensagemAviso(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErro(msgErro);
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			teste = (Teste) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
			addMensagemAviso(msgAlteradoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErro(msgErro);
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			teste = (Teste) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemAviso(msgAlteradoSucesso);
			erro.printStackTrace();
		}
	}

	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	@Override
	protected void criarEntidade() {

	}

}
