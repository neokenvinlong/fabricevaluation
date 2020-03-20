package thanhnv.crawlers;

import thanhnv.constants.StaticURL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductCategoryCrawler extends PageCrawler {
    private String categoryName;
    private List<String> productCategoryUrl = new ArrayList<String>();

    public ProductCategoryCrawler(String url, String realPath, String categoryName) {
        super(url, realPath);
        this.setXslPath(realPath + StaticURL.XSL_PRODUCT_CATEGORY);
        this.setOutputPath(realPath + StaticURL.OUTPUT_PRODUCT_CATEGORY);
        this.categoryName = categoryName;
    }

    public List<String> getProductCategoryUrl() {
        return productCategoryUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void run() {
        try {
            this.setXslPath(this.getRealPath()+StaticURL.XSL_PRODUCT_CATEGORY);
            String listUrl = this.crawl().toString();
            productCategoryUrl.addAll(Arrays.asList(listUrl.split("thanhdeptrai")));
            Arrays.asList(listUrl.split("thanhdeptrai")).forEach(url -> {
                if(!url.equals("")){
//                    System.out.println(url);
                    ProductDetailCrawler productDetailCrawler = new ProductDetailCrawler(url, getRealPath(),getCategoryName());
//                    productDetailCrawler.start();
                    productDetailCrawler.run();
                }
            });
//            ProductDetailCrawler productDetailCrawler = new ProductDetailCrawler("https://www.uniqlo.com/us/en/men-heattech-striped-socks-421050.html?dwvar_421050_color=COL66&cgid=", getRealPath(),getCategoryName());
////                    productDetailCrawler.start();
//            productDetailCrawler.run();
        }catch(Exception e){
            e.printStackTrace();
        }
//        super.run();
    }
}