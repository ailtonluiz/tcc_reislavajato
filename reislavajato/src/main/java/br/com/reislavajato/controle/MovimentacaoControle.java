/**
 * 
 */
package br.com.reislavajato.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.reislavajato.dao.CadastroDao;
import br.com.reislavajato.dao.ServicoDao;
import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Cadastro;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.entidade.Veiculo;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({ "serial" })
@ManagedBean
@ViewScoped
public class MovimentacaoControle implements Serializable {
	UsuarioDao usuarioDao = new UsuarioDao();
	CadastroDao cadastroDao = new CadastroDao();
	VeiculoDao veiculoDao = new VeiculoDao();
	ServicoDao servicoDao = new ServicoDao();

	private Movimento movimento;

	private List<Usuario> usuarios;
	private List<Cadastro> cadastros;
	private List<Veiculo> veiculos;
	private List<Servico> servicos;

	/**
	 * @return the movimento
	 */
	public Movimento getMovimento() {
		return movimento;
	}

	/**
	 * @param movimento
	 *            the movimento to set
	 */
	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the cadastros
	 */
	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	/**
	 * @param cadastros
	 *            the cadastros to set
	 */
	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	/**
	 * @return the veiculos
	 */
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	/**
	 * @param veiculos
	 *            the veiculos to set
	 */
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	/**
	 * @return the servicos
	 */
	public List<Servico> getServicos() {
		return servicos;
	}

	/**
	 * @param servicos
	 *            the servicos to set
	 */
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@PostConstruct
	public void listar() {
		veiculos = veiculoDao.listar("modelo");
		cadastros = cadastroDao.listar("razaoSocial");
		servicos = servicoDao.listar();

	}

	public void novo() {

	}

	public void salvar() {

	}

	public void editar(ActionEvent evento) {

	}

	public void excluir(ActionEvent evento) {

	}
}
