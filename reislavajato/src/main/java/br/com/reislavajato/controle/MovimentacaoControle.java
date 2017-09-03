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

import br.com.reislavajato.dao.ClienteDao;
import br.com.reislavajato.dao.ServicoDao;
import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.entidade.Veiculo;

/**
 * @Criado por: ailtonluiz
 * @Data: 14 de ago de 2017
 */
@SuppressWarnings({  "serial" })
@ManagedBean
@ViewScoped
public class MovimentacaoControle implements Serializable {
	UsuarioDao usuarioDao = new UsuarioDao();
	ClienteDao clienteDao = new ClienteDao();
	VeiculoDao veiculoDao = new VeiculoDao();
	ServicoDao servicoDao = new ServicoDao();

	private List<Usuario> usuarios;
	private List<Cliente> clientes;
	private List<Veiculo> veiculos;
	private List<Servico> servicos;

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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

	@PostConstruct
	public void listar() {

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
