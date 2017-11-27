/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.EmpresaDao;
import br.com.reislavajato.entidade.Empresa;

/**
 * @Criado por: ailtonluiz
 * @Data: 5 de set de 2017
 */
@Repository
public class EmpresaDaoJpa extends PersistenciaJpa<Empresa> implements EmpresaDao {

	public EmpresaDaoJpa() {
		super(Empresa.class);
	}
}
