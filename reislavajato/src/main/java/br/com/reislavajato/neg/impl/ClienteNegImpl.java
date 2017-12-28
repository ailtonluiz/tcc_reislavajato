/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.ClienteDao;
import br.com.reislavajato.entidade.Cliente;
import br.com.reislavajato.neg.ClienteNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class ClienteNegImpl extends NegocioGenerico<Cliente> implements ClienteNeg {

	@Autowired
	public ClienteNegImpl(ClienteDao persistencia) {
		super(persistencia);
	}
}
