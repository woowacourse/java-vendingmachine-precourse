package vendingmachine.model.drink;

import vendingmachine.util.Constant;
import vendingmachine.util.ErrorMessage;

public class DrinkValidator {

    public DrinkValidator(String name, String price, String quantity) {
        nameValid(name);
        priceValid(price);
        quantityValid(quantity);
    }

    private void priceValid(String price) {
        isEmpty(price);
        if (!isNumeric(price)) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_STRING_ERROR);
        }
        int priceInt = Integer.parseInt(price);
        priceRangeValid(priceInt);
        unitSplit(priceInt);
    }

    private void nameValid(String name) {
        isEmpty(name);
        isString(name);
    }

    private void quantityValid(String quantity) {
        isEmpty(quantity);
        if (!isNumeric(quantity)) {
            throw new IllegalArgumentException(ErrorMessage.QUANTITY_STRING_ERROR);
        }
        quantityRangeValid(Integer.parseInt(quantity));
    }

    private void priceRangeValid(int price) {
        if (price < Constant.PRICE_MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MIN_VALUE_ERROR);
        }
    }

    private void quantityRangeValid(int quantity) {
        if (quantity < Constant.QUANTITY_MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.QUANTITY_MIN_VALUE_ERROR);
        }
    }

    private void unitSplit(int price) {
        if (price % Constant.UNIT_VALUE != Constant.REST_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNIT_ERROR);
        }
    }

    private boolean isNumeric(String drinkValue) {
        try {
            Integer.parseInt(drinkValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isEmpty(String drinkValue) {
        if (drinkValue.isEmpty())
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR);
        return false;
    }

    private boolean isString(String name) {
        if (isNumeric(name)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NUMBER_ERROR);
        }
        return true;
    }
}
