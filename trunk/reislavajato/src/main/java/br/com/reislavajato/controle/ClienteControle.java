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
import br.com.reislavajato.enumeradores.EnumPerfil;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.ClienteNeg;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.util.CepWs;
import br.com.reislavajato.util.Numero;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@Controller
public class ClienteControle extends ReisLavajatoControle implements Serializable {
	private static final long serialVersionUID = -7622599240385845530L;

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private ClienteNeg clienteNeg = context.getBean(ClienteNeg.class);
	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Cliente cliente;
	private List<Cliente> clientes;

	private String cpfConsulta;
	private String nomeConsulta;
	private String cnpjConsulta;
	private String nomeFantasiaConsulta;

	public ClienteControle() {
		this.novo();
	}

	@Override
	@PostConstruct
	public String novo() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();

		cpfConsulta = "";
		nomeConsulta = "";
		cnpjConsulta = "";
		nomeFantasiaConsulta = "";
		return "sucesso";
	}

	public void listarClientes() throws DadosInvalidosException {
		try {
			if (!ReisLavajatoUtil.ehVazio(cpfConsulta) || !ReisLavajatoUtil.ehVazio(nomeConsulta)) {
				clientes = clienteNeg.listarPorCpfOuNome(Numero.removerFormatoCPF(cpfConsulta), nomeConsulta);
			} else if (!ReisLavajatoUtil.ehVazio(cnpjConsulta) || !ReisLavajatoUtil.ehVazio(nomeFantasiaConsulta)) {
				clientes = clienteNeg.listarPorCnpjOuNomeFantasia(Numero.removerFormatoCNPJ(cnpjConsulta), nomeFantasiaConsulta);
			}
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	private void setarAntesPersistir(Cliente cliente) throws DadosInvalidosException {
		if (cliente.getPessoa().getTipoPessoa().equals(EnumTipoPessoa.PF)) {
			cliente.getPessoa().setPessoaJuridica(null);
		} else {
			cliente.getPessoa().setPessoaFisica(null);
		}
		cliente.getPessoa().setPerfil(EnumPerfil.CLIENTE);
	}

	public void salvar() throws DadosInvalidosException {
		try {
			this.setarAntesPersistir(cliente);

			clienteNeg.alterar(cliente);
			novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("registroSelecionado");
			clienteNeg.excluir(cliente);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) throws DadosInvalidosException {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("registroSelecionado");
			if (cliente.getPessoa().getEndereco().getMunicipio() == null) {
				cliente.getPessoa().getEndereco().setMunicipio(new Municipio());
			}
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			cliente.getPessoa().setEndereco(CepWs.getEnderecoPorCep(Numero.removerFormatoCEP(cliente.getPessoa().getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {
		if (cliente.getPessoa().getEndereco().getMunicipio().getCodigo() == null || cliente.getPessoa().getEndereco().getMunicipio().getCodigo() == 0L) {
			return municipioNeg.listarPorUf(cliente.getPessoa().getEndereco().getMunicipio().getUf());
		} else {
			return municipioNeg.listarPorNome(cliente.getPessoa().getEndereco().getMunicipio().getNome());
		}
	}

	// getters and setters

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

}