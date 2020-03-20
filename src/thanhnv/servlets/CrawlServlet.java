package thanhnv.servlets;

import thanhnv.crawlers.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CrawlServlet", urlPatterns = "/CrawlServlet")
public class CrawlServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String realPath = this.getServletContext().getRealPath("/");
        PageCrawler categoryCrawler = new CategoryCrawler("https://www.uniqlo.com",realPath);
        TaskCrawler taskCrawler = new TaskCrawler("UNICATE",categoryCrawler);
        taskCrawler.run();
        PageCrawler materialCrawler = new MaterialCrawler("https://dressmann.com/en/corporate-en/product-info/guide-to-material---fiber-quality/?fbclid=IwAR1lAfKRq39lvXeAufha76hcueF77A7DMjYVRJ6r4HhwFPj61enZtVHMLxc",realPath);
        TaskCrawler taskCrawler1 = new TaskCrawler("UNICATE",materialCrawler);
        taskCrawler1.run();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
