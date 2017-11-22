/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.TesteDao;
import br.com.reislavajato.entidade.Teste;
import br.com.reislavajato.neg.TesteNeg;

/**
 * @Criado por: ailto
 * @Data: 21 de nov de 2017
 */
@Service
public class TesteNegImpl extends NegocioGenerico<Teste> implements TesteNeg {

	public TesteNegImpl(TesteDao persistencia){
		super(persistencia);
	}
}
