package view;

import domain.Movie;
import domain.Reservation;
import domain.Reservations;

import java.util.List;

public class OutputView {
    private static final String RESERVATION_MESSAGE = "예약 내역";
    private static final String RESULT_PRICE_MESSAGE = "최종 결제한 금액은 %d원 입니다.\n";
    private static final String END_MESSAGE = "예매를 완료했습니다. 즐거운 영화 관람되세요.";

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservationList(Reservations reservations) {
        for (Reservation reservation : reservations.getReservations()) {
            System.out.println(RESERVATION_MESSAGE);
            System.out.println(reservation);
        }
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(RESULT_PRICE_MESSAGE, totalPrice);
        System.out.println(END_MESSAGE);
    }
}
