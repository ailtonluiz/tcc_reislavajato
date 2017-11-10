/**
 * 
 */
package br.com.reislavajato.dao.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import br.com.reislavajato.dao.MovimentoDao;
import br.com.reislavajato.entidade.ItemMovimento;
import br.com.reislavajato.entidade.Movimento;
import br.com.reislavajato.util.HibernateUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
@Repository
public class MovimentoDaoJpa extends PersistenciaJpa<Movimento> implements MovimentoDao {

	public MovimentoDaoJpa() {
		super(Movimento.class);
	}

	public void salvar(Movimento movimento, List<ItemMovimento> itensMovimento) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(movimento);

			for (int posicao = 0; posicao < itensMovimento.size(); posicao++) {
				ItemMovimento itemMovimento = itensMovimento.get(posicao);
				itemMovimento.setMovimento(movimento);

				sessao.save(itemMovimento);
			}
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}

}
