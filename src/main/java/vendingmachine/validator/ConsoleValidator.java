package vendingmachine.validator;

public class ConsoleValidator {
    public int checkNumeric(String input) {
        checkEmptyString(input);
        if (!isNumeric(input.charAt(0)) && input.charAt(0) != '+' && input.charAt(0) != '-') {
            throwIllegalArgumentException("금액은 숫자여야 합니다.");
        }
        for (int i = 1; i < input.length() - 1; i++) {
            if (!isNumeric(input.charAt(i))) {
                throwIllegalArgumentException("금액은 숫자여야 합니다.");
            }
        }
        return Integer.parseInt(input);
    }

    public void checkEmptyString(String input) {
        if (input.length() == 0) {
            throwIllegalArgumentException("금액에 공백없이 입력해주세요.");
        }
    }

    private void throwIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    private boolean isNumeric(char ch) {
        return ('0' <= ch && ch <= '9');
    }
}
