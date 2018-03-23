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

import br.com.reislavajato.dao.OrdemServicoDao;
import br.com.reislavajato.entidade.OrdemServico;
import br.com.reislavajato.enumeradores.EnumStatusServico;
import br.com.reislavajato.excessao.DadosInvalidosException;
import br.com.reislavajato.util.ReisLavajatoUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class OrdemServicoDaoJpa extends PersistenciaJpa<OrdemServico> implements OrdemServicoDao {
	private static final long serialVersionUID = -7692192300947550093L;

	public OrdemServicoDaoJpa() {
		super(OrdemServico.class);
	}

	@PersistenceContext(unitName = "reisLavajato")
	@Qualifier(value = "managerEntityManagerFactory")
	private EntityManager em;

	public List<OrdemServico> listarPorStatus(EnumStatusServico statusServico) throws DadosInvalidosException {
		try {
			Query query = em.createQuery("select o from OrdemServico o where o.statusServico = :statusServico");
			query.setParameter("statusServico", statusServico);
			return query.getResultList();
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

	public List<OrdemServico> listarPorCpfOuNome(String cpf, String nome) throws DadosInvalidosException {
		try {
			String jpaql = "select o from OrdemServico o where ";

			if (!ReisLavajatoUtil.ehVazio(cpf)) {
				jpaql += "o.cliente.pessoa.pessoaFisica.cpf = :cpf ";
			} else {
				jpaql += "o.cliente.pessoa.pessoaFisica.nome like :nome ";
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

	public List<OrdemServico> listarPorCnpjOuNomeFantasia(String cnpj, String nomeFantasia) throws DadosInvalidosException {
		try {
			String jpaql = "select o from OrdemServico o where ";

			if (!ReisLavajatoUtil.ehVazio(cnpj)) {
				jpaql += "o.cliente.pessoa.pessoaJuridica.cnpj = :cnpj ";
			} else {
				jpaql += "o.cliente.pessoa.pessoaJuridica.nomeFantasia like :nomeFantasia ";
			}

			Query query = em.createQuery(jpaql);

			if (!ReisLavajatoUtil.ehVazio(cnpj)) {
				query.setParameter("cnpj", cnpj);
			} else {
				query.setParameter("nomeFantasia", "%" + nomeFantasia.toUpperCase() + "%");
			}

			List<OrdemServico> clientes = query.getResultList();
			return clientes;
		} catch (Exception e) {
			throw new DadosInvalidosException(e.getMessage());
		}
	}

}
