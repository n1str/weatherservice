package n1str.client.service;

import n1str.Config;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class WeatherData {
    public static String getData(String lat, String lon, String limit) {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(Config.SOURCE_URL + "?lat=" + lat + "&lon=" + lon + "&limit=" + limit);
        String accessKey = Config.API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .header("X-Yandex-Weather-Key", accessKey)
                .header("Content-Type", "application/json")
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            System.err.println("Error occurred while sending POST request: " + e.getMessage());
            return null;
        }

    }
}
