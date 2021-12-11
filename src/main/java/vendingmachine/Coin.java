package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    private int numberOfCoin;

    public void setNumberOfCoin(int numberOfCoin) {
        this.numberOfCoin = numberOfCoin;
    }

    public int getNumberOfCoin() {
        return numberOfCoin;
    }

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void PrintNumberOfCoin() {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getNumberOfCoin() + " - " + coin.getAmount() + "개");
        }
    }

// 추가 기능 구현
}
