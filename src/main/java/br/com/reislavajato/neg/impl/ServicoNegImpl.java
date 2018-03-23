/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.ServicoDao;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.neg.ServicoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class ServicoNegImpl extends NegocioGenerico<Servico> implements ServicoNeg {

	@Autowired
	public ServicoNegImpl(ServicoDao persistencia) {
		super(persistencia);
	}
}
