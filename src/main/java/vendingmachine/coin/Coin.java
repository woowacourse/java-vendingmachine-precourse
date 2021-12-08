package vendingmachine.coin;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int counts;

    Coin(final int amount) {
        this.amount = amount;
        this.counts = 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getCounts() {
        return counts;
    }

    public void plusCoin() {
        this.counts++;
    }

    @Override
    public String toString() {
        return amount + "원 - " + counts + "개";
    }
}
