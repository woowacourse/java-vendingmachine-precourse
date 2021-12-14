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

    public int getAmount() {
        return this.amount;
    }

    public int getCount() {
        return this.count;
    }

    public void increaseCount(int times) {
        this.count += times;
    }

    public void decreaseCount(int times) {
        if (this.count <= times) {
            this.count = 0;
        }
        if (this.count > times) {
            this.count -= times;
        }
    }
}
