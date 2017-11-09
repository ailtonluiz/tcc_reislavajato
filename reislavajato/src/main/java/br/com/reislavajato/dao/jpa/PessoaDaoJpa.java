package br.com.reislavajato.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.PessoaDao;
import br.com.reislavajato.entidade.Pessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;

@Repository()
public class PessoaDaoJpa extends PersistenciaJpa<Pessoa> implements PessoaDao {
	private static final long serialVersionUID = 408564091923202102L;

	public PessoaDaoJpa() {
		super(Pessoa.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<Pessoa> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		try {
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
				// query.setParameter("nome", "%" + nome + "%");
				query.setParameter("nome", nome + "%");
			}

			List<Pessoa> pessoas = query.getResultList();

			return pessoas;
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<Pessoa> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		try {
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

			List<Pessoa> pessoas = query.getResultList();
			return pessoas;
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public Pessoa consultarPorEmail(String email) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select entidade from Pessoa entidade where entidade.email = :email");
			query.setParameter("email", email);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			throw new DadosInvalidosException(e.getMessage());
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}
}