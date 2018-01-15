/**
 * 
 */
package br.com.reislavajato.neg;

import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public interface UsuarioNeg extends Negocio<Usuario> {

	public Usuario autenticar(String username, String passowrd) throws DadosInvalidosException;

}
