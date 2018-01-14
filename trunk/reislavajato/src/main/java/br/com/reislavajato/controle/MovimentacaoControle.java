package br.com.reislavajato.controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MovimentoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("movimentacaoControle")
public class MovimentacaoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private MovimentoNeg movimentoNeg = context.getBean(MovimentoNeg.class);

	private Movimento movimento = new Movimento();
	private List<Movimento> movimentos;
	private List<Veiculo> veiculos;

	private Veiculo veiculo;

	@PostConstruct
	public String novo() {
		movimento = new Movimento();
		movimentos = new ArrayList<Movimento>();
		return "sucesso";
	}

	public void adicionar(ActionEvent evento) throws DadosInvalidosException {
		try {
			Movimento movimento = (Movimento) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}

	}

	private void calcularValorTotalServico(Movimento movimento) {
		BigDecimal valorTotalServico = new BigDecimal(0.0);

		for (Veiculo veiculo : movimento.getCliente().getVeiculos()) {
			for (Servico servico : veiculo.getServicos()) {
				valorTotalServico.add(servico.getValorServico());
			}
		}

		movimento.setValorTotal(valorTotalServico);
	}

	public void listar() throws DadosInvalidosException {
		try {
			movimentos = movimentoNeg.listarPorStatusServico(EnumStatusServico.EXECUCAO);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	private void finalizar() throws DadosInvalidosException {
		try {
			this.calcularValorTotalServico(movimento);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			this.finalizar();

			movimentoNeg.incluir(movimento);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
