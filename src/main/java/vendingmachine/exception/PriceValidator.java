package vendingmachine.exception;

import static vendingmachine.constant.Error.ERROR_INPUT_INT;

public class PriceValidator {
    public static void validateInt(String input){
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_INT);
        }
    }
}
