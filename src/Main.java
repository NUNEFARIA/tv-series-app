import com.google.gson.Gson;
import model.entities.Serie;
import service.TvMazeAPIService;

import java.io.IOException;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        TvMazeAPIService api =
                new TvMazeAPIService();

        List<Serie> series =
                api.searchSeries("Breaking Bad");

        for (Serie serie : series) {

            System.out.println(serie);

        }
        
    }
    
}