/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.ServicoDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.ServicoAuditoria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @14:56:35
 */
@Repository
public class ServicoDaoJpaAuditoria extends PersistenciaJpa<ServicoAuditoria> implements ServicoDaoAuditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicoDaoJpaAuditoria() {
		super(ServicoAuditoria.class);
	}

}
