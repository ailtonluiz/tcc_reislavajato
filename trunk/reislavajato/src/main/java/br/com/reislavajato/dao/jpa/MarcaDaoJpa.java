/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.MarcaDao;
import br.com.reislavajato.entidade.Marca;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class MarcaDaoJpa extends PersistenciaJpa<Marca> implements MarcaDao {

	public MarcaDaoJpa() {
		super(Marca.class);
	}
}
