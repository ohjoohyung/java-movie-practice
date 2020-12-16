package utils;

public class InputValidator {
    private static final String INCORRECT_NUMBER_ERROR = "[ERROR] 영화 번호로 숫자를 입력해주세요.";

    private InputValidator() {

    }

    public static void validateMovieId() {

    }

    public static int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
        }
    }

//    public static void validate




}
