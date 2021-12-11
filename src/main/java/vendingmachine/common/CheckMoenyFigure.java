package vendingmachine.common;

public class CheckMoenyFigure {
    private static final String ERROR_MESSAGE_FIGURE = "[ERROR] 금액은 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_POSITIVE_NUMBER = "[ERROR] 금액은 10원 이상이어야 합니다.";
    private static final String ERROR_MESSAGE_UNIT = "[ERROR] 금액은 10으로 나누어 떨어져야 합니다.";

    public static void validationFigure(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FIGURE);
        }
    }
    
    public static void validationPositiveNumber(int deposit) {
        if(deposit < 10) {
            throw new IllegalArgumentException(ERROR_MESSAGE_POSITIVE_NUMBER);
        }
    }
    
    public static void validationUnit(int deposit) {
        if(deposit%10 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIT);
        }
    }
            
}
