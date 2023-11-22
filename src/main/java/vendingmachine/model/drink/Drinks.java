package vendingmachine.model.drink;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static vendingmachine.model.constants.Delimiter.DRINK_DETAIL_DELIMITER_COMMA;
import static vendingmachine.model.constants.Delimiter.DRINK_TYPE_DELIMITER_SEMICOLON;
import static vendingmachine.model.constants.Index.DRINK_COUNT_INDEX;
import static vendingmachine.model.constants.Index.DRINK_PRICE_INDEX;
import static vendingmachine.model.constants.Index.DRINK_TYPE_INDEX;

public class Drinks {
    List<Drink> drinks = new ArrayList<>();

    public Drinks(String inputDrink) {
        String[] drinkTypes = inputDrink.split(DRINK_TYPE_DELIMITER_SEMICOLON);

        for(int i=0; i<drinkTypes.length; i++){
            String[] drinkDetail = drinkTypes[i].split(DRINK_DETAIL_DELIMITER_COMMA);
            String drinkType = drinkDetail[DRINK_TYPE_INDEX];
            Integer drinkPrice = Integer.parseInt(drinkDetail[DRINK_PRICE_INDEX]);
            Integer drinkCount = Integer.parseInt(drinkDetail[DRINK_COUNT_INDEX]);

            drinks.add(new Drink(drinkType, drinkPrice, drinkCount));
        }
    }

    public Integer cheapestDrink() {
        Comparator<Drink> comparatorByAge = Comparator.comparingInt(Drink::getPrice);

        Drink cheapestDrink = drinks.stream()
                .min(comparatorByAge).orElseThrow(NoSuchElementException::new);
        return cheapestDrink.getPrice();
    }

    public int getPriceFindByName(String purchaseDrinkType) {
        for (Drink drink : drinks) {
            if (Objects.equals(drink.getName(), purchaseDrinkType)) {
                return drink.getPrice();
            }
        }
        return 0;
    }
}
