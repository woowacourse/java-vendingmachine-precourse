package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean matchAmount(int asset) {
        return this.amount == asset;
    }

    public Integer calculateTotalAmount(Integer coinCount) {
        return this.amount * coinCount;
    }

    public Integer calculateMaxCoinCount(int insertedMoney, int coinCount) {
        if (calculateTotalAmount(coinCount) > insertedMoney) {
            coinCount = getMaxCountByInsertedMoney(insertedMoney);
        }
        return coinCount;
    }

    private Integer getMaxCountByInsertedMoney(int insertedMoney) {
        return insertedMoney / this.amount;
    }
}
