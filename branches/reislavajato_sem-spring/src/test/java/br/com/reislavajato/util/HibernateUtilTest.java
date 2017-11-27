/**
 * 
 */
package br.com.reislavajato.util;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();

	}

}
