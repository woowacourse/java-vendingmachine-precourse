package vendingmachine.management.validation;

public class CheckCommodityPrice {
    private static final String ERROR_MESSAGE_FIGURE = "[ERROR] 가격이 숫자가 아닙니다.";
    private static final String ERROR_MESSAGE_LESS_THAN_HUNDRED = "[ERROR] 가격이 100원보다 작습니다.";
    private static final String ERROR_MESSAGE_UNIT = "[ERROR] 가격은 10으로 나누어 떨어져야 합니다.";
    
    public static void validationFigure(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FIGURE);
        }
    }

    public static void validationRange(int number) {
        if(number < 100) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LESS_THAN_HUNDRED);
        }
    }
    
    public static void validationUnit(int number) {
        if(number%10 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIT);
        }
    }
}
