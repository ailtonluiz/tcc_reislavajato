package br.com.reislavajato.controle;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.dao.MunicipioDao;
import br.com.reislavajato.entidade.Endereco;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.entidade.PessoaFisica;
import br.com.reislavajato.entidade.PessoaJuridica;
import br.com.reislavajato.entidade.Telefone;
import br.com.reislavajato.neg.PessoaNeg;
import br.com.reislavajato.util.HibernateUtil;
import br.com.reislavajato.util.ReisLavajatoUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@Controller("pessoaControle")
public class PessoaControle extends ReisLavajatoControle implements Serializable {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	private PessoaNeg pessoaNeg = context.getBean(PessoaNeg.class);

	private MunicipioDao municipioDao = new MunicipioDao();
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	private Boolean isRederiza = false;

	public List<Municipio> getMunicipios() {
		return municipioDao.listarPorUf(pessoa.getEndereco().getMunicipio().getUf());
	}

	public void listarPorCpfOuNome() {
		try {
			if (pessoa.getPessoaFisica().getCpf().length() > 0
					|| !ReisLavajatoUtil.ehVazio(pessoa.getPessoaFisica().getNome())) {
				pessoas = pessoaNeg.listarPorCpfOuNome(pessoa.getPessoaFisica().getCpf(),
						pessoa.getPessoaFisica().getNome());
			} else if (pessoa.getPessoaJuridica().getCnpj().length() > 0
					|| !ReisLavajatoUtil.ehVazio(pessoa.getPessoaJuridica().getNomeFantasia())) {
				pessoas = pessoaNeg.listarPorCnpjOuNome(pessoa.getPessoaJuridica().getCnpj(),
						pessoa.getPessoaJuridica().getNomeFantasia());
			}
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			pessoa.setPessoaJuridica(new PessoaJuridica());
			pessoa.setPessoaFisica(new PessoaFisica());
			pessoas = new ArrayList<Pessoa>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			if (pessoa.getPessoaFisica().getCpf() != null
					&& pessoa.getPessoaFisica().getCpf().toString().length() > 0) {
				pessoa.setPessoaJuridica(null);
			} else {
				pessoa.setPessoaFisica(null);
			}
			// pessoaNeg.incluir(pessoa);
			this.novo();
			// pessoas = pessoaNeg.listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("registroSelecionado");
			// pessoaNeg.excluir(pessoa);
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("registroSelecionado");
		} catch (RuntimeException erro) {
			addMensagemErroFatal(erro);
			erro.printStackTrace();
		}
	}

	public String limparEndereco() {
		pessoa.setEndereco(new Endereco());
		return null;
	}

	public String limparTelefone() {
		pessoa.setTelefone(new Telefone());
		return null;
	}

	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/pessoa.jasper");
			Map<String, Object> parametros = new HashMap<>();
			Connection conexao = HibernateUtil.getConexao();
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			// JasperPrintManager.printReport(relatorio, true);
			JasperViewer.viewReport(relatorio);

		} catch (JRException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Não foi possível gerar o relatório!");
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

	public Boolean getIsRederiza() {
		return isRederiza;
	}

	public void setIsRederiza(Boolean isRederiza) {
		this.isRederiza = isRederiza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.reislavajato.controle.ReisLavajatoControle#criarEntidade()
	 */
	@Override
	protected void criarEntidade() {
		// TODO Auto-generated method stub
	}
}
