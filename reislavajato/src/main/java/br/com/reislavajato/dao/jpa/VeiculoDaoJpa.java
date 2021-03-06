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

import br.com.reislavajato.dao.VeiculoDao;
import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.enumeradores.EnumMarca;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class VeiculoDaoJpa extends PersistenciaJpa<Veiculo> implements VeiculoDao {
	private static final long serialVersionUID = 1L;

	public VeiculoDaoJpa() {
		super(Veiculo.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<Veiculo> listarVeiculoPorMarca(EnumMarca marca) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select veiculo from Veiculo veiculo where veiculo.marca = :marca");
			query.setParameter("marca", marca);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}
}
