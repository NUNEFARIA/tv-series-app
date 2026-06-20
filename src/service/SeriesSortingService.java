package service;

import model.entities.Serie;

import java.util.Comparator;
import java.util.List;

public class SeriesSortingService {

    public List<Serie> sortByName(List<Serie> series) {

        series.sort(
                Comparator.comparing(
                Serie::getName,
                String.CASE_INSENSITIVE_ORDER
                )
        );

        return series;
    }

    public List<Serie> sortByRating(List<Serie> series) {

        series.sort(
                Comparator.comparing(
                        Serie::getAverage
                ).reversed()
        );

        return series;
    }

    public List<Serie> sortByPremiered(List<Serie> series) {

        series.sort(
                Comparator.comparing(
                        Serie::getPremiered
                )
        );

        return series;
    }

    public List<Serie> sortByStatus(List<Serie> series) {

        series.sort(
                Comparator.comparing(
                        Serie::getStatus
                )
        );

        return series;
    }
}
