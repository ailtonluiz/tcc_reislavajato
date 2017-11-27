/**
 * 
 */
package br.com.reislavajato.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.reislavajato.entidade.Cidade;
import br.com.reislavajato.util.HibernateUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public class CidadeDao extends GenericDao<Cidade> {
	
	public List<Cidade> buscarPorEstado(Long estadoCodigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", estadoCodigo));
			consulta.addOrder(Order.asc("nome"));
			@SuppressWarnings("unchecked")
			List<Cidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}

}
