/**
 * 
 */
package br.com.reislavajato.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.reislavajato.entidade.Municipio;
import br.com.reislavajato.enumeradores.EnumUf;
import br.com.reislavajato.util.HibernateUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public class MunicipioDao extends GenericDao<Municipio> {
	public List<Municipio> listarPorUf(EnumUf uf) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			@SuppressWarnings("deprecation")
			Criteria crit = sessao.createCriteria(Municipio.class);
			crit.add(Restrictions.eq("uf", uf));
			crit.addOrder(Order.asc("nome"));
			List<Municipio> resultado = crit.list();
			
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}
}
