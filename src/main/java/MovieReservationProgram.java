import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieReservationProgram {

    private final List<Movie> movies;

    public MovieReservationProgram(List<Movie> movies) {
        this.movies = movies;
    }

    public void run() {
        ActionType actionType;
        List<Reservation> reservations = new ArrayList<>();
        do {
            OutputView.printMovies(movies);
            Movie movie = InputView.inputMovieId();
            OutputView.printMovie(movie);
            PlaySchedule playSchedule = InputView.inputMovieTimeIndex(movie);
            int personnel = InputView.inputPersonnel(movie, movieTimeIndex);
            reservations.add(new Reservation(movie, movieTimeIndex, personnel));
            actionType = InputView.inputPaymentOrReserve();
        }while (ActionType.RESERVE.equals(actionType));
        Payment.pay(reservations);
    }

}
