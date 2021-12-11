package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }
    // 추가 기능 구현
    public int getAmount() {
        return this.amount;
    }
    public int getCount() {
        return this.count;
    }

    public static void makeRandom(int money) {
        for (Coin coin : Coin.values()) {
            int endNumber = money / coin.amount;
            if (endNumber != 0 && coin.amount != 10) {
                coin.count = Randoms.pickNumberInRange(0,endNumber);
                money -= (coin.count * coin.amount);
            }
            if(coin.amount == 10) {
                coin.count = money / coin.amount;
            }
        }
    }
}
