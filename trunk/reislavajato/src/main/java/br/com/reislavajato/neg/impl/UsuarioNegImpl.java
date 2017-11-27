/**
 * 
 */
package br.com.reislavajato.neg.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.UsuarioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class UsuarioNegImpl extends NegocioGenerico<Usuario> implements UsuarioNeg {

	@Autowired
	public UsuarioNegImpl(UsuarioDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public Usuario autenticar(String username, String senha) throws DadosInvalidosException {
		return ((UsuarioDao) persistencia).autenticar(username, senha);
	}
}
