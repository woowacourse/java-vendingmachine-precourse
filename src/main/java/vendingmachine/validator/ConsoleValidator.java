package vendingmachine.validator;

public class ConsoleValidator {
    public int checkNumeric(String input) {
        checkEmptyString(input);
        for (char ch : input.toCharArray()) {
            if (!isNumeric(ch)) {
                throwIllegalArgumentException();
            }
        }
        return Integer.parseInt(input);
    }

    public void checkEmptyString(String input) {
        if (input.length() == 0) {
            throwIllegalArgumentException();
        }
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    private boolean isNumeric(char ch) {
        return ('0' <= ch && ch <= '9');
    }
}
