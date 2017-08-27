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
import br.com.reislavajato.dao.CadastroDao;
import br.com.reislavajato.entidade.Cidade;
import br.com.reislavajato.entidade.Estado;
import br.com.reislavajato.entidade.Cadastro;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class CadastroControle implements Serializable {

	CadastroDao cadastroDao = new CadastroDao();
	EstadoDao estadoDao = new EstadoDao();
	CidadeDao cidadeDao = new CidadeDao();

	private Cadastro cadastro;
	private List<Cadastro> cadastros;
	private Estado estado;
	private List<Estado> estados;
	private List<Cidade> cidades;

	private String opcao;

	private Boolean isRederiza = false;

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
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

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Boolean getIsRederiza() {
		return isRederiza;
	}

	public void setIsRederiza(Boolean isRederiza) {
		this.isRederiza = isRederiza;
	}

	@PostConstruct
	public void listar() {
		try {
			cadastros = cadastroDao.listar();
			estados = estadoDao.listar("nome");
			cidades = new ArrayList<Cidade>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possível listar a(s) cadastro(s)!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			cadastro = new Cadastro();
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
			cadastroDao.merge(cadastro);
			novo();
			cadastros = cadastroDao.listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cadastro = (Cadastro) evento.getComponent().getAttributes().get("registroSelecionado");
			cadastroDao.excluir(cadastro);
			listar();
			Messages.addGlobalInfo("Operação realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Não foi possível realizar está operação!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cadastro = (Cadastro) evento.getComponent().getAttributes().get("registroSelecionado");
			estado = cadastro.getCidade().getEstado();
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
