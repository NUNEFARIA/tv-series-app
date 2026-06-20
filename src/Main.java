import com.google.gson.Gson;
import model.entities.Serie;
import model.entities.User;
import model.entities.UserData;
import repository.UserRepository;
import service.TvMazeAPIService;

import java.io.IOException;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        UserRepository repository =
                new UserRepository();

        UserData loaded =
                repository.load();

        System.out.println(loaded);
        
    }
    
}