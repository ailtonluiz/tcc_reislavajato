package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.entidade.PessoaFisica;
import br.com.reislavajato.entidade.PessoaJuridica;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MunicipioNeg;
import br.com.reislavajato.neg.PessoaNeg;
import br.com.reislavajato.util.ClienteWs;
import br.com.reislavajato.util.Numero;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("pessoaControle")
public class PessoaControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private PessoaNeg pessoaNeg = context.getBean(PessoaNeg.class);
	private MunicipioNeg municipioNeg = context.getBean(MunicipioNeg.class);

	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	public PessoaControle() {
		this.novo();
	}

	public List<Municipio> getMunicipios() throws DadosInvalidosException {

		if (pessoa.getEndereco().getMunicipio().getCodigo() == null || pessoa.getEndereco().getMunicipio().getCodigo() == 0L) {
			return municipioNeg.listarPorUf(pessoa.getEndereco().getMunicipio().getUf());
		} else {
			return municipioNeg.listarPorNome(pessoa.getEndereco().getMunicipio().getNome());
		}

	}

	public void buscarCep() throws DadosInvalidosException {
		try {
			pessoa.setEndereco(ClienteWs.getEnderecoPorCep(Numero.removerFormatoCEP(pessoa.getEndereco().getCep())));
		} catch (Exception e) {
			addMensagemErroFatal(e);
		}
	}

	public void listarPorCpfOuNome() {
		try {
			if (pessoa.getPessoaFisica().getCpf().length() > 0 || !ReisLavajatoUtil.ehVazio(pessoa.getPessoaFisica().getNome())) {
				pessoas = pessoaNeg.listarPorCpfOuNome(Numero.removerFormatoCPF(pessoa.getPessoaFisica().getCpf()), pessoa.getPessoaFisica().getNome());
			} else if (pessoa.getPessoaJuridica().getCnpj().length() > 0 || !ReisLavajatoUtil.ehVazio(pessoa.getPessoaJuridica().getNomeFantasia())) {
				pessoas = pessoaNeg.listarPorCnpjOuNome(Numero.removerFormatoCNPJ(pessoa.getPessoaJuridica().getCnpj()), pessoa.getPessoaJuridica().getNomeFantasia());
			}
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	@Override
	public String novo() {
		try {
			this.pessoa = new Pessoa();
			this.pessoa.setPessoaJuridica(new PessoaJuridica());
			this.pessoa.setPessoaFisica(new PessoaFisica());
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
		return "sucesso";
	}

	public void salvar() throws DadosInvalidosException {
		try {
			if (pessoa.getPessoaFisica().getCpf() != null && pessoa.getPessoaFisica().getCpf().toString().length() > 0) {
				pessoa.setPessoaJuridica(null);
			} else {
				pessoa.setPessoaFisica(null);
			}
			pessoaNeg.incluir(pessoa);
			this.novo();
			addMensagemInfo(msgIncluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void excluir(ActionEvent evento) throws DadosInvalidosException {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("registroSelecionado");
			pessoaNeg.excluir(pessoa);
			addMensagemInfo(msgExcluidoSucesso);
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
