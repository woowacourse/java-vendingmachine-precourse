package vendingmachine.model;

import vendingmachine.model.drink.Drink;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.ChoiceDrink;
import vendingmachine.model.user.UserMoney;
import vendingmachine.util.Message;

public class Machine {
    private final Drinks drinkInventory;
    private UserMoney money;

    public Machine(Drinks drinks, UserMoney userMoney) {
        this.drinkInventory = drinks;
        this.money = userMoney;
    }

    public void buy(ChoiceDrink choiceDrink) {
        Drink buyItem = drinkInventory.findByDrinkName(choiceDrink);
        if (!buyItem.canSell(money)) {
            throw new IllegalArgumentException(Message.USER_MONEY_OVER_ERROR);
        }
        if (!buyItem.hasQuantity()) {
            throw new IllegalArgumentException(Message.DRINK_SOLD_OUT_ERROR);
        }

        buyItem.sellDrink(money);
        buyItem.decQuantity();
    }

    public boolean isContinue() {
        return drinkInventory.isBuyContinue(money);
    }

    public String toMoney() {
        return money.toString();
    }
}
