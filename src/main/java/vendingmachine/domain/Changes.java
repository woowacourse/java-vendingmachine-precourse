package vendingmachine.domain;

import vendingmachine.domain.enums.Coin;
import vendingmachine.utils.ExceptionMessage;

import java.util.HashMap;
import java.util.Map;

class Changes {
    private Map<Coin, Integer> coinMap = new HashMap<>();
    private int totalChange;

    public Changes(String input) {
        this.totalChange = validateChange(input);
    }

    private int validateChange(String input){
        int change = isNumber(input);
        isDivideByTen(change);
        return change;
    }

    private void isDivideByTen(int change) {
        if(change % Coin.COIN_10.getAmount() != 0){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_PRICE_NOT_DIVIDE_BY_TEN);
        }
    }

    private int isNumber(String input) {
        try{
           return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_PRICE_NOT_NUMBER);
        }
    }
}
