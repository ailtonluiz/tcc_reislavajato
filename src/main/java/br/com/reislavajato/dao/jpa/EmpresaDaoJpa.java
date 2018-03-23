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

import br.com.reislavajato.dao.EmpresaDao;
import br.com.reislavajato.entidade.Empresa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de fevereiro de 2018
 */
@Repository
public class EmpresaDaoJpa extends PersistenciaJpa<Empresa> implements EmpresaDao {
	private static final long serialVersionUID = 4343505551216591569L;

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Empresa> listarPorCnpjOuNomeFantasiaOuRazaoSocial(String cnpj, String nomeFantasia, String razaoSocial)
			throws DadosInvalidosException {
		try {
			String jpaql = "select empresa from Empresa empresa where ";
			if (!ReisLavajatoUtil.ehVazio(cnpj)) {
				jpaql += "empresa.pessoaJuridica.cnpj = :cnpj ";
			} else {
				jpaql += "empresa.pessoaJuridica.razaoSocial like :razaoSocial ";
			}
			Query query = em.createQuery(jpaql);

			if (!ReisLavajatoUtil.ehVazio(cnpj)) {
				query.setParameter("cnpj", cnpj);
			} else {
				query.setParameter("nome", razaoSocial + "%");
			}
			return query.getResultList();

		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}

	}

}
