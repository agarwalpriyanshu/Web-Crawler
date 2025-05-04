# 🕸️ Multi-threaded Web Crawler in Java

A high-performance web crawler built using **Java**, capable of crawling websites concurrently with user-defined depth and thread count. The crawler extracts hyperlinks from web pages using **Jsoup** and improves performance using **multithreading** with `ExecutorService` and `Phaser`.

---

## 🚀 Features

- 🔗 Extracts and prints all hyperlinks from a given URL  
- 🔁 Supports configurable **crawl depth**  
- ⚙️ Uses **multiple threads** for faster execution  
- 🧵 Dynamic thread synchronization using `Phaser`  
- ✅ Avoids duplicate URLs using `ConcurrentHashMap`  
- 📈 Achieves up to **10x performance improvement** over a single-threaded version  

---

## 🛠️ Tech Stack

- Java  
- Jsoup (HTML parser)  
- ExecutorService & Phaser (Java Concurrency)  
- ConcurrentHashMap & BlockingQueue

---

## 📂 Project Structure
<pre>org.example.crawler
├── WebCrawler.java       // Entry point, handles input and thread management
├── CrawlerTask.java      // Runnable task for each crawling operation
├── URLFetcher.java       // Fetches and parses URLs using Jsoup
├── URLStore.java         // Manages visited URLs and the URL queue</pre>


---

## 🧪 How to Run

1. Clone the repository  
2. Ensure you have **Java 8+** and Jsoup dependency set up  
3. Compile and run the `WebCrawler` class

```bash
Enter your URL: https://example.com  
Enter the crawl depth: 2  
Enter the number of worker threads: 5  
```
---

## 📸 Sample Output
```
Thread-1: https://example.com
[https://example.com/about]
Thread-2: https://example.com/about
...
Time taken: 350ms
```
---
## 📚 Learning Outcomes

- Gained deep understanding of Java concurrency and synchronization

- Applied thread-safe collections for shared state management

- Explored real-world use of HTML parsing libraries like Jsoup

- Designed a scalable architecture for web crawling systems





