package br.com.caelum.leilao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("leilao");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public void close() {
		factory.close();
	}
}