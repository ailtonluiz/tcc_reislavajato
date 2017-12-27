/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.FuncaoCargoDao;
import br.com.reislavajato.entidade.FuncaoCargo;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class FuncaoCargoDaoJpa extends PersistenciaJpa<FuncaoCargo> implements FuncaoCargoDao {
	private static final long serialVersionUID = 1L;

	public FuncaoCargoDaoJpa() {
		super(FuncaoCargo.class);
	}
}
