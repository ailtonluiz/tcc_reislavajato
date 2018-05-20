package br.com.reislavajato.neg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.ServicoDaoAuditoria;
import br.com.reislavajato.entidade.auditoria.ServicoAuditoria;
import br.com.reislavajato.neg.ServicoNegAuditoria;

@Service
public class ServicoNegImplAuditoria extends NegocioGenerico<ServicoAuditoria> implements ServicoNegAuditoria {

	@Autowired
	public ServicoNegImplAuditoria(ServicoDaoAuditoria persistencia) {
		super(persistencia);
	}

}
