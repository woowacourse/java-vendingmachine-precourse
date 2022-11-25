package vendingmachine.domain;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    NONE(-1);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    // 추가 기능 구현
    public static Coin coinMapper(int money) {
        for (Coin coin : Coin.values()) {
            if (isMatchingCoin(coin, money)){
                return coin;
            }

        }
        return NONE;
    }

    private static boolean isMatchingCoin(Coin coin, int money){
        if (coin.amount() == money)
            return true;
        return false;
    }
}
