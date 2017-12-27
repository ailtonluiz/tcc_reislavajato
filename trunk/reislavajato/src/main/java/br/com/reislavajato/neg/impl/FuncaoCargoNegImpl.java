/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.FuncaoCargoDao;
import br.com.reislavajato.entidade.FuncaoCargo;
import br.com.reislavajato.neg.FuncaoCargoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class FuncaoCargoNegImpl extends NegocioGenerico<FuncaoCargo> implements FuncaoCargoNeg {

	@Autowired
	public FuncaoCargoNegImpl(FuncaoCargoDao persistencia) {
		super(persistencia);
	}
}
