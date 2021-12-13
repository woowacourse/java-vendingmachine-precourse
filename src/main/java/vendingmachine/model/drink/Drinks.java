package vendingmachine.model.drink;

import java.util.List;

import vendingmachine.model.user.ChoiceDrink;
import vendingmachine.model.user.UserMoney;
import vendingmachine.util.Message;

public class Drinks {
    private final List<Drink> drinkInventory;

    public Drinks(String inputContents, DrinkMapper mapper) {
        drinkInventory = mapper.createDrinks(inputContents);
    }

    public Drink findByDrinkName(ChoiceDrink choiceDrink) {
        return drinkInventory.stream()
            .filter(drink -> drink.isSameDrink(choiceDrink.getName()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Message.CHOICE_DRINK_NO_SUCH_ERROR));
    }

    public Drink isMoneyOverMinPriceDrink(UserMoney money) {
        return drinkInventory.stream()
            .min(Drink::compareTo)
            .filter(money::canBuy)
            .orElseThrow(() -> new IllegalArgumentException(Message.USER_MONEY_MIN_ERROR));
    }

    public boolean isBuyContinue(UserMoney userMoney) {
        return drinkInventory.stream()
            .filter(Drink::hasQuantity).anyMatch(userMoney::canBuy);
    }
}
