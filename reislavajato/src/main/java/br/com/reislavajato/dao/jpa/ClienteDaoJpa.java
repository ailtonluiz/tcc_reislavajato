/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.ClienteDao;
import br.com.reislavajato.entidade.Cliente;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class ClienteDaoJpa extends PersistenciaJpa<Cliente> implements ClienteDao {

	public ClienteDaoJpa() {
		super(Cliente.class);
	}
}
