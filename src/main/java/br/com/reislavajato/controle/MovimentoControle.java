/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MovimentoNeg;

/**
 * @Criado por: ailto
 * @Data: 22 de mar de 2018
 */
@Controller
public class MovimentoControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 2611869376413469275L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private MovimentoNeg movimentoNeg = context.getBean(MovimentoNeg.class);

	private Movimento movimento = new Movimento();
	private List<Movimento> movimentos;
	
	
	
	@PostContruct
	public void listar() throws DadosInvalidosException{
		try {
			movimentos = movimentoNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar o(s) cargo(s)!");
			erro.printStackTrace();
		}
	}

}
