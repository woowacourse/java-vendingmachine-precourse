package vendingmachine.exception;

import static vendingmachine.constant.Error.ERROR_INPUT_INT;
import static vendingmachine.constant.Error.ERROR_INPUT_INT_BIGGER_0;

public class PriceValidator {
    public static void validatePrice(String input){
        validateInt(input);
        validateBiggerThanZERO(input);
    }


    public static void validateInt(String input){
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_INT);
        }
    }
    public static void validateBiggerThanZERO(String input){
        if (Integer.parseInt(input)<0){
            throw new IllegalArgumentException(ERROR_INPUT_INT_BIGGER_0);
        }
    }
}
