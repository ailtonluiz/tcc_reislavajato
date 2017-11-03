package br.com.reislavajato.controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.CadastroDao;
import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.dao.MovimentoDao;
import br.com.reislavajato.dao.ServicoDao;
import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Cadastro;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.ItemMovimento;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class MovimentacaoControle implements Serializable {

	ItemMovimento itemMovimento = new ItemMovimento();
	ServicoDao servicoDao = new ServicoDao();
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	VeiculoDao veiculoDao = new VeiculoDao();
	CadastroDao cadastroDao = new CadastroDao();

	private Funcionario funcionario;
	private Movimento movimento;
	private List<ItemMovimento> itensMovimento;
	private List<Servico> servicos;
	private List<Cadastro> cadastros;
	private List<Funcionario> funcionarios;
	private List<Veiculo> veiculos;

	@PostConstruct
	public void novo() {
		try {
			movimento = new Movimento();
			movimento.setVlrTotal(new BigDecimal("0.00"));
			servicos = servicoDao.listar("descricao");
			itensMovimento = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível carregar as informações");
			erro.printStackTrace();
		}
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
			itemMovimento
					.setVlrParcial(servico.getVlrServico().multiply(new BigDecimal(itemMovimento.getQuantidade())));
			itemMovimento
					.setVlrComissao(servico.getPercComissao().multiply(new BigDecimal(itemMovimento.getQuantidade())));
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

	public void listar() {
		try {
			funcionarios = funcionarioDao.listar();
			veiculos = veiculoDao.listar();
			cadastros = cadastroDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar" + erro);
			erro.printStackTrace();
		}
	}

	public void finalizar() {
		try {
			movimento.setHorario(new Date());
			
			listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível finalizar a venda" + erro);
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			if (movimento.getVlrTotal().signum() == 0) {
				Messages.addGlobalError("Valor total não pode ser 'R$: 0,00'");
				return;
			}
			MovimentoDao movimentoDao = new MovimentoDao();
			movimentoDao.salvar(movimento, itensMovimento);
			novo();
			Messages.addGlobalInfo("Operação realizada com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!" + erro);
			erro.printStackTrace();
		}
	}

	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ItemMovimento getItemMovimento() {
		return itemMovimento;
	}

	public void setItemMovimento(ItemMovimento itemMovimento) {
		this.itemMovimento = itemMovimento;
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

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
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
