package vendingmachine.utils.validator;

import vendingmachine.domain.enums.Coin;
import vendingmachine.utils.ExceptionMessage;

public class ChangesValidator {
    public static final int RESULT = 0;


    public static int validateChange(String input){
        int change = isNumber(input);
        isDivideByTen(change);
        return change;
    }

    private static void isDivideByTen(int change) {
        if(change % Coin.COIN_10.getAmount() != RESULT){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_PRICE_NOT_DIVIDE_BY_TEN);
        }
    }

    private static int isNumber(String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_PRICE_NOT_NUMBER);
        }
    }
}
