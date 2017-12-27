package br.com.reislavajato.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.FuncionarioDao;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.excessao.DadosInvalidosException;

@Repository
public class FuncionarioDaoJpa extends PersistenciaJpa<Funcionario> implements FuncionarioDao {
	private static final long serialVersionUID = 408564091923202102L;

	public FuncionarioDaoJpa() {
		super(Funcionario.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<Funcionario> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		try {
			String jpaql = "select funcionario from Funcionario funcionario where ";

			if (cpf.length() > 0) {
				jpaql += "funcionario.pessoa.pessoaFisica.cpf = :cpf ";
			} else {
				jpaql += "funcionario.pessoa.pessoaFisica.nome like :nome ";
			}

			Query query = em.createQuery(jpaql);

			if (cpf.length() > 0) {
				query.setParameter("cpf", cpf);
			} else {
				query.setParameter("nome", nome + "%");
			}

			List<Funcionario> funcionarios = query.getResultList();

			return funcionarios;
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<Funcionario> listarPorCnpjOuNome(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		try {
			String jpaql = "funcionario from Funcionario funcionario where ";

			if (cnpj.length() > 0L) {
				jpaql += "funcionario.pessoa.pessoaJuridica.cnpj = :cnpj ";
			} else {
				jpaql += "funcionario.pessoa.pessoaJuridica.nomeFantasia = :nomeFantasia ";
			}

			Query query = em.createQuery(jpaql);

			if (cnpj.length() > 0L) {
				query.setParameter("cnpj", cnpj);
			} else {
				query.setParameter("nomeFantasia", "%" + nomeFantasia.toUpperCase() + "%");
			}

			List<Funcionario> funcionarios = query.getResultList();
			return funcionarios;
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public Funcionario consultarPorEmail(String email) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select funcionario from Funcionario funcionario where funcionario.pessoa.email = :email");
			query.setParameter("email", email);
			return (Funcionario) query.getSingleResult();
		} catch (NoResultException e) {
			throw new DadosInvalidosException(e.getMessage());
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}
}