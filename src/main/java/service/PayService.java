package service;

import domain.Reservation;
import domain.Reservations;
import view.InputView;
import view.OutputView;

public class PayService {
    private static final int ZERO = 0;
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private static final double CARD_DISCOUNT = 0.95;
    private static final double CASH_DISCOUNT = 0.98;


    private static final String POINT_RANGE_ERROR = "[ERROR] 포인트가 0보다 작거나 금액보다 큽니다.";


    public void pay(Reservations reservations) {
        OutputView.printReservationList(reservations);
        int point = InputView.inputPoint(reservations);
        int moviePrice = reservations.stream()
                .mapToInt(Reservation::getMoviePrice)
                .sum();
        int paymentType = InputView.inputPaymentType();
        payByType(paymentType, moviePrice - point);
    }

    private void payByType(int paymentType, int totalPrice) {
        if (paymentType == CREDIT_CARD) {
            OutputView.printTotalPrice((int)(totalPrice * CARD_DISCOUNT));
            return;
        }
        if (paymentType == CASH) {
            OutputView.printTotalPrice((int)(totalPrice * CASH_DISCOUNT));
        }
    }
}
