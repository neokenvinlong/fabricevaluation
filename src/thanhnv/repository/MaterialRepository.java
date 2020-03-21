package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.MaterialEntity;
import thanhnv.entities.ProductEntity;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialRepository {
    private static EntityManagerFactory managerFactory;


    public MaterialEntity addMaterial(MaterialEntity entity) {
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
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public List<MaterialEntity> getFiberInMaterial(){
        EntityManager entityManager = getEntityManager();
        try {
            Query query = entityManager.createQuery("Select m from MaterialEntity m");
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught",ex);
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
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
