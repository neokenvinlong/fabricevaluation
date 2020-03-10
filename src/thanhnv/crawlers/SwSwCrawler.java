package thanhnv.crawlers;

import thanhnv.constants.GlobalURL;

public class SwSwCrawler extends PageCrawler {

    public SwSwCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + GlobalURL.XSL_SWSW);
        this.setOutputPath(realPath + GlobalURL.OUTPUT_SWSW);
    }

    @Override
    public void run() {
        super.run();
    }
}
