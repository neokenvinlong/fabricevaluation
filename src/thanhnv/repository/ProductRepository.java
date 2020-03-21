package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.ProductEntity;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductRepository {
    private static EntityManagerFactory managerFactory;


    public ProductEntity addProduct(ProductEntity entity) {
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
        }finally{
            entityManager.close();
        }
        return entity;
    }

    public ProductEntity getProductByProductId(String productId){
        EntityManager entityManager = getEntityManager();
        try {
            Query query = entityManager.createQuery("Select p from ProductEntity p where p.productId = :productId");
            query.setParameter("productId",productId);
            return (ProductEntity) query.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught",ex);
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public boolean findHashCodeExisting(String hashCode){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("ProductEntity.findByHashCode");
        query.setParameter("hashCode",hashCode);
        try{
            query.getSingleResult();
            return true;
        }catch(Exception e){
            return false;
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
