/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.MovimentoDao;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MovimentoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class MovimentoNegImpl extends NegocioGenerico<Movimento> implements MovimentoNeg {

	@Autowired
	public MovimentoNegImpl(MovimentoDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Movimento> listarPorStatusServico(EnumStatusServico statusServico) throws DadosInvalidosException {
		return ((MovimentoDao) persistencia).listarPorStatusServico(statusServico);
	}
}
