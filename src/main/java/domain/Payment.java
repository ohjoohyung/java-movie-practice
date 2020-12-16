package domain;

import view.InputView;

import java.util.List;

public class Payment {
    private static final int ZERO = 0;
    private static final String POINT_RANGE_ERROR = "[ERROR] 포인트가 0보다 작거나 금액보다 큽니다.";


    public static void pay(List<Reservation> customers) {
        int point = InputView.inputPoint(customers);
        int moviePrice = customers.stream()
                .mapToInt(Reservation::getMoviePrice)
                .sum();

    }


}
