package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Maps;
import vendingmachine.enums.Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Change {
    private final int amount;
    private final List<Integer> coins;

    public Change(int amount) {
        this.amount = amount;
        coins = makeCoins(amount);
    }

    private List<Integer> makeCoins(int amount) {
        List<Integer> coins = new ArrayList<>(4);
        while (amount != 0) {
            int coin = getUnderAmountCoin(amount);
            int coinIndex = Coin.getIndex(coin);
            coins.set(coinIndex,coins.get(coinIndex)+1);
            amount -= coin;
        }
        return coins;
    }
    private int getUnderAmountCoin(int amount){
        int coin = Coin.getRandomCoin();
        while( amount < coin){
            coin = Coin.getRandomCoin();
        }
        return coin;
    }


}
