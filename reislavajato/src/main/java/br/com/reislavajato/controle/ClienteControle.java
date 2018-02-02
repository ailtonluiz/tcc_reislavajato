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
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumPerfil;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.neg.ServicoNeg;
import br.com.reislavajato.neg.VeiculoNeg;
import br.com.reislavajato.util.CepWs;
import br.com.reislavajato.util.Numero;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller
public class ClienteControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private ClienteNeg clienteNeg = context.getBean(ClienteNeg.class);
	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);
	private VeiculoNeg veiculoNeg = context.getBean(VeiculoNeg.class);
	private ServicoNeg servicoNeg = context.getBean(ServicoNeg.class);

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;

	public ClienteControle() throws DadosInvalidosException {
		this.listar();
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {
		if (cliente.getPessoa().getEndereco().getMunicipio().getCodigo() == null || cliente.getPessoa().getEndereco().getMunicipio().getCodigo() == 0L) {
			return municipioNeg.listarPorUf(cliente.getPessoa().getEndereco().getMunicipio().getUf());
		} else {
			return municipioNeg.listarPorNome(cliente.getPessoa().getEndereco().getMunicipio().getNome());
		}
	}

	public List<Veiculo> getModelosVeiculo() throws DadosInvalidosException {
		return veiculoNeg.listarVeiculoPorMarca(cliente.getVeiculo().getMarca());
	}

	public List<Servico> getServicos() throws DadosInvalidosException {
		return servicoNeg.listar();
	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			cliente.getPessoa().setEndereco(CepWs.getEnderecoPorCep(Numero.removerFormatoCEP(cliente.getPessoa().getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public void listar() throws DadosInvalidosException {
		try {
			clientes = clienteNeg.listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	@Override
	@PostConstruct
	public String novo() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
		return "sucesso";
	}

	private void setarAntesPersistir(Cliente cliente) throws DadosInvalidosException {
		cliente.getPessoa().setPerfil(EnumPerfil.CLIENTE);
		if (cliente.getPessoa().getTipoPessoa().equals(EnumTipoPessoa.PF)) {
			cliente.getPessoa().setPessoaJuridica(null);
		} else {
			cliente.getPessoa().setPessoaFisica(null);
		}
	}

	public void salvar() throws DadosInvalidosException {
		try {
			this.setarAntesPersistir(cliente);

			clienteNeg.alterar(cliente);
			novo();
			listar();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("registroSelecionado");
			clienteNeg.excluir(cliente);
			listar();
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("registroSelecionado");
			listar();
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void adicionarVeiculo() {
		cliente.setVeiculo(new Veiculo());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
