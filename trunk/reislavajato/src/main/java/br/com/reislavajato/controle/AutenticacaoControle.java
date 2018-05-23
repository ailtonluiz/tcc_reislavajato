
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
	private Funcionario funcionarioLog;

	@PostConstruct
	public void iniciar() {
		funcionario = new Funcionario();
	}

	public void autenticar() throws DadosInvalidosException {
		try {
			funcionarioLog = funcionarioNeg.autenticar(funcionario.getPessoa().getLogin(), funcionario.getPessoa().getSenha());
			if (funcionarioLog==null) {
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
		funcionarioLog = new Funcionario();
		return "sucesso";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioLog() {
		return funcionarioLog;
	}

	public void setFuncionarioLog(Funcionario funcionarioLog) {
		this.funcionarioLog = funcionarioLog;
	}

}
