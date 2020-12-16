package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieByMovieId(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.isMovieId(movieId)) {
                System.out.println(movie);
                return;
            }
        }
    }
}
