package vendingmachine.model.drink;

import java.util.List;

public class Drinks {
    List<Drink> drinkInventory;

    public Drinks(String inputContents, DrinkMapper mapper) {
        drinkInventory = mapper.createDrinks(inputContents);
    }
}
