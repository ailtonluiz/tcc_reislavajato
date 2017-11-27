/**
 * 
 */
package br.com.reislavajato.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.reislavajato.entidade.Veiculo;
import br.com.reislavajato.util.HibernateUtil;

/**
 * @Criado por: ailtonluiz
 * @Data: 13 de ago de 2017
 */
public class VeiculoDao extends GenericDao<Veiculo> {

	public List<Veiculo> listarOrdenado() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(Veiculo.class);
			consulta.createAlias("marca", "m");
			consulta.addOrder(Order.asc("m.nome"));
			@SuppressWarnings("unchecked")
			List<Veiculo> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
