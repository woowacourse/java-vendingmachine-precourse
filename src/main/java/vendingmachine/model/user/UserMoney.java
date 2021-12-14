package vendingmachine.model.user;

import vendingmachine.util.Constant;

public class UserMoney {
    private int amount;

    public UserMoney(String inputMoney) {
        new UserMoneyValidator(inputMoney);
        this.amount = Integer.parseInt(inputMoney);
    }

    public void decAmount(int sellPrice) {
        amount -= sellPrice;
    }

    public boolean canBuy(int price) {
        return this.amount >= price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format(Constant.COIN_UNIT, amount);
    }
}
