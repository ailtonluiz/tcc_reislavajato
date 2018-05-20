/**
 * 
 */
package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.OrdemServicoDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.OrdemServicoAuditoria;
import br.com.reislavajato.neg.OrdemServicoNegAuditoria;

/**
 * @author Ailton Luiz Projeto: reislavajato @ @20 de mai de 2018 @15:43:39
 */
@Service
public class OrdemServicoNegImplAuditoria extends NegocioGenerico<OrdemServicoAuditoria>
		implements OrdemServicoNegAuditoria {
	@Autowired
	public OrdemServicoNegImplAuditoria(OrdemServicoDaoAuditoria persistencia) {
		super(persistencia);
	}
}
