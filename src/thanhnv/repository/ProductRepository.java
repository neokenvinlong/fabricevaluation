package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.ProductEntity;

import javax.persistence.*;

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

//    public ProductEntity searchCategoryIdByCategoryName(String searchValue){
//        EntityManager entityManager = getEntityManager();
//        CategoryEntity categoryEntity = new CategoryEntity();
//        try {
//            Query query = entityManager.createQuery("Select c from CategoryEntity c where c.name = :searchValue");
//            query.setParameter("searchValue",searchValue);
//            categoryEntity = (CategoryEntity) query.getSingleResult();
//        } catch (Exception e) {
//            System.out.println("ERROR in ProductRepository " + e.getMessage());
//        }
//        return categoryEntity;
//    }

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
