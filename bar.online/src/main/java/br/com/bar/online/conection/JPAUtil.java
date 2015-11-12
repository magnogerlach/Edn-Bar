package br.com.bar.online.conection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("default");

	public static EntityManager getEntityMananger() {
		return emf.createEntityManager();

	}

}
