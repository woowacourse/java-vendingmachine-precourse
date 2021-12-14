package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final Coin[] COINLIST = Coin.values();
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin[] getCoinList() {
        return COINLIST;
    }

    public static Coin getRandomCoin(int randomNumber) {
        return COINLIST[randomNumber];
    }
}
