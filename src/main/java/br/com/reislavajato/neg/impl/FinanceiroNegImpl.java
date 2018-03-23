/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.FinanceiroDao;
import br.com.reislavajato.entidade.Financeiro;
import br.com.reislavajato.neg.FinanceiroNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class FinanceiroNegImpl extends NegocioGenerico<Financeiro> implements FinanceiroNeg {

	@Autowired
	public FinanceiroNegImpl(FinanceiroDao persistencia) {
		super(persistencia);
	}
}
