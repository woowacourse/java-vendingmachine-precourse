package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Random;

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
        ArrayList<Integer> coinList = new ArrayList<Integer>();
        for (Coin coin : Coin.values()) {
            coinList.add(coin.amount);
        }
        while (money != 0) {
            int randomCoin = Randoms.pickNumberInList(coinList);
            if (money - randomCoin >= 0) {
                money -= randomCoin;
                setCountByAmount(randomCoin);
            }
        }
    }

    public static int totalAmount() {
        int totalAmount = 0;
        for (Coin coin : Coin.values()) {
            totalAmount += (coin.amount * coin.count);
        }
        return totalAmount;
    }

    public static void setCountByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (amount == coin.amount) {
                coin.count += 1;
            }
        }
    }
}
