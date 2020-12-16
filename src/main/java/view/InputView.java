package view;

import domain.MovieService;
import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_ID_MESSAGE = "## 예약할 영화를 선택하세요.";


    public static int inputMovieId() {
        try {
            System.out.println(INPUT_MOVIE_ID_MESSAGE);
            int moveId = InputValidator.validateInteger(scanner.nextLine());
            MovieService.validateMovieId(moveId);
            return moveId;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }
}
