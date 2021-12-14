package vendingmachine.domain.coin;

public enum Coin {
    COIN_500(500,"500원"),
    COIN_100(100, "100원"),
    COIN_50(50, "50원"),
    COIN_10(10, "10원");

    private final int amount;
    private final String name;

    Coin(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public int countCoin(int totalAmount) {
        int count = 0;
        while (totalAmount >= amount) {
            count++;
            totalAmount -= amount;
        }
        return count;
    }

    public int countReducedAmount(int totalAmount) {
        while (totalAmount >= amount) {
            totalAmount -= amount;
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return name;
    }
}
