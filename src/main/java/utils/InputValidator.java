package utils;

public class InputValidator {
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final String INCORRECT_NUMBER_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private static final String MENU_ERROR = "[ERROR] 숫자는 1 또는 2를 입력해주세요.";

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

    public static int validateMenuNumber(String menuNumber) {
        int menu = validateInteger(menuNumber);
        if (menu != FIRST && menu != SECOND) {
            throw new IllegalArgumentException(MENU_ERROR);
        }
        return menu;
    }

//    public static void validate




}
