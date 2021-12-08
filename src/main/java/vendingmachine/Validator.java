package vendingmachine;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RETRY_MESSAGE = " 다시 입력해주세요.";
    private static final String INVALID_INPUT_AMOUNT_ERROR_MESSAGE = "금액은 숫자여야 합니다.";
    private static final String ALLOWED_INPUT_AMOUNT_FORMAT = "^[1-9][0-9]*[0]$";

    public static int validateAmount(String input) {
        if(!input.matches(ALLOWED_INPUT_AMOUNT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_AMOUNT_ERROR_MESSAGE + RETRY_MESSAGE);
        }

        return Integer.parseInt(input);
    }
}
