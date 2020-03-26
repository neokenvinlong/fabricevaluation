package thanhnv.crawlers;

import thanhnv.constants.StaticURL;
import thanhnv.entities.AnalysisEntity;
import thanhnv.entities.CategoryEntity;
import thanhnv.entities.ProductEntity;
import thanhnv.jaxb.Product;
import thanhnv.repository.AnalysisRepository;
import thanhnv.repository.CategoryRepository;
import thanhnv.repository.ProductRepository;
import thanhnv.utils.HashUtil;
import thanhnv.utils.JAXBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductDetailCrawler extends PageCrawler implements Runnable{

//    private Thread thread;
    private String categoryName;
    private static int count = 0;

    public ProductDetailCrawler(String url, String realPath, String categoryName) {
        super(url, realPath);
        this.setUrl(url);
        this.setXslPath(realPath + StaticURL.XSL_PRODUCT);
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void run() {
        try {
            Product product = (Product) JAXBUtil.unmarshall(Product.class, this.crawl(),this.getRealPath() + StaticURL.SCHEMA_PRODUCT);
//            if(product.getProductid().isEmpty()) {
//                System.out.println("product id: " + product.getProductid());
//                System.out.println("product name: " + product.getProductname());
//                System.out.println("product image: " + product.getProductimage());
//                System.out.println("product prize: " + product.getPrice());
//                String sizeAll = "";
//                for (int i = 0; i < product.getSizes().getSize().size(); i++) {
//                    System.out.println("product size: " + product.getSizes().getSize().get(i));
//                    sizeAll = sizeAll + "/" + product.getSizes().getSize().get(i);
//                }
//                System.out.println("product size all: " + sizeAll);
//
//                String[] sizeSplit = sizeAll.split("/");
//                for (int i = 1; i < sizeSplit.length; i++) {
//                    System.out.println("product size all split:" + sizeSplit[i]);
//                }
//
//                System.out.println("product info: " + product.getProductinfo());
//                System.out.println("product material: " + product.getMaterial());
//                System.out.println("product category: " + getCategoryName());
//            }else{
//                System.out.println("No data");
//            }

            ProductEntity entity = new ProductEntity();
            if(!product.getProductid().isEmpty()) {
                entity.setProductId(product.getProductid());
                entity.setProductName(HashUtil.changeValue(product.getProductname()));
                entity.setProductImage(product.getProductimage());
                entity.setProductPrice(product.getPrice());
                String sizeAll = "";
                for (int i = 0; i < product.getSizes().getSize().size(); i++) {
                    sizeAll = sizeAll + "/" + product.getSizes().getSize().get(i);
                }
                entity.setProductSize(sizeAll);
                entity.setProductInfo(HashUtil.changeValue(product.getProductinfo()));
                entity.setMaterial(HashUtil.changeValue(product.getMaterial()));

                CategoryRepository categoryRepository = new CategoryRepository();
                CategoryEntity categoryEntity1 = categoryRepository.searchCategoryIdByCategoryName(getCategoryName());
                //System.out.println("Category id from name : --- :" + categoryEntity1.getId());
                entity.setCategoryByCategoryId(categoryEntity1);

                ProductRepository productRepository = new ProductRepository();
                String cateIDString = String.valueOf(categoryEntity1.getId());
                //hashcode
                if (!productRepository.findHashCodeExisting(HashUtil.hashMD5(product.getProductid() + product.getProductname() + cateIDString))) {
                    entity.setHashCode(HashUtil.hashMD5(product.getProductid() + product.getProductname() + cateIDString));

                    productRepository.addProduct(entity);
                    count ++;
                    System.out.println("product no :" + count);

                    //get material ID

                    String mau = HashUtil.changeValue(product.getMaterial());
                    String matching1 = "(?:\\b|-)([1-9]{1,2}[0]?|100)\\b\\% ([A-Z])\\w+";
                    Pattern pattern = Pattern.compile(matching1);
                    Matcher matcher = pattern.matcher(mau);
                    List<Integer> percentList = new ArrayList<>();
                    List<String> mateList = new ArrayList<>();
                    while (matcher.find()){
                        String a = matcher.group();
                        System.out.println("aaa"+a);
                        String []b = a.split(" ");
                        System.out.println("bbb"+ b[0] +"xxxx" + b[1]);
                        int bInt = Integer.parseInt(b[0].replace("%",""));
                        percentList.add(bInt);
                        mateList.add(b[1]);
                    }
                    System.out.println("Percent list "+ percentList);
                    System.out.println("Mate List"+ mateList);

                    AnalysisEntity analysisEntity = new AnalysisEntity();
                    AnalysisRepository analysisRepository = new AnalysisRepository();
                    for(int i=0; i< percentList.size(); i++){
                        analysisEntity.setPercentage(percentList.get(i));
                        analysisEntity.setFabridName(mateList.get(i));
                        analysisEntity.setProductByProductId(entity);
                        analysisRepository.addMaterialAnalysis(analysisEntity);
                    }


                    //end of get material ID
                }
            }
            System.out.println("Total product: " + count);

//            System.out.println(this.crawl());

            //search id by category name

//            CategoryEntity categoryEntity = new CategoryEntity();
//            categoryEntity.setName(getCategoryName());
//
//            CategoryRepository categoryRepository = new CategoryRepository();
////            categoryRepository.addCategory(categoryEntity);
////
//            CategoryEntity categoryEntity1 = categoryRepository.searchCategoryIdByCategoryName(getCategoryName());
//            System.out.println("Category id from name : --- :" + categoryEntity1.getId());
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