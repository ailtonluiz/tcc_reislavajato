/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.EmpresaDao;
import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.EmpresaNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 5 de set de 2017
 */
@Service
public class EmpresaNegImpl extends NegocioGenerico<Empresa> implements EmpresaNeg {

	@Autowired
	public EmpresaNegImpl(EmpresaDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Empresa> listarPorCnpjOuNomeFantasiaOuRazaoSocial(String cnpj, String nomeFantasia, String razaoSocial)
			throws DadosInvalidosException {
		return ((EmpresaDao) persistencia).listarPorCnpjOuNomeFantasiaOuRazaoSocial(cnpj, nomeFantasia, razaoSocial);
	}
}
