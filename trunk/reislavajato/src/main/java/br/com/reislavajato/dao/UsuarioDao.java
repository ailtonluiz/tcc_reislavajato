/**
 * 
 */
package br.com.reislavajato.dao;

import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface UsuarioDao extends Persistencia<Usuario> {

	public Usuario autenticar(String username, String senha) throws DadosInvalidosException;
}
