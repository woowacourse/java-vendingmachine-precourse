package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count = 0;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void increaseCount() {
        this.count++;
    }

    public void printCoinInfo() {
        System.out.println(amount + "원 - " + count + "개");
    }

    public int returnCoin(int userAmount) {
        int returnCount = getReturnCount(userAmount);

        decreaseCount(returnCount);
        userAmount -= returnCount * amount;

        if (returnCount > 0) {
            printCoinInfo();
        }

        return userAmount;
    }

    private int getReturnCount(int userAmount) {
        return Math.min(userAmount / amount, count);
    }

    private void decreaseCount(int count) {
        this.count -= count;
    }
}
