package br.com.mercadinho.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MercadinhoUtil {

	private static EntityManagerFactory factory = null;

	static {
		if( factory == null) {
		factory = Persistence.createEntityManagerFactory("mercadinhoPU");
		
		}
		
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
