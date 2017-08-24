package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.reislavajato.dao.CidadeDao;
import br.com.reislavajato.dao.EstadoDao;
import br.com.reislavajato.dao.PessoaDao;
import br.com.reislavajato.entidade.Cidade;
import br.com.reislavajato.entidade.Estado;
import br.com.reislavajato.entidade.Pessoa;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "deprecation", "serial" })
@ManagedBean
@ViewScoped
public class PessoaControle implements Serializable {

	PessoaDao pessoaDao = new PessoaDao();
	EstadoDao estadoDao = new EstadoDao();
	CidadeDao cidadeDao = new CidadeDao();

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private Estado estado;
	private List<Estado> estados;
	private List<Cidade> cidades;

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {
		try {
			pessoas = pessoaDao.listar();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar a(s) pessoa(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			estado = new Estado();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			pessoaDao.merge(pessoa);
			novo();
			pessoas = pessoaDao.listar("nome");
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("registroSelecionado");
			pessoaDao.excluir(pessoa);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("registroSelecionado");
			estado = pessoa.getCidade().getEstado();
			listar();
			popular();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void popular() {
		try {
			if (estado != null) {
				cidades = cidadeDao.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

}
