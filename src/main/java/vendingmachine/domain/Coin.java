package vendingmachine.domain;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private final String coinUnit = "원 - ";
    private int count;
    private final String countUnit = "개";

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }
    // 추가 기능 구현

    public int getAmount() {
        return amount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return amount + coinUnit + count + countUnit;
    }
}
