package thanhnv.crawlers;

import thanhnv.constants.StaticURL;
import thanhnv.entities.ProductEntity;
import thanhnv.jaxb.Product;
import thanhnv.repository.ProductRepository;
import thanhnv.utils.HashUtil;
import thanhnv.utils.JAXBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailCrawler extends PageCrawler implements Runnable{

    private Thread thread;

    public ProductDetailCrawler(String url, String realPath) {
        super(url, realPath);
        this.setUrl(url);
        this.setXslPath(realPath + StaticURL.XSL_PRODUCT);
    }

    @Override
    public void run() {
        try {
            Product product = (Product) JAXBUtil.unmarshall(Product.class, this.crawl(),this.getRealPath() + StaticURL.SCHEMA_PRODUCT);
//            System.out.println("product id: "+product.getProductid());
//            System.out.println("product name: "+product.getProductname());
//            System.out.println("product image: "+product.getProductimage());
//            System.out.println("product prize: "+product.getPrice());
//            System.out.println("product size: "+product.getSizes().getSize().get(0));
//            System.out.println("product info: "+product.getProductinfo());
//            System.out.println("product material: "+product.getMaterial());
            ProductEntity entity = new ProductEntity();

            entity.setProductId(product.getProductid());
            entity.setProductName(HashUtil.changeValue(product.getProductname()));
            entity.setProductImage(product.getProductimage());
            entity.setProductPrice(product.getPrice());
            entity.setProductInfo(HashUtil.changeValue(product.getProductinfo()));
            entity.setMaterial(HashUtil.changeValue(product.getMaterial()));
            int count = 0;
            entity.setSizeId(count++);

            ProductRepository productRepository = new ProductRepository();
            productRepository.addProduct(entity);


//            System.out.println(this.crawl());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void start() {
//        if (thread == null) {
//            thread = new Thread(this);
//            thread.start();
//        }
//    }
}