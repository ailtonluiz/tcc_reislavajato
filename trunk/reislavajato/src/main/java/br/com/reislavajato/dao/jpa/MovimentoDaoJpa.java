/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.MovimentoDao;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class MovimentoDaoJpa extends PersistenciaJpa<Movimento> implements MovimentoDao {
	private static final long serialVersionUID = 1L;

	public MovimentoDaoJpa() {
		super(Movimento.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	@Override
	public List<Movimento> listarPorStatusServico(EnumStatusServico statusServico) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select m from Movimento m where m.statusServico = :statusServico");
			query.setParameter("statusServico", statusServico);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}
