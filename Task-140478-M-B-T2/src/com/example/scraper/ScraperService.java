package com.example.scraper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ScraperService {
    public String scrapeData(String url) throws Exception {
        // Simulate the scraping process using HttpURLConnection
        String response = null;
        HttpURLConnection connection = null;
        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                response = new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next();
            } else {
                throw new Exception("Failed to fetch data. Status code: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            throw new Exception("Error scraping data from URL: " + url, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }
}
