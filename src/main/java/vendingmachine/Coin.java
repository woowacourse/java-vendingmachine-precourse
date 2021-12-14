package vendingmachine;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int numberOfCoins;

    Coin(final int amount, int numberOfCoins) {
        this.amount = amount;
        this.numberOfCoins = numberOfCoins;
    }

    public int getAmount() {
        return amount;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }
}
