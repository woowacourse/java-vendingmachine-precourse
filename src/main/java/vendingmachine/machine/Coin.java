package vendingmachine.machine;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100,0),
    COIN_50(50,0),
    COIN_10(10,0);

    private final int amount;
    public int number;

    Coin(final int amount, int number) {
        this.amount = amount;
        this.number = number;
    }

    public void setCoinNumber() {
        this.number++;
    }
}
