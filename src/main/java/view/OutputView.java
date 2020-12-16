package view;

import domain.Movie;
import domain.Reservation;

import java.util.List;

public class OutputView {
    private static final String RESERVATION_MESSAGE = "예약 내역";
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservationList(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println(RESERVATION_MESSAGE);
            System.out.println(reservation);
        }
    }
}
