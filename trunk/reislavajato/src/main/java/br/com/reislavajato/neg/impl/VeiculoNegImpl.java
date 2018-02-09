/**
 * 
 */
package br.com.reislavajato.neg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumMarca;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.neg.VeiculoNeg;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Service
public class VeiculoNegImpl extends NegocioGenerico<Veiculo> implements VeiculoNeg {

	@Autowired
	public VeiculoNegImpl(VeiculoDao persistencia) {
		super(persistencia);
	}

	@Transactional
	public List<Veiculo> listarVeiculoPorMarca(EnumMarca marca) throws DadosInvalidosException {
		return ((VeiculoDao) persistencia).listarVeiculoPorMarca(marca);
	}
}
