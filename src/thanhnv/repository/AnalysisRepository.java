package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.AnalysisEntity;
import thanhnv.entities.ProductEntity;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalysisRepository {
    private static EntityManagerFactory managerFactory;

    public AnalysisEntity addMaterialAnalysis(AnalysisEntity entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entity = entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ERROR in AnalysisRepository " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public List<AnalysisEntity> getAnalysisInMaterial(ProductEntity productEntity) {
        EntityManager entityManager = getEntityManager();
        try {
            Query query = entityManager.createQuery("Select m from AnalysisEntity m where m.productByProductId = :productEntity");
            query.setParameter("productEntity",productEntity);
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ex);
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }


    public static EntityManager getEntityManager() {
        try {
            if (managerFactory == null) {
                managerFactory = Persistence.createEntityManagerFactory(StaticURL.PERSISTENT_UNIT);
            }
            return managerFactory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
