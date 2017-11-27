/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.MarcaDao;
import br.com.reislavajato.entidade.Marca;
import br.com.reislavajato.neg.MarcaNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class MarcaNegImpl extends NegocioGenerico<Marca> implements MarcaNeg {

	@Autowired
	public MarcaNegImpl(MarcaDao persistencia) {
		super(persistencia);
	}
}
