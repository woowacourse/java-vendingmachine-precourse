package vendingmachine.Model;

import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int requiredNumber(int money) {
        return money / this.amount;
    }

    public int totalAmount(int number) {
        return number * this.amount;
    }

    public List<Integer> addAmountToList(List<Integer> coinAmountList) {
        coinAmountList.add(this.amount);
        return coinAmountList;
    }
}
