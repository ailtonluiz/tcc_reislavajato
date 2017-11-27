/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.neg.VeiculoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class VeiculoNegImpl extends NegocioGenerico<Veiculo> implements VeiculoNeg {

	@Autowired
	public VeiculoNegImpl(VeiculoDao persistencia) {
		super(persistencia);
	}
}
