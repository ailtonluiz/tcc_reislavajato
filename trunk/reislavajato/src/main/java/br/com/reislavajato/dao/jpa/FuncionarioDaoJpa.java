/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.entidade.Funcionario;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class FuncionarioDaoJpa extends PersistenciaJpa<Funcionario> implements FuncionarioDao {

	public FuncionarioDaoJpa() {
		super(Funcionario.class);
	}
}
