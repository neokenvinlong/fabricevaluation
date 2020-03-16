package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.MaterialEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MaterialRepository {
    private static EntityManagerFactory managerFactory;


    public MaterialEntity addProduct(MaterialEntity entity) {
        if (entity == null) {
            return null;
        }
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entity = entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ERROR in ProductRepository " + e.getMessage());
        }
        return entity;
    }

    public static EntityManager getEntityManager(){
        try {
            if (managerFactory == null){
                managerFactory = Persistence.createEntityManagerFactory(StaticURL.PERSISTENT_UNIT);
            }
            return managerFactory.createEntityManager();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
