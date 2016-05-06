package br.com.caelum.leilao.util;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;

public class JPATest {
	
	protected EntityManager manager;
	protected JPAUtil jpaUtil = new JPAUtil();

	@Before
	public void abreEntityManager(){
		manager = jpaUtil.getEntityManager();
		manager.getTransaction().begin();
	}

	
	@After
	public void fechaManager(){
		manager.getTransaction().rollback();
		manager.close();
	}

}
