package vendingmachine.model.user;

import vendingmachine.model.drink.Drink;
import vendingmachine.util.Constant;

public class UserMoney {
    private int amount;

    public UserMoney(String inputMoney) {
        new UserMoneyValidator(inputMoney);
        this.amount = Integer.parseInt(inputMoney);
    }

    public void decAmount(Drink drink) {
        amount -= drink.getPrice();
    }

    public boolean canBuy(Drink price) {
        return this.amount >= price.getPrice();
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format(Constant.COIN_UNIT, amount);
    }
}
