package thanhnv.crawlers;

import thanhnv.constants.GlobalURL;

public class CasualCrawler extends PageCrawler {

    public CasualCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + GlobalURL.XSL_CASUAL);
        this.setOutputPath(realPath + GlobalURL.OUTPUT_CASUAL);
    }

    @Override
    public void run() {
        super.run();
    }
}
