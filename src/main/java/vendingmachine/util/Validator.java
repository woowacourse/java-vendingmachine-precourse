package vendingmachine.util;

import java.util.StringTokenizer;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String INVALID_AMOUNT_INPUT_MESSAGE = "금액은 숫자여야 합니다.";
    private static final String ALLOWED_AMOUNT_INPUT_FORMAT = "^[1-9][0-9]*[0]$";

    public static int validateAmountInput(String input) {
        if (!input.matches(ALLOWED_AMOUNT_INPUT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_AMOUNT_INPUT_MESSAGE + RETRY_MESSAGE);
        }

        return Integer.parseInt(input);
    }

    public static String validateProductInput(String input) {
        return "";
    }

}
