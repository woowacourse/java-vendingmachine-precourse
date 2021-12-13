package vendingmachine.model.coin;

import vendingmachine.util.Constant;

public class CoinType {
    private final Coin type;
    private int amount;

    public CoinType(Coin type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public int maxAmount(int money) {
        return Math.min(money / type.getAmount(), amount);
    }

    public Coin getType() {
        return type;
    }

    public void decAmount(int useAmount) {
        this.amount -= useAmount;
    }

    @Override
    public String toString() {
        return String.format(Constant.COIN_TYPE_FORMAT, type, amount);
    }
}
