package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.ItemMovimentoDao;
import br.com.reislavajato.entidade.ItemMovimento;
import br.com.reislavajato.neg.ItemMovimentoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class ItemMovimentoNegImpl extends NegocioGenerico<ItemMovimento> implements ItemMovimentoNeg {

	@Autowired
	public ItemMovimentoNegImpl(ItemMovimentoDao persistencia) {
		super(persistencia);
	}
}
