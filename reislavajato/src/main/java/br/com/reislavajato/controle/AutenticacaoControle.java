
package br.com.reislavajato.controle;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 1 de out de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
@SessionScoped
public class AutenticacaoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);

	private Funcionario funcionario;
	private Funcionario funcionarioLogado;

	@PostConstruct
	public void iniciar() {
		funcionario = new Funcionario();
	}

	public void autenticar() throws DadosInvalidosException {
		try {
			funcionarioLogado = funcionarioNeg.autenticar(funcionario.getPessoa().getEmail(), funcionario.getSenha());
			if (funcionarioLogado == null) {
				Messages.addGlobalError("Usuário e/ou senha inválido!");
				return;
			} else {
				Faces.redirect("./pages/principal.xhtml");
				Messages.addGlobalInfo("Seja bem vindo!");
			}
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}

	@Override
	protected String novo() {
		funcionario = new Funcionario();
		funcionarioLogado = new Funcionario();
		return "sucesso";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

}
