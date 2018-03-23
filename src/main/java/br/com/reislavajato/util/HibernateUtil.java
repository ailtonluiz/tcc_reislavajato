
package br.com.reislavajato.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.ServiceRegistry;

/**
 * @Criado por: ailtonluiz
 * @Data: 12 de ago de 2017
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Connection getConexao() {
		Session sessao = sessionFactory.openSession();

		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {

			@Override
			public Connection execute(Connection conn) throws SQLException {

				return conn;
			}
		});
		return conexao;
	}

	private static SessionFactory buildSessionFactory() {
		try {
			// Cria um fabrica de sessão à partir do hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();

			@SuppressWarnings("unused")
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			return sessionFactory;

		} catch (Throwable ex) {
			// Exibe uma mensagem de erro
			System.err.println("Falha ao tentar criar fábrica de sessão." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
