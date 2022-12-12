package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int get() {
        return amount;
    }

    public static Coin getEqualCoin(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.amount == amount) {
                return coin;
            }
        }
        return null;
    }

}
