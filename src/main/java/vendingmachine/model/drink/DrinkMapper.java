package vendingmachine.model.drink;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vendingmachine.util.Constant;
import vendingmachine.util.Message;

public class DrinkMapper {

    public List<Drink> createDrinks(String inputDrinks) {
        List<Drink> drinks = new ArrayList<>();
        String[] contents = splitDrinks(inputDrinks);
        validNames(contents);

        for (String content : contents) {
            String drinkContent = removeBracket(content);
            String[] drink = drinkContent.split(Constant.DRINK_CONTENT_SPLIT_WORD);
            drinks.add(createDrink(drink));
        }
        return drinks;
    }

    private String removeBracket(String inputDrinks) {
        String inputDrink = inputDrinks.replace(Constant.OPEN_SQUARE_BRACKET, Constant.CHANGE_BRACKET_TO_GAP);
        inputDrink = inputDrink.replace(Constant.CLOSE_SQUARE_BRACKET, Constant.CHANGE_BRACKET_TO_GAP);
        return inputDrink;
    }

    private String[] splitDrinks(String drinks) {
        String[] inventoryDrinks = drinks.split(Constant.DRINK_SPLIT_WORD);
        return inventoryDrinks;
    }

    private Drink createDrink(String[] content) {
        if (content.length != Constant.CHECK_ARR_HAS_ALL_CONTENT)
            throw new IllegalArgumentException(Message.DRINK_CONTENT_ERROR);

        return new Drink(content[Constant.NAME_INDEX].trim(),
            content[Constant.PRICE_INDEX].trim(),
            content[Constant.QUANTITY_INDEX].trim());
    }

    private boolean isDuplicationName(String[] contents) {
        Set<String> names = new HashSet<>();
        for (String content : contents) {
            int nameLength = content.indexOf(Constant.DRINK_CONTENT_SPLIT_WORD);
            names.add(content.substring(Constant.NAME_INDEX, nameLength));
        }
        return names.size() != contents.length;
    }

    private void validNames(String[] names) {
        if (isDuplicationName(names)) {
            throw new IllegalArgumentException(Message.DRINK_CONTENT_DUPLICATION_ERROR);
        }
    }
}
