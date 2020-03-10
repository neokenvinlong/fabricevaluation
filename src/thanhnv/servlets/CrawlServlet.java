package thanhnv.servlets;

import thanhnv.crawlers.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrawlServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String realPath = this.getServletContext().getRealPath("/");
        PageCrawler categoryCrawler = new CategoryCrawler("https://www.uniqlo.com/us/en/men/outerwear-and-blazers", realPath);
        TaskCrawler taskCrawlerCategory = new TaskCrawler("OUTBLA", categoryCrawler);
        taskCrawlerCategory.run();
//        PageCrawler outBlaCrawler = new OutBlaCrawler("https://www.uniqlo.com/us/en/men/outerwear-and-blazers", realPath);
////        TaskCrawler taskCrawlerOutBla = new TaskCrawler("OUTBLA", outBlaCrawler);
////        PageCrawler swSwCrawler = new SwSwCrawler("https://www.uniqlo.com/us/en/men/sweatshirts-and-sweatpants", realPath);
////        TaskCrawler taskCrawlerSwSw = new TaskCrawler("SWSW", swSwCrawler);
////        PageCrawler sweCrawler = new SweCrawler("https://www.uniqlo.com/us/en/men/sweaters", realPath);
////        TaskCrawler taskCrawlerSwe = new TaskCrawler("SWE", sweCrawler);
////        PageCrawler casualCrawler = new CasualCrawler("https://www.uniqlo.com/us/en/men/casual-shirts", realPath);
////        TaskCrawler taskCrawlerCasual = new TaskCrawler("CASUAL", casualCrawler);
////        taskCrawlerOutBla.run();
////        taskCrawlerSwSw.run();
////        taskCrawlerSwe.run();
////        taskCrawlerCasual.run();

//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(taskCrawler, 0, 1000);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
