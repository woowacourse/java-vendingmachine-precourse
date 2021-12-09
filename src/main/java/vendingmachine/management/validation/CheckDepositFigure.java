package vendingmachine.management.validation;

public class CheckDepositFigure {
    private static final String ERROR_MESSAGE_FIGURE = "[ERROR] 금액은 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_POSITIVE_NUMBER = "[ERROR] 금액은 0보다 커야 합니다.";

    public static int validationFigure(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FIGURE);
        }
        return Integer.parseInt(input);
    }
    
    public static void validationPositiveNumber(int deposit) {
        if(deposit <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_POSITIVE_NUMBER);
        }
    }
            
}
