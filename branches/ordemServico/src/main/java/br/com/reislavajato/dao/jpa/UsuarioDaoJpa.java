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

import br.com.reislavajato.dao.UsuarioDao;
import br.com.reislavajato.entidade.Usuario;
import br.com.reislavajato.excessao.DadosInvalidosException;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class UsuarioDaoJpa extends PersistenciaJpa<Usuario> implements UsuarioDao {
	private static final long serialVersionUID = 1L;

	public UsuarioDaoJpa() {
		super(Usuario.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public Usuario autenticar(String username, String password) throws DadosInvalidosException {
		try {
			Query query = em.createQuery(
					"select distinct u from Usuario u where u.username = :username and u.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			throw new DadosInvalidosException(e);
		}
	}

	// public Usuario autenticar(String username, String senha) throws
	// DadosInvalidosException {
	// Session sessao = HibernateUtil.getSessionFactory().openSession();
	//
	// try {
	// Criteria consulta = sessao.createCriteria(Usuario.class);
	// consulta.add(Restrictions.eq("username", username));
	//
	// SimpleHash hash = new SimpleHash("md5", senha);
	// consulta.add(Restrictions.eq("senha", hash.toHex()));
	//
	// Usuario resultado = (Usuario) consulta.uniqueResult();
	//
	// return resultado;
	//
	// } catch (RuntimeException erro) {
	// throw erro;
	// } finally {
	// sessao.close();
	// }
	//
	// }

	// @Override
	// public void incluir(Usuario usuario) {
	// Session sessao = HibernateUtil.getSessionFactory().openSession();
	// Transaction transacao = null;
	//
	// try {
	// transacao = sessao.beginTransaction();
	// sessao.save(usuario);
	//
	// SimpleHash hash = new SimpleHash("md5", usuario.getPassword());
	// usuario.setPassword(hash.toHex());
	// transacao.commit();
	// } catch (RuntimeException erro) {
	// if (transacao != null) {
	// transacao.rollback();
	// }
	// throw erro;
	// } finally {
	// sessao.close();
	// }
	// }

	public List<Usuario> listar() throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select u from Usuario u");
			// query.getResultList();
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}
