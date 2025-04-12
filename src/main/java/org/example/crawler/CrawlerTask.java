package org.example.crawler;

import java.util.Set;
import java.util.concurrent.Phaser;

public class CrawlerTask implements Runnable {

    private final URLStore urlStore;
    private final URLFetcher urlFetcher;
    private final int maxDepth;
    private final int currentDepth;
    private final Phaser phaser;

    public CrawlerTask(URLStore urlStore, URLFetcher urlFetcher, int maxDepth, int currentDepth, Phaser phaser) {
        this.urlStore = urlStore;
        this.urlFetcher = urlFetcher;
        this.maxDepth = maxDepth;
        this.currentDepth = currentDepth;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try{
            String url = urlStore.getNextURL();
            System.out.println(Thread.currentThread().getName() + ": " + url);

            if(url == null || currentDepth > maxDepth) return;

            Set<String> links = urlFetcher.fetchLinks(url);

            for(String link: links) {
                if(urlStore.addURL(link)) {
                    phaser.register();
                    WebCrawler.submitTask(urlStore, urlFetcher, currentDepth+1, maxDepth);
                }
            }

        } catch (Exception e) {
            System.out.println("Error occured!!");
        }finally {
            phaser.arriveAndDeregister();
        }
    }
}
