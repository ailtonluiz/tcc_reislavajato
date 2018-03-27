package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.OrdemServicoNeg;
import br.com.reislavajato.neg.ServicoNeg;
import br.com.reislavajato.neg.VeiculoNeg;
import br.com.reislavajato.util.Numero;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@Controller("ordemServicoControle")
public class OrdemServicoControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 5234442544726838115L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private OrdemServico ordemServico;
	private List<OrdemServico> ordensServicos;

	private String cpfConsulta;
	private String nomeConsulta;
	private String cnpjConsulta;
	private String nomeFantasiaConsulta;
	private Long numeroOSConsulta;
	private EnumStatusServico statusServicoConsulta;

	private Funcionario funcionarioSelecionado;
	private Servico servicoSelecionado;
	private LinkedList<Servico> servicosSelecionados;

	public OrdemServicoControle() throws DadosInvalidosException {
		this.novo();
	}

	@Override
	protected String novo() {
		ordemServico = new OrdemServico();
		ordensServicos = new ArrayList<OrdemServico>();

		funcionarioSelecionado = new Funcionario();
		servicoSelecionado = new Servico();
		servicosSelecionados = new LinkedList<Servico>();

		cpfConsulta = "";
		nomeConsulta = "";
		cnpjConsulta = "";
		nomeFantasiaConsulta = "";
		numeroOSConsulta = 0L;
		statusServicoConsulta = EnumStatusServico.EXECUCAO;

		return "sucess";
	}

	public void listarOrdensServico() throws DadosInvalidosException {
		try {
			if (!ReisLavajatoUtil.ehVazio(cpfConsulta) || !ReisLavajatoUtil.ehVazio(nomeConsulta)) {
				ordensServicos = context.getBean(OrdemServicoNeg.class).listarPorCpfOuNome(Numero.removerFormatoCPF(cpfConsulta), nomeConsulta);
			} else if (!ReisLavajatoUtil.ehVazio(cnpjConsulta) || !ReisLavajatoUtil.ehVazio(nomeFantasiaConsulta)) {
				ordensServicos = context.getBean(OrdemServicoNeg.class).listarPorCnpjOuNomeFantasia(Numero.removerFormatoCNPJ(cnpjConsulta), nomeFantasiaConsulta);
			} else {
				ordensServicos = context.getBean(OrdemServicoNeg.class).listarPorStatus(statusServicoConsulta);
			}
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			this.setarServicos(ordemServico);

			context.getBean(OrdemServicoNeg.class).incluir(ordemServico);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			ordemServico = (OrdemServico) evento.getComponent().getAttributes().get("registroSelecionado");
			context.getBean(OrdemServicoNeg.class).excluir(ordemServico);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			ordemServico = (OrdemServico) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
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

	// private void finalizar() throws DadosInvalidosException {
	// try {
	// this.calcularValorTotalServico(movimento);
	// } catch (RuntimeException erro) {
	// addMensagemErroFatal(erro);
	// }
	// }

	public String adicionarServico() {
		if (servicosSelecionados.getFirst() == null) {
			servicosSelecionados.removeFirst();
		}

		if (servicosSelecionados.contains(servicoSelecionado)) {
			addMensagemAviso("Serviço já selecionado!");
		} else {
			servicoSelecionado.setFuncionario(funcionarioSelecionado);
			servicosSelecionados.add(servicoSelecionado);
			servicoSelecionado = new Servico();
			funcionarioSelecionado = new Funcionario();
		}

		return "";
	}

	private void setarServicos(OrdemServico ordemServico) {
		ordemServico.getServicos().addAll(servicosSelecionados);
		ordemServico.setServico(null);
	}

	public List<Cliente> getClientes() throws DadosInvalidosException {
		try {
			return context.getBean(ClienteNeg.class).listarPorTipoPessoa(EnumTipoPessoa.PF);
		} catch (DadosInvalidosException e) {
			addMensagemErro(msgErro + ", não foi possível listar os Clientes!");
		}
		return null;
	}

	public List<Veiculo> getModelosVeiculo() throws DadosInvalidosException {
		try {
			return context.getBean(VeiculoNeg.class).listarVeiculoPorMarca(ordemServico.getVeiculo().getMarca());
		} catch (DadosInvalidosException e) {
			addMensagemErro(msgErro + ", não foi possível listar os modelos de Veículos!");
		}
		return null;
	}

	public List<Servico> getServicos() throws DadosInvalidosException {
		try {
			return context.getBean(ServicoNeg.class).listar();
		} catch (DadosInvalidosException e) {
			addMensagemErro(msgErro + ", não foi possível listar os Serviços!");
		}
		return null;
	}

	public List<Funcionario> getFuncionarios() throws DadosInvalidosException {
		try {
			return context.getBean(FuncionarioNeg.class).listar();
		} catch (DadosInvalidosException e) {
			addMensagemErro(msgErro + ", não foi possível listar os Funcionários!");
		}
		return null;
	}

	// getters and setters

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<OrdemServico> getOrdensServicos() {
		return ordensServicos;
	}

	public void setOrdensServicos(List<OrdemServico> ordensServicos) {
		this.ordensServicos = ordensServicos;
	}

	public String getCpfConsulta() {
		return cpfConsulta;
	}

	public void setCpfConsulta(String cpfConsulta) {
		this.cpfConsulta = cpfConsulta;
	}

	public String getNomeConsulta() {
		return nomeConsulta;
	}

	public void setNomeConsulta(String nomeConsulta) {
		this.nomeConsulta = nomeConsulta;
	}

	public String getCnpjConsulta() {
		return cnpjConsulta;
	}

	public void setCnpjConsulta(String cnpjConsulta) {
		this.cnpjConsulta = cnpjConsulta;
	}

	public String getNomeFantasiaConsulta() {
		return nomeFantasiaConsulta;
	}

	public void setNomeFantasiaConsulta(String nomeFantasiaConsulta) {
		this.nomeFantasiaConsulta = nomeFantasiaConsulta;
	}

	public Long getNumeroOSConsulta() {
		return numeroOSConsulta;
	}

	public void setNumeroOSConsulta(Long numeroOSConsulta) {
		this.numeroOSConsulta = numeroOSConsulta;
	}

	public EnumStatusServico getStatusServicoConsulta() {
		return statusServicoConsulta;
	}

	public void setStatusServicoConsulta(EnumStatusServico statusServicoConsulta) {
		this.statusServicoConsulta = statusServicoConsulta;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Servico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(Servico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}

	public LinkedList<Servico> getServicOosSelecionados() {
		return servicosSelecionados;
	}

	public void setServicosSelecionados(LinkedList<Servico> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	public LinkedList<Servico> getServicosSelecionados() {
		return servicosSelecionados;
	}

}
