package br.com.reislavajato.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@SuppressWarnings("serial")
public class EntityManagerFactory implements Serializable {
	public static final String PERSISTENCE_UNIT = "reislavajato";
	protected static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public static void setEntityManager(EntityManager entityManager) {
		EntityManagerFactory.entityManager = entityManager;
	}
}
