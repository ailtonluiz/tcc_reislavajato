package br.com.reislavajato.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.MunicipioDao;
import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.enumeradores.EnumUf;
import br.com.reislavajato.excessao.DadosInvalidosException;

@Repository
public class MunicipioDaoJpa extends PersistenciaJpa<Municipio> implements MunicipioDao {
	private static final long serialVersionUID = 408564091923202102L;

	public MunicipioDaoJpa() {
		super(Municipio.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<Municipio> listarPorUf(EnumUf uf) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select m from Municipio m where m.uf = :uf");
			query.setParameter("uf", uf);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<Municipio> listarPorNome(String nome) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select m from Municipio m where m.nome like :nome");
			query.setParameter("nome", nome);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<Municipio> listarPorNomeeUF(String nome, EnumUf uf) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select m from Municipio m where m.nome like :nome and m.uf = :uf");
			query.setParameter("nome", nome);
			query.setParameter("uf", uf);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}
