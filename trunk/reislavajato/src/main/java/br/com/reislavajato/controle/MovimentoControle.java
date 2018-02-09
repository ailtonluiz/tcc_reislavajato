package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.MovimentoNeg;
import br.com.reislavajato.neg.OrdemServicoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("movimentoControle")
public class MovimentoControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private MovimentoNeg movimentoNeg = context.getBean(MovimentoNeg.class);
	private FuncionarioNeg funcionarioNeg = context.getBean(FuncionarioNeg.class);
	private OrdemServicoNeg ordemServicoNeg = context.getBean(OrdemServicoNeg.class);

	private Movimento movimento = new Movimento();
	private List<Movimento> movimentos;
	private List<Veiculo> veiculos;

	private Veiculo veiculo;

	public MovimentoControle() throws DadosInvalidosException {
		this.listar();
	}

	@PostConstruct
	public String novo() {
		movimento = new Movimento();
		movimentos = new ArrayList<Movimento>();
		return "sucesso";
	}

	// private void calcularValorTotalServico(Movimento movimento) {
	// BigDecimal valorTotalServico = new BigDecimal(0.0);
	//
	// for (Veiculo veiculo : movimento.getCliente().getVeiculos()) {
	// for (Servico servico : veiculo.getServicos()) {
	// valorTotalServico.add(servico.getValorServico());
	// }
	// }
	//
	// movimento.setValorTotal(valorTotalServico);
	// }

	public void listar() throws DadosInvalidosException {
		try {
			movimentos = movimentoNeg.listarPorStatusServico(EnumStatusServico.EXECUCAO);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	// private void finalizar() throws DadosInvalidosException {
	// try {
	// this.calcularValorTotalServico(movimento);
	// } catch (RuntimeException erro) {
	// addMensagemErroFatal(erro);
	// }
	// }

	public void salvar() throws DadosInvalidosException {
		try {
			// this.finalizar();

			movimentoNeg.incluir(movimento);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			movimento = (Movimento) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public List<OrdemServico> getOrdensServico() throws DadosInvalidosException {
		return ordemServicoNeg.listarPorStatus(EnumStatusServico.PARADO);
	}
	//
	// public static Endereco getEnderecoPorCep(String cep) {
	//
	// JsonObject jsonObject = getCepResponse(cep);
	//
	// JsonValue erro = jsonObject.get("erro");
	//
	// if (erro == null) {
	// endereco = new Endereco();
	// endereco.setCep(jsonObject.getString("cep"));
	// endereco.setLogradouro(jsonObject.getString("logradouro"));
	// endereco.setComplemento(jsonObject.getString("complemento"));
	// endereco.setBairro(jsonObject.getString("bairro"));
	// endereco.setNumero(jsonObject.getString("unidade"));
	//
	// endereco.getMunicipio().setNome(jsonObject.getString("localidade"));
	// endereco.getMunicipio().setCodigo(Long.parseLong(jsonObject.getString("ibge")));
	// setarUF(jsonObject);
	// }
	// return endereco;
	//
	// }

	public void preencherEntidadeMovimento(OrdemServico ordemServico) throws DadosInvalidosException {

	}

	public List<Funcionario> getFuncionarios() throws DadosInvalidosException {
		return funcionarioNeg.listar();
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
