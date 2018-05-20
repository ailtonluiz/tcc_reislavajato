/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.FinanceiroDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.FinanceiroAuditoria;
import br.com.reislavajato.neg.FinanceiroNegAuditoria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @13:34:50
 */
@Service
public class FinanceiroNegImplAuditoria extends NegocioGenerico<FinanceiroAuditoria> implements FinanceiroNegAuditoria {

	@Autowired
	public FinanceiroNegImplAuditoria(FinanceiroDaoAuditoria persistenacia) {
		super(persistenacia);
	}
	
}
