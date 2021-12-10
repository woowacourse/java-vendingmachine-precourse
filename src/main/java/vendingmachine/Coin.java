package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count = 0;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
