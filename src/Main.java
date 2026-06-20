import com.google.gson.Gson;
import controller.SeriesController;
import model.entities.Serie;
import model.entities.User;
import model.entities.UserData;
import repository.UserRepository;
import service.TvMazeAPIService;

import java.io.IOException;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        SeriesController controller =
                new SeriesController();

        List<Serie> results =
                controller.searchSeries("Breaking Bad");

        System.out.println(results.get(0));
        
    }
    
}