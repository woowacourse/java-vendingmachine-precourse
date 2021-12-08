package vendingmachine;

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

    // 추가 기능 구현
    public int getValue() {
        return amount;
    }
    public void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
