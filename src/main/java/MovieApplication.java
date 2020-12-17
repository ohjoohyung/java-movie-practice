
import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class MovieApplication {

    public static void main(String[] args) {

        final List<Movie> movies = MovieRepository.getMovies();

        MovieReservationProgram movieReservationProgram = new MovieReservationProgram(movies);
        movieReservationProgram.run();


        // TODO 구현 진행
    }


}
