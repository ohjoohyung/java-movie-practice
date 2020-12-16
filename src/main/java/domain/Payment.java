package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Payment {
    private static final int ZERO = 0;
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private static final String POINT_RANGE_ERROR = "[ERROR] 포인트가 0보다 작거나 금액보다 큽니다.";


    public static void pay(List<Reservation> reservations) {
        OutputView.printReservationList(reservations);
        int point = InputView.inputPoint(reservations);
        int moviePrice = reservations.stream()
                .mapToInt(Reservation::getMoviePrice)
                .sum();
        int paymentType = InputView.inputPaymentType();
        payByType(paymentType, moviePrice - point);
    }

    private static void payByType(int paymentType, int price) {
        if (paymentType == CREDIT_CARD) {

        }
    }
}
