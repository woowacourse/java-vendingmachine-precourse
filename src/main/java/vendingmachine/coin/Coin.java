package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int counts;

    Coin(final int amount) {
        this.amount = amount;
        this.counts = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void initCoins() {
        int currentAmount = 0;
        while (currentAmount < amount) {
            int coinPrice = pickRandomCoin(amount - currentAmount);
            currentAmount += coinPrice;
            Coin coin = getCoin(coinPrice);
            coin.counts++;
        }
    }

    public int pickRandomCoin(int balance) {
        List<Integer> coinList
                = Arrays.asList(COIN_500.amount, COIN_100.amount, COIN_50.amount, COIN_10.amount);
        List<Integer> coinSubList
                = new ArrayList<>(coinList.subList(findFirstIndex(balance), coinList.size()));
        return Randoms.pickNumberInList(coinSubList);
    }

    /*
    잔액에 따른 pickNumberInList() 메소드의 첫번째 인자를 결정짓는 메소드.
     */
    public int findFirstIndex(int balance) {
        if (balance >= COIN_500.amount) {
            return 0;
        }
        if (balance >= COIN_100.amount) {
            return 1;
        }
        if (balance >= COIN_50.amount) {
            return 2;
        }
        return 3;
    }

    public Coin getCoin(int price) {
        if (price == COIN_500.amount) {
            return COIN_500;
        }
        if (price == COIN_100.amount) {
            return COIN_100;
        }
        if (price == COIN_50.amount) {
            return COIN_50;
        }
        return COIN_10;
    }

    public int getCounts() {
        return counts;
    }
}
