package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entities.UserData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserRepository {

    private static final String FILE_NAME = "user-data.json";

    private final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public UserData load() throws IOException {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new UserData();
        }

        try (FileReader reader =
                     new FileReader(file)) {

            return gson.fromJson(
                    reader,
                    UserData.class
            );
        }
    }

    public void save(UserData userData)
            throws IOException {

        try (FileWriter writer =
                     new FileWriter(FILE_NAME)) {

            gson.toJson(userData, writer);
        }
    }
}