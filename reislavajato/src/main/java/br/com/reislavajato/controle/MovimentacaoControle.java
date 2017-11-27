package br.com.reislavajato.controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.ItemMovimento;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.MovimentoNeg;
import br.com.reislavajato.neg.ServicoNeg;
import br.com.reislavajato.neg.VeiculoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("movimentacaoControle")
public class MovimentacaoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private ServicoNeg servicoNeg = context.getBean(ServicoNeg.class);
	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);
	private VeiculoNeg veiculoNeg = context.getBean(VeiculoNeg.class);
	private MovimentoNeg movimentoNeg = context.getBean(MovimentoNeg.class);

	private ItemMovimento itemMovimento;
	private Funcionario funcionario;
	private Movimento movimento;
	private List<ItemMovimento> itensMovimento;
	private List<Servico> servicos;
	private List<Pessoa> pessoas;
	private List<Funcionario> funcionarios;
	private List<Veiculo> veiculos;

	@PostConstruct
	protected String novo() {
		try {
			movimento = new Movimento();
			movimento.setVlrTotal(new BigDecimal("0.00"));
			servicos = servicoNeg.listar();
			itensMovimento = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível carregar as informações");
			erro.printStackTrace();
		} catch (DadosInvalidosException e) {
			e.printStackTrace();
		}
		return "sucesso";
	}

	public void adicionar(ActionEvent evento) {
		Servico servico = (Servico) evento.getComponent().getAttributes().get("registroSelecionado");

		int achou = -1;
		for (int posicao = 0; posicao < itensMovimento.size(); posicao++) {
			if (itensMovimento.get(posicao).getServico().equals(servico)) {
				achou = posicao;
			}
		}
		if (achou < 0) {
			ItemMovimento itemMovimento = new ItemMovimento();
			itemMovimento.setVlrParcial(servico.getVlrServico());
			itemMovimento.setVlrComissao(servico.getPercComissao());
			itemMovimento.setServico(servico);
			itemMovimento.setQuantidade(new Short("1"));
			itensMovimento.add(itemMovimento);
		} else {
			ItemMovimento itemMovimento = itensMovimento.get(achou);
			itemMovimento.setQuantidade(new Short(itemMovimento.getQuantidade() + 1 + ""));
			itemMovimento.setVlrParcial(servico.getVlrServico().multiply(new BigDecimal(itemMovimento.getQuantidade())));
			itemMovimento.setVlrComissao(servico.getPercComissao().multiply(new BigDecimal(itemMovimento.getQuantidade())));
		}

		calcular();
	}

	public void remover(ActionEvent evento) {
		ItemMovimento itemMovimento = (ItemMovimento) evento.getComponent().getAttributes().get("itemSelecionado");
		int achou = -1;
		for (int posicao = 0; posicao < itensMovimento.size(); posicao++) {
			if (itensMovimento.get(posicao).getServico().equals(itemMovimento.getServico())) {
				achou = posicao;
			}
		}
		if (achou > -1) {
			itensMovimento.remove(achou);
		}
		calcular();
	}

	public void calcular() {
		movimento.setVlrTotal(new BigDecimal("0.00"));

		for (int posicao = 0; posicao < itensMovimento.size(); posicao++) {
			ItemMovimento itemMovimento = itensMovimento.get(posicao);
			movimento.setVlrTotal(movimento.getVlrTotal().add(itemMovimento.getVlrParcial()));
		}
	}

	public void listar() throws DadosInvalidosException {
		try {
			funcionarios = funcionarioNeg.listar();
			veiculos = veiculoNeg.listar();
			// pessoas = pessoaNeg.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar" + erro);
			erro.printStackTrace();
		}
	}

	public void finalizar() throws DadosInvalidosException {
		try {
			movimento.setHorario(new Date());
			listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível finalizar a venda" + erro);
			erro.printStackTrace();
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			if (movimento.getVlrTotal().signum() == 0) {
				Messages.addGlobalError("Valor total não pode ser 'R$: 0,00'");
				return;
			}
			movimentoNeg.incluir(movimento);
			// movimentoNeg.incluir(itensMovimento);
			novo();
			Messages.addGlobalInfo("Operação realizada com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!" + erro);
			erro.printStackTrace();
		}
	}

	public ItemMovimento getItemMovimento() {
		return itemMovimento;
	}

	public void setItemMovimento(ItemMovimento itemMovimento) {
		this.itemMovimento = itemMovimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public List<ItemMovimento> getItensMovimento() {
		return itensMovimento;
	}

	public void setItensMovimento(List<ItemMovimento> itensMovimento) {
		this.itensMovimento = itensMovimento;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
