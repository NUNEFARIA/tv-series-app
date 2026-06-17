package service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TvMazeAPIService {
    
    private static final String BASE_URL = "https://api.tvmaze.com/search/shows?q=";
    
    public String searchByName(String serie) throws IOException, InterruptedException {
        
        serie = serie.trim();
        
        String query = URLEncoder.encode(
                serie,
                StandardCharsets.UTF_8
        );
        
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + query))
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        
        return response.body();
        
    }
}
