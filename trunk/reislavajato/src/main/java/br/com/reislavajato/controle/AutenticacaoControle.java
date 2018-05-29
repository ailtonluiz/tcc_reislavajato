
package br.com.reislavajato.controle;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.omnifaces.util.Faces;
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
@Controller("AutenticacaoControle")
public class AutenticacaoControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 8627898853242895070L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private Funcionario funcionario;
	private String loginConsulta;
	private String senhaConsulta;

	public void autenticar() throws DadosInvalidosException {
		try {
			funcionario = context.getBean(FuncionarioNeg.class).autenticar(loginConsulta, senhaConsulta);
			if (funcionario == null) {
				addMensagemAviso("Usuário e/ou senha inválido!");
			} else {
				Faces.redirect("./pages/principal.xhtml");
				addMensagemInfo("Seja bem vindo!");
			}
		} catch (IOException e) {
			addMensagemErroFatal(e);
		}
	}

	@Override
	@PostConstruct
	protected String novo() {
		funcionario = new Funcionario();
		loginConsulta = "";
		senhaConsulta = "";
		return "sucesso";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getLoginConsulta() {
		return loginConsulta;
	}

	public void setLoginConsulta(String loginConsulta) {
		this.loginConsulta = loginConsulta;
	}

	public String getSenhaConsulta() {
		return senhaConsulta;
	}

	public void setSenhaConsulta(String senhaConsulta) {
		this.senhaConsulta = senhaConsulta;
	}

}
