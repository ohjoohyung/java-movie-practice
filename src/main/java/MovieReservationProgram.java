import domain.*;
import service.PayService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieReservationProgram {
    private final PayService payService;
    private final List<Movie> movies;

    public MovieReservationProgram(List<Movie> movies) {
        this.movies = movies;
        payService = new PayService();
    }

    public void run() {
        ActionType actionType;
        Reservations reservations = new Reservations();
        do {
            OutputView.printMovies(movies);
            Movie movie = InputView.inputMovieId();
            OutputView.printMovie(movie);
            PlaySchedule playSchedule = InputView.inputPlayScheduleIndex(movie, reservations);
            int customerCount = InputView.inputCustomerCount(playSchedule);
            reservations.addReservation(new Reservation(movie, playSchedule, customerCount));
            actionType = InputView.inputPaymentOrReserve();
        }while (ActionType.RESERVE.equals(actionType));
        payService.pay(reservations);
    }

}
