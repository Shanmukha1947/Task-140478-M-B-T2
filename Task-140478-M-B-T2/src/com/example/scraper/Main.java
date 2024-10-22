package com.example.scraper;

public class Main {
    public static void main(String[] args) {
        ScraperService scraperService = new ScraperService();
        ErrorHandlingMiddleware middleware = new ErrorHandlingMiddleware(scraperService);

        String urlToScrape = "https://example.com"; // Replace this with the actual URL you want to scrape

        String data = middleware.scrapeData(urlToScrape);
        if (data != null) {
            System.out.println("Scraped data: " + data);
        } else {
            System.out.println("Failed to scrape data.");
        }
    }
}
