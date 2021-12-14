package vendingmachine.coin;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count;

    Coin(final int amount) {
        this.amount = amount;
        this.count = 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCoin() {
        this.count++;
    }

    @Override
    public String toString() {
        return this.getAmount() + "원 - " + this.getCount() + "개";
    }
}
