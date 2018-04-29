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

import br.com.reislavajato.dao.FornecedorDao;
import br.com.reislavajato.entidade.Fornecedor;
import br.com.reislavajato.enumeradores.EnumTipoPessoa;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class FornecedorDaoJpa extends PersistenciaJpa<Fornecedor> implements FornecedorDao {
	private static final long serialVersionUID = 4343505551216591569L;

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<Fornecedor> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		try {
			String jpaql = "select fornecedor from Fornecedor fornecedor where ";

			if (!ReisLavajatoUtil.ehVazio(cpf)) {
				jpaql += "fornecedor.pessoa.pessoaFisica.cpf = :cpf ";
			} else {
				jpaql += "fornecedor.pessoa.pessoaFisica.nome like :nome ";
			}

			Query query = em.createQuery(jpaql);

			if (!ReisLavajatoUtil.ehVazio(cpf)) {
				query.setParameter("cpf", cpf);
			} else {
				query.setParameter("nome", nome + "%");
			}

			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<Fornecedor> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		try {
			String jpaql = "select fornecedor from Fornecedor fornecedor where ";

			if (!ReisLavajatoUtil.ehVazio(cnpj)) {
				jpaql += "fornecedor.pessoa.pessoaJuridica.cnpj = :cnpj ";
			} else {
				jpaql += "fornecedor.pessoa.pessoaJuridica.nomeFantasia like :nomeFantasia ";
			}

			Query query = em.createQuery(jpaql);

			if (!ReisLavajatoUtil.ehVazio(cnpj)) {
				query.setParameter("cnpj", cnpj);
			} else {
				query.setParameter("nomeFantasia", "%" + nomeFantasia.toUpperCase() + "%");
			}

			List<Fornecedor> fornecedores = query.getResultList();
			return fornecedores;
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<Fornecedor> listarPorTipoPessoa(EnumTipoPessoa tipoPessoa) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select c from Fornecedor c where c.pessoa.tipoPessoa = :tipoPessoa");
			query.setParameter("tipoPessoa", tipoPessoa);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}
