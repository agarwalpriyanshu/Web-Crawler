package org.example.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class URLFetcher {
    public Set<String> fetchLinks(String url) {

        Set<String> links = new HashSet<String>();
        Document document = null;

        try {
            document = Jsoup.connect(url).timeout(50000).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(document.text());

        Elements anchorTags = document.select("a[href]");

        for(Element link: anchorTags) {
            String extractedUrl = link.absUrl("href");

            if(!extractedUrl.isEmpty()) {
                links.add(extractedUrl);
                System.out.println(links);
            }
        }
        return links;
    }
}
