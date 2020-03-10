package thanhnv.crawlers;

import thanhnv.constants.GlobalURL;

public class CategoryCrawler extends PageCrawler {

    public CategoryCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + GlobalURL.XSL_CATEGORY);
        this.setOutputPath(realPath + GlobalURL.OUTPUT_CATEGORY);
    }

    @Override
    public void run() {
        super.run();
    }
}
