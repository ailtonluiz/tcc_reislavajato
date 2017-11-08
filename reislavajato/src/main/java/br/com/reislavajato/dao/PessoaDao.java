package br.com.reislavajato.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.reislavajato.entidade.Pessoa;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public class PessoaDao extends GenericDao<Pessoa> {

	// @PersistenceContext(unitName = "ReisLavajato")
	// private EntityManager em;

	// protected void setUp() throws Exception {
	// em = (EntityManager) Persistence.createEntityManagerFactory("ReisLavajato");
	// }

	// public EntityManager getEntityManager() {
	// return em;
	// }

	// public List<Pessoa> listarPorCpfOuNome(String cpf, String nome) throws
	// Exception {
	// Session sessao = HibernateUtil.getSessionFactory().openSession();
	// try {
	// @SuppressWarnings("deprecation")
	// Criteria crit = sessao.createCriteria(Pessoa.class);
	// if (cpf.length() > 0) {
	// crit.add(Restrictions.eq("pessoaFisica.cpf", cpf));
	// } else {
	// crit.add(Restrictions.eq("pessoaFisica.nome", nome));
	// }
	// crit.addOrder(Order.asc("nome"));
	// List<Pessoa> resultado = crit.list();
	//
	// return resultado;
	// } catch (RuntimeException erro) {
	// throw erro;
	// } finally {
	// sessao.close();
	// }
	// }

	public List<Pessoa> listarPorCpfOuNome(String cpf, String nome) throws Exception {
		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReisLavajato");
			EntityManager em = emf.createEntityManager();

			// em.getTransaction().begin();
			// Employee employee = new Employee();
			// employee.setName("Chandan");
			// System.out.println("COMIITING");
			// em.persist(employee);
			// em.getTransaction().commit();

			String jpaql = "select pessoa from Pessoa pessoa where ";

			if (cpf.length() > 0) {
				jpaql += "pessoa.pessoaFisica.cpf = :cpf ";
			} else {
				jpaql += "pessoa.pessoaFisica.nome like :nome ";
			}

			Query query = em.createQuery(jpaql);

			if (cpf.length() > 0) {
				query.setParameter("cpf", cpf);
			} else {
				query.setParameter("nome", nome + "%");
			}

			@SuppressWarnings("unchecked")
			List<Pessoa> pessoas = query.getResultList();

			return pessoas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Pessoa> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws Exception {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReisLavajato");
			EntityManager em = emf.createEntityManager();

			String jpaql = "select pessoa from Pessoa pessoa where ";

			if (cnpj.length() > 0L) {
				jpaql += "pessoa.pessoaJuridica.cnpj = :cnpj ";
			} else {
				jpaql += "pessoa.pessoaJuridica.nomeFantasia = :nomeFantasia ";
			}

			Query query = em.createQuery(jpaql);

			if (cnpj.length() > 0L) {
				query.setParameter("cnpj", cnpj);
			} else {
				query.setParameter("nomeFantasia", "%" + nomeFantasia.toUpperCase() + "%");
			}

			@SuppressWarnings("unchecked")
			List<Pessoa> pessoas = query.getResultList();
			return pessoas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Pessoa consultarPorEmail(String email) throws Exception {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReisLavajato");
			EntityManager em = emf.createEntityManager();

			Query query = em.createQuery("select entidade from Pessoa entidade where entidade.email = :email");
			query.setParameter("email", email);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
