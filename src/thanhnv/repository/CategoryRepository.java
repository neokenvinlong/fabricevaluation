package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.CategoryEntity;
import thanhnv.entities.ProductEntity;
import thanhnv.jaxb.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryRepository {
    private static EntityManagerFactory managerFactory;


    public CategoryEntity addCategory(CategoryEntity entity) {
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
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught",e);
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public CategoryEntity searchCategoryIdByCategoryName(String searchValue){
        EntityManager entityManager = getEntityManager();
        CategoryEntity categoryEntity = new CategoryEntity();
        try {
            Query query = entityManager.createQuery("Select c from CategoryEntity c where c.name = :searchValue");
            query.setParameter("searchValue",searchValue);
            categoryEntity = (CategoryEntity) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("ERROR in ProductRepository " + e.getMessage());
        }
        return categoryEntity;
    }

    public List<ProductEntity> getProductListByCategoryId(int id){
        EntityManager entityManager = getEntityManager();
        List<ProductEntity> productEntityList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("Select p from ProductEntity p where p.categoryByCategoryId = :id");
            query.setParameter("id",id);
            productEntityList = query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR in ProductRepository " + e.getMessage());
        }
        return productEntityList;
    }

    public List<CategoryEntity> readCategoryList(){
        EntityManager entityManager = getEntityManager();
        String jpql = "Select c From CategoryEntity c";
        Query query = entityManager.createQuery(jpql);
        try{
            return query.getResultList();
        }catch(NoResultException ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught",ex);
            entityManager.getTransaction().rollback();
            return null;
        }finally {
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
