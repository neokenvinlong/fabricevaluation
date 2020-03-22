package thanhnv.repository;

import thanhnv.constants.StaticURL;
import thanhnv.entities.MaterialEntity;
import thanhnv.entities.ProductEntity;

import javax.persistence.*;
import java.util.ArrayList;
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

    public List<MaterialEntity> getFiberInMaterial() {
        EntityManager entityManager = getEntityManager();
        try {
            Query query = entityManager.createQuery("Select m from MaterialEntity m");
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ex);
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<String> getMaterialInfoForSeason(ProductEntity productEntity, String appear) {
        List<String> season = new ArrayList<>();

        if (!productEntity.getProductName().toLowerCase().contains("backpack")
                && !productEntity.getProductName().toLowerCase().contains("bag")
                && !productEntity.getProductName().toLowerCase().contains("hat")
                && !productEntity.getProductName().toLowerCase().contains("briefs")
                && !productEntity.getProductName().toLowerCase().contains("cap")) {
            if (productEntity.getCategoryByCategoryId().getId() == 4
                    || productEntity.getCategoryByCategoryId().getId() == 5
                    || productEntity.getCategoryByCategoryId().getId() == 6
                    || productEntity.getCategoryByCategoryId().getId() == 8
                    || productEntity.getCategoryByCategoryId().getId() == 9
                    || productEntity.getCategoryByCategoryId().getId() == 10
                    || productEntity.getCategoryByCategoryId().getId() == 12
                    || productEntity.getCategoryByCategoryId().getId() == 14) {
                season.add("HOT WEATHER");
            }else if (productEntity.getProductName().toLowerCase().contains("WOOL")
                    || productEntity.getProductName().toLowerCase().contains("chino")
                    || productEntity.getProductName().contains("UV PROTECTION")
                    || productEntity.getProductName().toLowerCase().contains("kando shorts")
                    || productEntity.getProductName().toLowerCase().contains("short-sleeve")) {
                season.add("HOT WEATHER");
            }else if (appear.toLowerCase().contains("absorbs moisture") || appear.toLowerCase().contains("easily absorbs")) {
                season.add("HOT WEATHER");
            }

            if (productEntity.getMaterial().toLowerCase().contains("leather")
                    || productEntity.getMaterial().toLowerCase().contains("100% polyester")
                    || productEntity.getCategoryByCategoryId().getId() == 2
                    || productEntity.getCategoryByCategoryId().getId() == 3
                    || productEntity.getCategoryByCategoryId().getId() == 16
                    || productEntity.getCategoryByCategoryId().getId() == 17
                    || productEntity.getCategoryByCategoryId().getId() == 19) {
                season.add("COLD WEATHER");
            }else if (productEntity.getProductName().toLowerCase().contains("wool")
                    || productEntity.getProductName().toLowerCase().contains("parka")
                    || productEntity.getProductName().toLowerCase().contains("coat")
                    || productEntity.getProductName().toLowerCase().contains("sweatpants")
                    || productEntity.getProductName().toLowerCase().contains("chino")
                    || productEntity.getProductName().toLowerCase().contains("warm")
                    || productEntity.getProductName().contains("UV PROTECTION")
                    || productEntity.getProductName().toLowerCase().contains("turtleneck")
                    || productEntity.getProductName().toLowerCase().contains("long-sleeve")) {
                season.add("COLD WEATHER");
            } else if (appear.toLowerCase().contains("not absorbant") || appear.toLowerCase().contains("cold")) {
                season.add("COLD WEATHER");
            }
        }
        return season;
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
