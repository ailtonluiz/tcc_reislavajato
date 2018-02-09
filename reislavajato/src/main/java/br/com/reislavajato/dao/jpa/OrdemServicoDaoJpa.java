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

import br.com.reislavajato.dao.OrdemServicoDao;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class OrdemServicoDaoJpa extends PersistenciaJpa<OrdemServico> implements OrdemServicoDao {
	private static final long serialVersionUID = -7692192300947550093L;

	public OrdemServicoDaoJpa() {
		super(OrdemServico.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<OrdemServico> listarPorStatus(EnumStatusServico statusServico) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select o from OrdemServico o where o.statusServico = :statusServico");
			query.setParameter("statusServico", statusServico);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}
}
