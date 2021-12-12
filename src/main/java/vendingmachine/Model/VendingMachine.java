package vendingmachine.Model;

import vendingmachine.Constant.Constant;
import vendingmachine.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private Coins coins;
    private List<Drink> drinks;

    public VendingMachine(Coins coins, List<Drink> drinks) {
        this.coins = coins;
        this.drinks = drinks;
    }

    public boolean isDrinkInList(String drinkName) {
        List<String> drinkNames = new ArrayList<>();
        for (Drink drink : drinks) {
            drink.addNameToList(drinkNames);
        }
        return drinkNames.contains(drinkName);
    }

    public boolean isEmpty() {
        int isEmpty = Constant.TRUE;
        for (Drink drink : drinks) {
            isEmpty *= drink.isEmpty();
        }
        return (isEmpty == Constant.TRUE);
    }

    public boolean isExistDrinkBelow(int remainMoney) {
        for (Drink drink : drinks) {
            if (drink.isCheaperThan(remainMoney) && !drink.isSoldOut()) {
                return true;
            }
        }
        return false;
    }

    public Drink findDrinkWithName(String userChoice) {
        List<String> drinkNames = new ArrayList<>();
        for (Drink drink : drinks) {
            drink.addNameToList(drinkNames);
        }
        return drinks.get(drinkNames.indexOf(userChoice));
    }

    public void calculateChange(User user, OutputView outputView) {
        user.requestChange(coins, outputView);
    }
}
