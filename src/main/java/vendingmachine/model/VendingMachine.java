package vendingmachine.model;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.UserMoney;

import java.util.List;

public class VendingMachine {
    private Coins moneyBox;
    private Drinks drinks;

    public VendingMachine(Coins moneyBox, Drinks drinks) {
        this.moneyBox = moneyBox;
        this.drinks = drinks;
    }

    public List<Integer> showCoinBox() {
        return moneyBox.coinsCount();
    }

    public boolean hasMoneyMoreThenMinimumPrice(UserMoney userMoney) {
        return userMoney.getBalance() >= drinks.cheapestDrink();
    }

    public int getPrice(String purchaseDrinkType) {
        return drinks.getPriceFindByName(purchaseDrinkType);
    }
}
