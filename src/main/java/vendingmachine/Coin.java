package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int numberOfCoin;

    Coin(final int amount) {
        this.amount = amount;
    }

    public void setNumberOfCoin(int numberOfCoin) {
        this.numberOfCoin = numberOfCoin;
    }

}
