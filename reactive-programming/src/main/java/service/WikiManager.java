package service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WikiManager {

    public static String [] urls = {
            "https://en.wikibooks.org/wiki/Shelf:Computer_science",
            "https://en.wikibooks.org/wiki/Shelf:Computer_software",
            "https://en.wikibooks.org/wiki/Shelf:Web_applications"};

    private static List<String> getWikiNewsFromUrl(String url) throws IOException {
        List<String> news = new ArrayList();
        Document doc = Jsoup.connect(url).get();
        Elements newsHeadlines = doc.getElementsByAttribute("href");
        newsHeadlines.forEach(newsTitle -> news.add(newsTitle.attr("title")));
        return news;
    }

    public static List getWikiNewsFromUrlApi(String url) {
        List wikiLinks = null;
        try {
             wikiLinks = getWikiNewsFromUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wikiLinks;
    }
}
