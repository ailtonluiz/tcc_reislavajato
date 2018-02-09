package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;
import br.com.reislavajato.neg.OrdemServicoNeg;
import br.com.reislavajato.neg.ServicoNeg;
import br.com.reislavajato.neg.VeiculoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@Controller("ordemServicoControle")
public class OrdemServicoControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = 5234442544726838115L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private OrdemServicoNeg ordemServicoNeg = context.getBean(OrdemServicoNeg.class);
	private ClienteNeg clienteNeg = context.getBean(ClienteNeg.class);
	private VeiculoNeg veiculoNeg = context.getBean(VeiculoNeg.class);
	private ServicoNeg servicoNeg = context.getBean(ServicoNeg.class);

	private OrdemServico ordemServico;
	private List<OrdemServico> ordensServicos;

	public OrdemServicoControle() throws DadosInvalidosException {
		this.listar();
	}

	@Override
	@PostConstruct
	public String novo() {
		ordemServico = new OrdemServico();
		ordensServicos = new ArrayList<OrdemServico>();
		return "sucesso";
	}

	public void listar() throws DadosInvalidosException {
		try {
			ordensServicos = ordemServicoNeg.listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			ordemServicoNeg.incluir(ordemServico);
			novo();
			listar();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			ordemServico = (OrdemServico) evento.getComponent().getAttributes().get("registroSelecionado");
			ordemServicoNeg.excluir(ordemServico);
			listar();
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			ordemServico = (OrdemServico) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public List<Cliente> getClientes() throws DadosInvalidosException {
		if (ordemServico.getCliente().getPessoa().getTipoPessoa().equals(EnumTipoPessoa.PF)) {
			return clienteNeg.listarPorTipoPessoa(EnumTipoPessoa.PF);
		} else {
			return clienteNeg.listarPorTipoPessoa(EnumTipoPessoa.PJ);
		}
	}

	public List<Veiculo> getModelosVeiculo() throws DadosInvalidosException {
		return veiculoNeg.listarVeiculoPorMarca(ordemServico.getVeiculo().getMarca());
	}

	public List<Servico> getServicos() throws DadosInvalidosException {
		return servicoNeg.listar();
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

}
