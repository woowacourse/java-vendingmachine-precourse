package vendingmachine.model.drink;

import java.util.List;
import java.util.NoSuchElementException;

import vendingmachine.util.ErrorMessage;

public class Drinks {
    private final List<Drink> drinkInventory;

    public Drinks(String inputContents, DrinkMapper mapper) {
        drinkInventory = mapper.createDrinks(inputContents);
    }

    public Drink findMinPriceDrink() {
        return drinkInventory.stream()
            .min(Drink::compareTo)
            .orElseThrow(() -> new NoSuchElementException(ErrorMessage.DRINK_NO_SUCH_MIN_PRICE_ERROR));
    }

    public Drink findByDrinkName(String name) {
        return drinkInventory.stream()
            .filter(drink -> drink.isSameDrink(name))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException(ErrorMessage.CHOICE_DRINK_NO_SUCH_ERROR));
    }
}
