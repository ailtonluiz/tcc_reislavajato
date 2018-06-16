package br.com.reislavajato.controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.entidade.OrdemServicoMovimento;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.entidade.auditoria.OrdemServicoAuditoria;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;
import br.com.reislavajato.neg.FuncionarioNeg;
import br.com.reislavajato.neg.OrdemServicoNeg;
import br.com.reislavajato.neg.OrdemServicoNegAuditoria;
import br.com.reislavajato.neg.ServicoNeg;
import br.com.reislavajato.neg.VeiculoNeg;
import br.com.reislavajato.util.Numero;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @author Ailton Luiz 14 de ago de 2017
 */
@Controller("ordemServicoControle")
public class OrdemServicoControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 5234442544726838115L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private OrdemServico ordemServico;
	private List<OrdemServico> ordensServicos;
	private Cliente cliente;
	private List<Cliente> clientes;
	private Veiculo veiculo;
	private List<Veiculo> veiculos;
	private OrdemServicoMovimento ordemServicoMovimento;
	private List<OrdemServicoMovimento> ordemServicoMovimentos;
	private List<Funcionario> funcionarios;
	private Funcionario funcionario;
	private OrdemServicoAuditoria ordemServicoAuditoria;
	private List<OrdemServicoAuditoria> ordemServicoAuditorias;

	private String cpfConsulta;
	private String nomeConsulta;
	private String cnpjConsulta;
	private String nomeFantasiaConsulta;
	private Long numeroOSConsulta;
	private EnumStatusServico statusServicoConsulta;
	private BigDecimal valorTotal;

	private Servico servicoSelecionado;
	private List<Servico> servicosSelecionados;

	private VeiculoNeg veiculoNeg = context.getBean(VeiculoNeg.class);

	@Override
	@PostConstruct
	public String novo() {
		ordemServico = new OrdemServico();
		ordensServicos = new ArrayList<OrdemServico>();

		servicoSelecionado = new Servico();
		servicosSelecionados = new ArrayList<Servico>();

		cpfConsulta = "";
		nomeConsulta = "";
		cnpjConsulta = "";
		nomeFantasiaConsulta = "";
		numeroOSConsulta = 0L;
		statusServicoConsulta = EnumStatusServico.EXECUCAO;

		valorTotal = new BigDecimal(0);
		return "sucess";
	}
	@PostConstruct
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
			if (ordemServico.getValorTotal().signum() == 0) {
				Messages.addGlobalError("Valor não pode ser 0");
				return;
			}
			// this.setarServicos(ordemServico, ordemServicoMovimento);
			calcularComissao(ordemServico);
			context.getBean(OrdemServicoNeg.class).alterar(ordemServico);
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

	public String adicionarServico() {

		return "";
	}

	private void setarServicos(OrdemServico ordemServico, OrdemServicoMovimento ordemServicoMovimento) {
		ordemServicoMovimento.getServicos().addAll(servicosSelecionados);
		ordemServico.getOrdemServicoId();
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

	public void calcularComissao(OrdemServico ordemServico) {
//		ordemServico.get
//		ordemServico.setValorTotal(new BigDecimal("50.00"));

	}

	public void listarOs() throws DadosInvalidosException {
		try {
			ordensServicos = context.getBean(OrdemServicoNeg.class).listar();

		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	@PostConstruct
	public void listar() throws DadosInvalidosException {
		try {
			veiculos = veiculoNeg.listar();
			ordensServicos = context.getBean(OrdemServicoNeg.class).listar();
			ordemServicoAuditorias = context.getBean(OrdemServicoNegAuditoria.class).listar();

		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public BigDecimal getValorTotal() {
		valorTotal = servicosSelecionados.stream().map(Servico::getValorServico).reduce(BigDecimal.ZERO, BigDecimal::add);
		ordemServico.setValorTotal(valorTotal);
		return valorTotal;
	}

	// getters and setters

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

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

	public Servico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(Servico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}

	public List<Servico> getServicosSelecionados() {
		return servicosSelecionados;
	}

	public void setServicosSelecionados(List<Servico> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public OrdemServicoMovimento getOrdemServicoMovimento() {
		return ordemServicoMovimento;
	}

	public void setOrdemServicoMovimento(OrdemServicoMovimento ordemServicoMovimento) {
		this.ordemServicoMovimento = ordemServicoMovimento;
	}

	public List<OrdemServicoMovimento> getOrdemServicoMovimentos() {
		return ordemServicoMovimentos;
	}

	public void setOrdemServicoMovimentos(List<OrdemServicoMovimento> ordemServicoMovimentos) {
		this.ordemServicoMovimentos = ordemServicoMovimentos;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public OrdemServicoAuditoria getOrdemServicoAuditoria() {
		return ordemServicoAuditoria;
	}

	public void setOrdemServicoAuditoria(OrdemServicoAuditoria ordemServicoAuditoria) {
		this.ordemServicoAuditoria = ordemServicoAuditoria;
	}

	public List<OrdemServicoAuditoria> getOrdemServicoAuditorias() {
		return ordemServicoAuditorias;
	}

	public void setOrdemServicoAuditorias(List<OrdemServicoAuditoria> ordemServicoAuditorias) {
		this.ordemServicoAuditorias = ordemServicoAuditorias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
