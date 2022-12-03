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
    private final Map<Coin, Integer> coins;

    public Change(int amount) {
        this.amount = amount;
        coins = makeCoins(amount);
    }

    private Map<Coin, Integer> makeCoins(int amount) {
        Map<Coin, Integer> coins = new HashMap<>();
        while (amount != 0) {
            int coin = getUnderAmountCoin(amount);
            coins.put(Coin.getCoin(coin), coin);
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
