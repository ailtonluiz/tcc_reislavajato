/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.OrdemServicoDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.OrdemServicoAuditoria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @15:40:22
 */
@Repository
public class OrdemServicoDaoJpaAuditoria extends PersistenciaJpa<OrdemServicoAuditoria>
		implements OrdemServicoDaoAuditoria {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrdemServicoDaoJpaAuditoria() {
		super(OrdemServicoAuditoria.class);
	}
}
