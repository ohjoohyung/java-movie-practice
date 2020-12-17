package service;

import domain.PayType;
import domain.Reservations;
import view.InputView;
import view.OutputView;

public class PayService {
    private static final double CARD_DISCOUNT = 0.95;
    private static final double CASH_DISCOUNT = 0.98;

    public void pay(Reservations reservations) {
        OutputView.printReservationList(reservations);
        int point = InputView.inputPoint(reservations);
        int movieTotalPrice = reservations.getTotalPrice();
        PayType paymentType = InputView.inputPaymentType();
        payByType(paymentType, movieTotalPrice - point);
    }

    private void payByType(PayType paymentType, int payPrice) {
        if (PayType.CARD.equals(paymentType)) {
            OutputView.printTotalPrice((int)(payPrice * CARD_DISCOUNT));
            return;
        }
        if (PayType.CASH.equals(paymentType)) {
            OutputView.printTotalPrice((int)(payPrice * CASH_DISCOUNT));
        }
    }
}
