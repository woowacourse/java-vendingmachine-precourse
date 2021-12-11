package vendingmachine.management.validation;

public class CheckCommodityQuantity {
    private static final String ERROR_MESSAGE_FIGURE = "[ERROR] 수량이 숫자가 아닙니다.";
    private static final String ERROR_MESSAGE_RANGE = "[ERROR] 수량은 0개 이상이어야 합니다.";
    
    public static void validationFigure(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FIGURE);
        }
    }

    public static void validationRange(int number) {
        if(number < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        }
    }
}
