/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.PessoaJuridicaDao;
import br.com.reislavajato.entidade.PessoaJuridica;
import br.com.reislavajato.neg.PessoaJuridicaNeg;

/**
 * @Criado por: Unint
 * @Data: 26 de jan de 2018
 */
@Service
public class PessoaJuridicaNegImpl extends NegocioGenerico<PessoaJuridica> implements PessoaJuridicaNeg {
	@Autowired
	public PessoaJuridicaNegImpl(PessoaJuridicaDao persistencia) {
		super(persistencia);
	}
}
