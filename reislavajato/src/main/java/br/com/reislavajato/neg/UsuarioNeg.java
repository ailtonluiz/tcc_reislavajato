/**
 * 
 */
package br.com.reislavajato.neg;

import java.util.List;

import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface UsuarioNeg extends Negocio<Usuario> {

	public Usuario autenticar(String username, String password) throws DadosInvalidosException;

	public List<Usuario> listar() throws DadosInvalidosException;
}
