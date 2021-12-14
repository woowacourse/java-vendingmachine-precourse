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

    public void moneyOverMinPriceDrink(UserMoney money) {
        Drink minPriceDrink = drinkInventory.stream()
            .min(Drink::compareTo)
            .orElseThrow(() -> new IllegalArgumentException(Message.USER_MONEY_MIN_ERROR));

        if (!minPriceDrink.canSell(money)) {
            throw new IllegalArgumentException(Message.USER_MONEY_MIN_ERROR);
        }
    }

    public boolean isBuyContinue(UserMoney userMoney) {
        return drinkInventory.stream()
            .filter(Drink::hasQuantity).anyMatch(drink -> drink.canSell(userMoney));
    }
}
