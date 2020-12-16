import domain.Reservation;
import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final int RESERVE_MORE = 2;
    public static void main(String[] args) {
        run();




        // TODO 구현 진행
    }

    private static void run() {
        int menuNumber;
        List<Reservation> customers = new ArrayList<>();
        do {
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            Movie movie = InputView.inputMovieId();
            OutputView.printMovie(movie);
            int movieTimeIndex = InputView.inputMovieTimeIndex(movie);
            int personnel = InputView.inputPersonnel(movie, movieTimeIndex);
            customers.add(new Reservation(movie, movieTimeIndex, personnel));
            menuNumber = InputView.inputPaymentOrReserve();
        }while (menuNumber == RESERVE_MORE);
        Payment.pay(customers);
    }
}
