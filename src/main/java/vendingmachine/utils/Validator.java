package vendingmachine.utils;
import vendingmachine.utils.ExceptionMessage;

public class Validator {
    private static final int PRODUCT_INFORMATION_SIZE = 3;
    private static final int DEFAULT = 0;
    private static final int MIN_LIMIT_PRICE = 100;
    private static final int DIVIDED = 10;

    public static void validateNumber(String target){
        if(!target.matches("[0-9]+")) throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER);
    }

    public static void validateProductPrice(String target) {
        if(Integer.parseInt(target) < MIN_LIMIT_PRICE || (Integer.parseInt(target) % DIVIDED) != DEFAULT) throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_PRICE);
    }
}
