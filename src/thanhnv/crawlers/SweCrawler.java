package thanhnv.crawlers;

import thanhnv.constants.GlobalURL;

public class SweCrawler extends PageCrawler {

    public SweCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + GlobalURL.XSL_SWE);
        this.setOutputPath(realPath + GlobalURL.OUTPUT_SWE);
    }

    @Override
    public void run() {
        super.run();
    }
}
