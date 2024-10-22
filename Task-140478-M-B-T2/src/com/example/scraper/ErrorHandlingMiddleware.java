package com.example.scraper;

public class ErrorHandlingMiddleware {

    private final ScraperService scraperService;

    public ErrorHandlingMiddleware(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    public String scrapeData(String url) {
        try {
            // Call the scraper service within a try-catch block to handle errors
            return scraperService.scrapeData(url);
        } catch (Exception e) {
            // Handle errors here
            handleError(e, url);
            return null;
        }
    }

    private void handleError(Exception e, String url) {
        // Log the error message and other details here
        System.err.println("Error scraping data from URL: " + url);
        System.err.println("Error Message: " + e.getMessage());

        // Additional error handling logic, like sending notifications or retrying can be added here
    }
}

