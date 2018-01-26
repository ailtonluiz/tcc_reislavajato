/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.CargoDao;
import br.com.reislavajato.entidade.Cargo;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@SuppressWarnings("serial")
@Repository
public class CargoDaoJpa extends PersistenciaJpa<Cargo> implements CargoDao {

	public CargoDaoJpa() {
		super(Cargo.class);
	}
}
