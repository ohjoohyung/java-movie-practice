package domain;

import java.util.List;

public class MovieService {
    private static final String NOT_EXIST_MOVIE_ID_ERROR = "[ERROR] 해당 번호의 영화가 존재하지 않습니다.";


    public static void validateMovieId(int moveId) {
        validateMovieIdInMovies(moveId);
        validateCapacityByMovieId(moveId);
    }

    private static void validateMovieIdInMovies(int movieId) {
        if (!MovieRepository.hasMovie(movieId)) {
            throw new IllegalArgumentException(NOT_EXIST_MOVIE_ID_ERROR);
        }
    }

    private static void validateCapacityByMovieId(int movieId) {
        List<Movie> movies = MovieRepository.getMovies();
        for (Movie movie : movies) {
            if (movie.isMovieId(movieId)) {
                movie.checkPlayScheduleCapacity();
            }
        }
    }
}
