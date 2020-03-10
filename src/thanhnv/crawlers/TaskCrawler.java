package thanhnv.crawlers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class TaskCrawler  extends TimerTask {
    private String name;

    private PageCrawler crawler;


    public TaskCrawler(String name, PageCrawler crawler) {
        this.name = name;
        this.crawler = crawler;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(String.format("Task [%s] executing at %s", name, formatter.format(Calendar.getInstance().getTime())));
        this.crawler.run();
        System.out.println(String.format("Task [%s] executed at %s", name, formatter.format(Calendar.getInstance().getTime())));
    }
}
