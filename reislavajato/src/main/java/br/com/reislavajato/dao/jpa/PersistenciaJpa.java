package br.com.reislavajato.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;

import br.com.reislavajato.dao.Persistencia;
import br.com.reislavajato.excessao.DadosInvalidosException;

public class PersistenciaJpa<E> implements Persistencia<E> {
	private static final long serialVersionUID = -3629350481384523952L;

	public Class<E> classeEntidade;

	public PersistenciaJpa() {
		this.classeEntidade = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public PersistenciaJpa(Class<E> classeEntidade) {
		this.classeEntidade = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public void alterar(E entidade) throws DadosInvalidosException {
		try {
			em.merge(entidade);
		} catch (EntityExistsException e) {
			throw new DadosInvalidosException("Não foi possível confirmar o registro. Provavelmente está duplicado");
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public E consultar(Object obj) throws DadosInvalidosException {
		try {
			return em.find(classeEntidade, obj);
		} catch (EntityNotFoundException e) {
			return null;
		} catch (Exception e) {
			throw new DadosInvalidosException(String.format("Problemas ao consultar o registro %s com id %s", classeEntidade.getSimpleName(), obj));
		}
	}

	public void excluir(E entidade) throws DadosInvalidosException {
		try {
			entidade = em.merge(entidade);
			em.remove(entidade);
			em.flush();
		} catch (EntityExistsException e) {
			throw new DadosInvalidosException("Não foi possível excluir o registro. Provavelmente está sendo utilizado");
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public void excluirPorId(Object id) throws DadosInvalidosException {
		try {
			E entidade = em.find(classeEntidade, id);
			em.remove(entidade);
			em.flush();
		} catch (EntityExistsException e) {
			throw new DadosInvalidosException("Não foi possível excluir o registro. Provavelmente está sendo utilizado");
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public void incluir(E entidade) throws DadosInvalidosException {
		try {
			em.persist(entidade);
		} catch (EntityExistsException e) {
			throw new DadosInvalidosException("Não foi possível confirmar o registro. Provavelmente está duplicado");
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<E> listar() throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select e from " + classeEntidade.getSimpleName() + " e");
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

	public List<E> alterar(List<E> entidades) throws DadosInvalidosException {
		List<E> resultado = new ArrayList<E>();
		for (E e : entidades) {
			resultado.add(em.merge(e));
		}
		return resultado;
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
