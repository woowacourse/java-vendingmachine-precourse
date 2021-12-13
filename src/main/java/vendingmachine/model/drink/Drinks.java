package vendingmachine.model.drink;

import java.util.List;
import java.util.NoSuchElementException;

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
            .orElseThrow(() -> new NoSuchElementException(Message.CHOICE_DRINK_NO_SUCH_ERROR));
    }

    public boolean isBuyContinue(UserMoney userMoney) {
        return drinkInventory.stream()
            .filter(Drink::hasQuantity).anyMatch(userMoney::canBuy);
    }
}
