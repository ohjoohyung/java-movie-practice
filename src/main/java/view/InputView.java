package view;

import domain.*;
import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MOVIE_ID_MESSAGE = "## 예약할 영화를 선택하세요.";
    private static final String INPUT_MOVIE_TIME_INDEX_MESSAGE = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String INPUT_PERSONNEL_MESSAGE = "## 예약할 인원을 입력하세요.";
    private static final String INPUT_PAYMENT_OR_RESERVE_MESSAGE = "## 예약을 종료하고 결제를 진행하면 1번, 추가 예약을 진행하려면 2번";
    private static final String INPUT_POINT_MESSAGE = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String INPUT_PAYMENT_TYPE_MESSAGE = "## 신용카드는 1번, 현금은 2번";

    public static Movie inputMovieId() {
        try {
            System.out.println(INPUT_MOVIE_ID_MESSAGE);
            return MovieRepository.getMovieByMovieId(InputValidator.validateInteger(scanner.nextLine()));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static PlaySchedule inputPlayScheduleIndex(Movie movie, Reservations reservations) {
        try {
            System.out.println(INPUT_MOVIE_TIME_INDEX_MESSAGE);
            int movieIndex = InputValidator.validateInteger(scanner.nextLine());
            PlaySchedule playSchedule = movie.findPlayScheduleByIndex(movieIndex);
            reservations.checkReservationsPlaySchedule(playSchedule);
            return movie.findPlayScheduleByIndex(movieIndex);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayScheduleIndex(movie, reservations);
        }
    }


    public static int inputCustomerCount(PlaySchedule playSchedule) {
        try {
            System.out.println(INPUT_PERSONNEL_MESSAGE);
            int customerCount = InputValidator.validateInteger(scanner.nextLine());
            playSchedule.checkCapacityRange(customerCount);
            return customerCount;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCustomerCount(playSchedule);
        }
    }

    public static ActionType inputPaymentOrReserve() {
        try {
            System.out.println(INPUT_PAYMENT_OR_RESERVE_MESSAGE);
            return ActionType.of(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPaymentOrReserve();
        }
    }

    public static int inputPoint(Reservations reservations) {
        try {
            System.out.println(INPUT_POINT_MESSAGE);
            int point = InputValidator.validateInteger(scanner.nextLine());
            reservations.checkPointWithInRange(point);
            return point;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPoint(reservations);
        }
    }

    public static PayType inputPaymentType() {
        try {
            System.out.println(INPUT_PAYMENT_TYPE_MESSAGE);
            return PayType.of(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPaymentType();
        }
    }


}
