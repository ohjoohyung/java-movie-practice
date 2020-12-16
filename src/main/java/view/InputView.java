package view;

import domain.Movie;
import domain.MovieRepository;
import domain.MovieService;
import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_ID_MESSAGE = "## 예약할 영화를 선택하세요.";
    private static final String INPUT_MOVIE_TIME_INDEX_MESSAGE = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String INPUT_PERSONNEL_MESSAGE = "## 예약할 인원을 입력하세요.";
    private static final String INPUT_PAYMENT_OR_RESERVE = "## 예약을 종료하고 결제를 진행하면 1번, 추가 예약을 진행하려면 2번";

    public static Movie inputMovieId() {
        try {
            System.out.println(INPUT_MOVIE_ID_MESSAGE);
            int movieId = InputValidator.validateInteger(scanner.nextLine());
            MovieService.validateMovieId(movieId);
            return MovieRepository.getMovieByMovieId(movieId);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static int inputMovieTimeIndex(Movie movie) {
        try {
            System.out.println(INPUT_MOVIE_TIME_INDEX_MESSAGE);
            int movieIndex = InputValidator.validateInteger(scanner.nextLine());
            movie.checkPlayScheduleIndex(movieIndex);
            return movieIndex;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovieTimeIndex(movie);
        }
    }

    public static int inputPersonnel(Movie movie, int index) {
        try {
            System.out.println(INPUT_PERSONNEL_MESSAGE);
            int personnel = InputValidator.validateInteger(scanner.nextLine());
            movie.checkPlayScheduleCapacityByIndex(index, personnel);
            return personnel;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPersonnel(movie, index);
        }
    }

    public static int inputPaymentOrReserve() {
        try {
            System.out.println(INPUT_PAYMENT_OR_RESERVE);
            int menuNumber = InputValidator.validateInteger(scanner.nextLine());
            return menuNumber;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPaymentOrReserve();
        }
    }


}
