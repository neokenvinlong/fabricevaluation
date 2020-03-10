package thanhnv.crawlers;

import thanhnv.constants.GlobalURL;

public class OutBlaCrawler extends PageCrawler {

    public OutBlaCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + GlobalURL.XSL_OUTBLA);
        this.setOutputPath(realPath + GlobalURL.OUTPUT_OUTBLA);
    }

    @Override
    public void run() {
        super.run();
    }
}