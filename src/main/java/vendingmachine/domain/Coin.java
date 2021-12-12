package vendingmachine.domain;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private final String postfix = "원";

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getValue(){ return amount; }

    @Override
    public String toString() {
        return amount + postfix;
    }
}
