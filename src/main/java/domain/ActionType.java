package domain;

import java.util.Arrays;

public enum ActionType {
    PAY("1"),
    RESERVE("2");

    private String text;
    private static final String MENU_ERROR = "잘못 입력하셨습니다.";

    ActionType(String text) {
        this.text = text;
    }

    public static ActionType of(String input) {
        return Arrays.stream(ActionType.values())
                .filter(menu -> menu.text.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MENU_ERROR));
    }
}
