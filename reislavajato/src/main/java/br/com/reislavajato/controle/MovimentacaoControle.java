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
import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.dao.ServicoDao;
import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Cadastro;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.ItemMovimento;
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
	private UsuarioDao usuarioDao = new UsuarioDao();
	private CadastroDao cadastroDao = new CadastroDao();
	private VeiculoDao veiculoDao = new VeiculoDao();
	private ServicoDao servicoDao = new ServicoDao();
	private FuncionarioDao funcionarioDao = new FuncionarioDao();

	private Funcionario funcionario;
	private Movimento movimento;
	private ItemMovimento itemMovimento;
	private List<Usuario> usuarios;
	private List<Cadastro> cadastros;
	private List<Veiculo> veiculos;
	private List<Servico> servicos;
	private List<Funcionario> funcionarios;

	@PostConstruct
	public void listar() {

		veiculos = veiculoDao.listar("modelo");
		cadastros = cadastroDao.listar("razaoSocial");
		servicos = servicoDao.listar();
		funcionarios = funcionarioDao.listar();

	}

	public void adicionar() {

	}

	public void remover() {

	}

	public void novo() {

	}

	public void salvar() {

	}

	public void editar(ActionEvent evento) {

	}

	public void excluir(ActionEvent evento) {

	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public ItemMovimento getItemMovimento() {
		return itemMovimento;
	}

	public void setItemMovimento(ItemMovimento itemMovimento) {
		this.itemMovimento = itemMovimento;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
