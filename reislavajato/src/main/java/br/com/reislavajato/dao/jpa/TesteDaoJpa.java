/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.TesteDao;
import br.com.reislavajato.entidade.Teste;

/**
 * @Criado por: ailto
 * @Data: 21 de nov de 2017
 */
@Repository
public class TesteDaoJpa extends PersistenciaJpa<Teste> implements TesteDao {

	public TesteDaoJpa(){
		super(Teste.class);
	}
}
