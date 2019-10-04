package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Entity Manager
public class EntityManagerUtil {

	private static EntityManager entityManager;

	private EntityManagerUtil() {
	}
	
	public static EntityManager getEntityManager() {
		if(entityManager==null){
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");
			return emFactory.createEntityManager();
		}
		return entityManager;
	}
}
