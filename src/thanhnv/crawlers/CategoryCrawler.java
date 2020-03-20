package thanhnv.crawlers;

import thanhnv.constants.StaticURL;
import thanhnv.entities.CategoryEntity;
import thanhnv.jaxb.Categories;
import thanhnv.repository.CategoryRepository;
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
                //crawl category
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setName(category.getName());

                CategoryRepository categoryRepository = new CategoryRepository();
                categoryRepository.addCategory(categoryEntity);

                //crawl product link
                ProductCategoryCrawler productCategoryCrawler = new ProductCategoryCrawler(category.getUrl(),this.getRealPath(),category.getName());
                productCategoryCrawler.run();
            });


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
