package br.com.reislavajato.neg.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reislavajato.dao.MunicipioDao;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.enumeradores.EnumUf;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.MunicipioNeg;

@Service
public class MunicipioNegImpl extends NegocioGenerico<Municipio> implements MunicipioNeg {

	@Autowired
	public MunicipioNegImpl(MunicipioDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Municipio> listarPorUf(EnumUf uf) throws DadosInvalidosException {
		return ((MunicipioDao) persistencia).listarPorUf(uf);
	}

}
