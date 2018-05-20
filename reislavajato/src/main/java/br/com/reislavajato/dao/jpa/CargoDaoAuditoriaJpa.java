/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.CargoDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.CargoAuditoria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @10:57:47
 */
@SuppressWarnings("serial")
@Repository
public class CargoDaoAuditoriaJpa extends PersistenciaJpa<CargoAuditoria> implements CargoDaoAuditoria {

	public CargoDaoAuditoriaJpa() {

		super(CargoAuditoria.class);
	}

}
