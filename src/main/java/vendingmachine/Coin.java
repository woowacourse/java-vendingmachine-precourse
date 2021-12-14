package vendingmachine;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }
}
