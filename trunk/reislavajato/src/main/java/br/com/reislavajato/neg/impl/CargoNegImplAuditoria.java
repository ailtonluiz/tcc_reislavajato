/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.CargoDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.CargoAuditoria;
import br.com.reislavajato.neg.CargoNegAudioria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @11:02:39
 */
@Service
public class CargoNegImplAuditoria extends NegocioGenerico<CargoAuditoria> implements CargoNegAudioria {

	@Autowired
	public CargoNegImplAuditoria(CargoDaoAuditoria persistencia) {
		super(persistencia);
	}
}
