/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Usuario autenticar(String username, String password) throws DadosInvalidosException {
		return ((UsuarioDao) persistencia).autenticar(username, password);
	}

	@Transactional
	public List<Usuario> listar() throws DadosInvalidosException {
		return ((UsuarioDao) persistencia).listar();
	}
}