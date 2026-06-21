package controller;

import model.entities.Serie;
import model.entities.UserData;
import repository.UserRepository;
import service.SeriesSortingService;
import service.TvMazeAPIService;
import service.UserService;

import java.io.IOException;
import java.util.List;

public class SeriesController {

    private final TvMazeAPIService apiService;
    private final UserService userService;
    private final SeriesSortingService sortingService;

    public SeriesController() throws IOException {

        this.apiService = new TvMazeAPIService();

        this.userService = new UserService(new UserRepository()
        );

        this.sortingService = new SeriesSortingService();

    }

    /// Search series
    public List<Serie> searchSeries(String name)
            throws IOException, InterruptedException {

        return this.apiService.searchSeries(name);
    }

    /// Favorites
    public void addFavorite(Serie serie)
            throws IOException {

        this.userService.addFavorite(serie);
    }

    public void removeFavorite(Serie serie)
            throws IOException {

        this.userService.removeFavorite(serie);
    }

    public List<Serie> getFavorite() {

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

    /// Sort Series
    public List<Serie> sortByName(List<Serie> series) {
        return sortingService.sortByName(series);
    }

    public List<Serie> sortByRating(List<Serie> series) {
        return sortingService.sortByRating(series);
    }

    public List<Serie> sortByStatus(List<Serie> series) {
        return sortingService.sortByStatus(series);
    }

    public List<Serie> sortByPremiered(List<Serie> series) {
        return sortingService.sortByPremiered(series);
    }
}
