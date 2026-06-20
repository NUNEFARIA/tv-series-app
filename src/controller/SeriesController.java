package controller;

import model.entities.Serie;
import model.entities.UserData;
import repository.UserRepository;
import service.TvMazeAPIService;
import service.UserService;

import java.io.IOException;
import java.util.List;

public class SeriesController {

    private final TvMazeAPIService apiService;
    private final UserService userService;

    public SeriesController() throws IOException {

        this.apiService = new TvMazeAPIService();

        this.userService = new UserService(new UserRepository()
        );

    }

    /// Search series
    public List<Serie> searchSeries(String name)
            throws IOException, InterruptedException {

        return this.apiService.searchSeries(name);
    }

    /// Favorites
    public void addFavorites(Serie serie)
            throws IOException {

        this.userService.addFavorite(serie);
    }

    public void removeFavorite(Serie serie)
            throws IOException {

        this.userService.removeFavorite(serie);
    }

    public List<Serie> getFavorites() {

        return userService.getFavorites();
    }

    /// Watched
    public void addWatched(Serie serie)
            throws IOException {

        this.userService.addWatched(serie);
    }

    public void removeWatched(Serie serie)
            throws IOException {

        this.userService.removeWatched(serie);
    }

    public List<Serie> getWatched() {

        return userService.getWatched();
    }

    /// Want to watch
    public void addWantToWatch(Serie serie)
            throws IOException {

        this.userService.addWantToWatch(serie);
    }

    public void removeWantToWatch(Serie serie)
            throws IOException {

        this.userService.removeWantToWatch(serie);
    }

    public List<Serie> getWantToWatch() {

        return userService.getWantToWatch();
    }

    /// User data
    public UserData getUserData() {

        return userService.getUserData();
    }
}
