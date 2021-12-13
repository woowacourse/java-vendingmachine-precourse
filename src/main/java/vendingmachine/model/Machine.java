package vendingmachine.model;

import vendingmachine.model.drink.Drink;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.ChoiceDrink;
import vendingmachine.model.user.UserMoney;

public class Machine {
    private final Drinks drinkInventory;
    private UserMoney money;

    public Machine(Drinks drinks, UserMoney userMoney) {
        this.drinkInventory = drinks;
        this.money = userMoney;
    }

    public void buy(ChoiceDrink choiceDrink) {
        Drink buyItem = drinkInventory.findByDrinkName(choiceDrink);
        if (money.canBuy(buyItem)) {
            money.decAmount(buyItem);
            buyItem.decQuantity();
        }
    }

    public boolean isContinue() {
        return drinkInventory.isBuyContinue(money);
    }

    public String toMoney() {
        return money.toString();
    }
}
