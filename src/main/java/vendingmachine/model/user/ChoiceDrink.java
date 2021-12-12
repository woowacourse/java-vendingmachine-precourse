package vendingmachine.model.user;

import vendingmachine.model.drink.Drink;
import vendingmachine.model.drink.Drinks;
import vendingmachine.util.ErrorMessage;

public class ChoiceDrink {

    private final Drink choiceDrink;

    public ChoiceDrink(String buyDrink, Drinks drinks) {
        choiceDrink = drinks.findByDrinkName(buyDrink);

        if (!choiceDrink.hasQuantity()) {
            throw new IllegalArgumentException(ErrorMessage.CHOICE_DRINK_EMPTY_ERROR);
        }
    }
}
