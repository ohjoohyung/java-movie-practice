import domain.Movie;
import domain.MovieRepository;
import utils.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        run();



        // TODO 구현 진행
    }

    private static void run() {
        Movie movie = InputView.inputMovieId();
        OutputView.printMovie(movie);
        int movieIndex = InputView.inputMovieTimeIndex(movie);
        int personnel = InputView.inputPersonnel(movie, movieIndex);

    }

}
