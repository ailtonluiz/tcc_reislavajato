package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;
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

	public OrdemServicoControle() throws DadosInvalidosException {
		this.novo();
	}

	@Override
	@PostConstruct
	public String novo() {
		ordemServico = new OrdemServico();
		ordensServicos = new ArrayList<OrdemServico>();
		cpfConsulta = "";
		nomeConsulta = "";
		cnpjConsulta = "";
		nomeFantasiaConsulta = "";
		numeroOSConsulta = 0L;
		statusServicoConsulta = EnumStatusServico.EXECUCAO;
		return "sucesso";
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
			// context.getBean(OrdemServicoNeg.class).incluir(ordemServico);
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

	public List<Cliente> getClientes() throws DadosInvalidosException {
		if (ordemServico.getCliente().getPessoa().getTipoPessoa().equals(EnumTipoPessoa.PF)) {
			return context.getBean(ClienteNeg.class).listarPorTipoPessoa(EnumTipoPessoa.PF);
		} else {
			return context.getBean(ClienteNeg.class).listarPorTipoPessoa(EnumTipoPessoa.PJ);
		}
	}

	public List<Veiculo> getModelosVeiculo() throws DadosInvalidosException {
		return context.getBean(VeiculoNeg.class).listarVeiculoPorMarca(ordemServico.getVeiculo().getMarca());
	}

	public List<Servico> getServicos() throws DadosInvalidosException {
		return context.getBean(ServicoNeg.class).listar();
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Servico Edited", ((Servico) event.getObject()).getServicoId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Servico) event.getObject()).getServicoId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
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

}
