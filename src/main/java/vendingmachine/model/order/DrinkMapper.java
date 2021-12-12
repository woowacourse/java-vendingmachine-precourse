package vendingmachine.model.order;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.util.Constant;

public class DrinkMapper {

    public List<Drink> createDrinks(String inputDrinks) {
        List<Drink> drinks = new ArrayList<>();
        removeBracket(inputDrinks);
        String[] contents = splitDrinks(inputDrinks);
        for (String content : contents) {
            String[] drink = content.split(Constant.DRINK_CONTENT_SPLIT_WORD);
            drinks.add(createDrink(drink));
        }
        return drinks;
    }

    private void removeBracket(String inputDrinks) {
        inputDrinks.replaceAll(Constant.OPEN_SQUARE_BRACKET, Constant.CHANGE_BRACKET_TO_GAP);
        inputDrinks.replaceAll(Constant.CLONE_SQUARE_BRACKET, Constant.CHANGE_BRACKET_TO_GAP);
    }

    private String[] splitDrinks(String drinks) {
        String[] inventoryDrinks = drinks.split(Constant.DRINK_SPLIT_WORD);
        return inventoryDrinks;
    }

    private Drink createDrink(String[] content) {
        return new Drink(content[Constant.NAME_INDEX],
            content[Constant.PRICE_INDEX],
            content[Constant.QUANTITY_INDEX]);
    }
}
