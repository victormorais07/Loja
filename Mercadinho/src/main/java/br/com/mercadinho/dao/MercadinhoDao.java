package br.com.mercadinho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.mercadinho.util.MercadinhoUtil;

public class MercadinhoDao<T> {
	
	
	 public void salvar (T entidade) {
		 
		 EntityManager entityManager = MercadinhoUtil.getEntityManager();
		 EntityTransaction entityTransaction = entityManager.getTransaction();
		 entityTransaction.begin();
		 
		 entityManager.persist(entidade);
		 
		 entityTransaction.commit();
		 entityManager.close();
		 
		 
	 }
	
 public T merge (T entidade) {
		 
		 EntityManager entityManager = MercadinhoUtil.getEntityManager();
		 EntityTransaction entityTransaction = entityManager.getTransaction();
		 entityTransaction.begin();
		 
		 T retorno =  entityManager.merge(entidade);
		 
		 entityTransaction.commit();
		 entityManager.close();
		 return retorno;
		 
	 }
	


}
