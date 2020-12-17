package domain;

import java.util.Arrays;

public enum PayType {
    CARD("1"),
    CASH("2");

    private String text;
    private static final String PAY_TYPE_ERROR = "결제 수단을 잘못 입력하셨습니다.";
    PayType(String text) {
        this.text = text;
    }

    public static PayType of(String input) {
        return Arrays.stream(PayType.values())
                .filter(pay -> pay.text.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PAY_TYPE_ERROR));
    }
}
