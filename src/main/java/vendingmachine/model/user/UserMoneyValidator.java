package vendingmachine.model.user;

import vendingmachine.model.drink.Drink;
import vendingmachine.model.drink.Drinks;
import vendingmachine.util.ErrorMessage;
import vendingmachine.util.exception.MoneyValidator;

public class UserMoneyValidator extends MoneyValidator {

    public UserMoneyValidator(String money, Drinks drinks) {
        moneyValid(money);
        overMinPrice(toInt(money), drinks);
    }

    @Override
    public void moneyValid(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.USER_MONEY_STRING_ERROR);
        }
        if (!isUnitSplit(toInt(money))) {
            throw new IllegalArgumentException(ErrorMessage.USER_MONEY_UNIT_ERROR);
        }
    }

    private void overMinPrice(int money, Drinks drinks) {
        Drink minPrice = drinks.findMinPriceDrink();
        if (!minPrice.isOverPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.USER_MONEY_NEED_MORE_MONEY);
        }
    }
}
