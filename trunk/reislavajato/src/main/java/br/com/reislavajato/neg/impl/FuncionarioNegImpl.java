/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.neg.FuncionarioNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class FuncionarioNegImpl extends NegocioGenerico<Funcionario> implements FuncionarioNeg {

	@Autowired
	public FuncionarioNegImpl(FuncionarioDao persistencia) {
		super(persistencia);
	}
}
