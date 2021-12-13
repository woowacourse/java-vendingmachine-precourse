package vendingmachine.model.drink;

import vendingmachine.util.Constant;
import vendingmachine.util.Message;
import vendingmachine.util.exception.MoneyValidator;

public class DrinkValidator extends MoneyValidator {

    public DrinkValidator(String name, String price, String quantity) {
        nameValid(name);
        moneyValid(price);
        quantityValid(quantity);
    }

    private void nameValid(String name) {
        isEmpty(name);
        isString(name);
    }

    @Override
    public void moneyValid(String price) {
        isEmpty(price);
        if (!isNumeric(price)) {
            throw new IllegalArgumentException(Message.PRICE_STRING_ERROR);
        }
        if (!isRangeValid(toInt(price), Constant.PRICE_MIN_VALUE)) {
            throw new IllegalArgumentException(Message.PRICE_MIN_VALUE_ERROR);
        }
        if (!isUnitSplit(toInt(price))) {
            throw new IllegalArgumentException(Message.PRICE_UNIT_ERROR);
        }
    }

    private void quantityValid(String quantity) {
        isEmpty(quantity);
        if (!isNumeric(quantity)) {
            throw new IllegalArgumentException(Message.QUANTITY_STRING_ERROR);
        }
        quantityRangeValid(Integer.parseInt(quantity));
    }

    private void quantityRangeValid(int quantity) {
        if (quantity < Constant.QUANTITY_MIN_VALUE) {
            throw new IllegalArgumentException(Message.QUANTITY_MIN_VALUE_ERROR);
        }
    }

    private boolean isEmpty(String drinkValue) {
        if (drinkValue.isEmpty())
            throw new IllegalArgumentException(Message.EMPTY_ERROR);
        return false;
    }

    private boolean isString(String name) {
        if (isNumeric(name)) {
            throw new IllegalArgumentException(Message.NAME_NUMBER_ERROR);
        }
        return true;
    }
}
