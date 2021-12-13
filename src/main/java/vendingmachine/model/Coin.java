package vendingmachine.model;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static int getMin() {
        int min = (int)Double.POSITIVE_INFINITY;
        for (Coin coin:
        Coin.values()) {
            if (coin.amount < min) {
                min = coin.amount;
            }
        }
        return min;
    }

}
