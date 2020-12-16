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
        run(movies);



        // TODO 구현 진행
    }

    private static void run(List<Movie> movies) {
        int movieId = InputView.inputMovieId();
        OutputView.printMovieByMovieId(movies, movieId);
    }

}
