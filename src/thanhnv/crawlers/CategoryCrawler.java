package thanhnv.crawlers;

import thanhnv.constants.StaticURL;
import thanhnv.jaxb.Categories;
import thanhnv.utils.JAXBUtil;

public class CategoryCrawler extends PageCrawler {

    public CategoryCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + StaticURL.XSL_CATEGORY);
        this.setOutputPath(realPath + StaticURL.OUTPUT_CATEGORY);
    }

    @Override
    public void run() {
        try {
            Categories categories = (Categories) JAXBUtil.unmarshall(Categories.class, this.crawl(),this.getRealPath()+StaticURL.SCHEMA_CATEGORY);
            categories.getCategory().stream().forEach(category -> {
                ProductCategoryCrawler productCategoryCrawler = new ProductCategoryCrawler(category.getUrl(),this.getRealPath());
                productCategoryCrawler.run();
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
