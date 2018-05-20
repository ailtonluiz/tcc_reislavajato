/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.FinanceiroDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.FinanceiroAuditoria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @13:27:22
 */
@Repository
public class FinanceiroDaoJpaAuditoria extends PersistenciaJpa<FinanceiroAuditoria> implements FinanceiroDaoAuditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinanceiroDaoJpaAuditoria() {
		super(FinanceiroAuditoria.class);
	}
}
