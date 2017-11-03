package br.com.reislavajato.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.reislavajato.entidade.Pessoa;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public class PessoaDao extends GenericDao<Pessoa> {

//	@PersistenceContext(unitName = "sisgeaPersistencia")
//	private EntityManager em;
//
//	public List<Pessoa> listarPorCpfOuNome(Long cpf, String nome) throws Exception {
//		try {
//			String jpaql = "select pessoa from Pessoa pessoa where ";
//
//			if (cpf > 0L) {
//				jpaql += "pessoa.pessoaFisica.cpf = :cpf ";
//			} else {
//				jpaql += "pessoa.pessoaFisica.nome like :nome ";
//			}
//
//			Query query = em.createQuery(jpaql);
//
//			if (cpf > 0L) {
//				query.setParameter("cpf", cpf);
//			} else {
//				query.setParameter("nome", nome + "%");
//			}
//			
//			@SuppressWarnings("unchecked")
//			List<Pessoa> pessoas = query.getResultList();
//
//			return pessoas;
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	public List<Pessoa> listarPorCnpjOuNome(Long cnpj, String nomeFantasia) throws Exception {
//		try {
//			String jpaql = "select pessoa from Pessoa pessoa where ";
//
//			if (cnpj > 0L) {
//				jpaql += "pessoa.pessoaJuridica.cnpj = :cnpj ";
//			} else {
//				jpaql += "pessoa.pessoaJuridica.nomeFantasia = :nomeFantasia ";
//			}
//
//			Query query = em.createQuery(jpaql);
//
//			if (cnpj > 0L) {
//				query.setParameter("cnpj", cnpj);
//			} else {
//				query.setParameter("nomeFantasia", "%" + nomeFantasia.toUpperCase() + "%");
//			}
//
//			@SuppressWarnings("unchecked")
//			List<Pessoa> pessoas = query.getResultList();
//			return pessoas;
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	public Pessoa consultarPorEmail(String email) throws Exception {
//		try {
//			Query query = em.createQuery("select entidade from Pessoa entidade where entidade.email = :email");
//			query.setParameter("email", email);
//			return (Pessoa) query.getSingleResult();
//		} catch (NoResultException e) {
//			throw new NoResultException(e.getMessage());
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}

}
