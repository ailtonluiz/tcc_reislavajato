/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.CargoDao;
import br.com.reislavajato.entidade.Cargo;
import br.com.reislavajato.neg.CargoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class CargoNegImpl extends NegocioGenerico<Cargo> implements CargoNeg {

	@Autowired
	public CargoNegImpl(CargoDao persistencia) {
		super(persistencia);
	}
}
