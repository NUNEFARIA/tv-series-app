import com.google.gson.Gson;
import controller.SeriesController;
import model.entities.Serie;
import model.entities.User;
import model.entities.UserData;
import repository.UserRepository;
import service.TvMazeAPIService;
import view.MainFrame;

import java.io.IOException;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        try {

            new MainFrame();

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }
    
}