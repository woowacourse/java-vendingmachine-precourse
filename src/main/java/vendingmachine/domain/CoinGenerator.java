package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import vendingmachine.Coin;

public class CoinGenerator {
    private final Map<Coin,Integer> coins;

    public CoinGenerator(int money) {
        this.coins = generate(money);
    }

    private Map<Coin,Integer> generate(int money){
        Map<Coin, Integer> coins = new HashMap<>();

        while(money > 0){
            Coin randomCoin = Coin.values()[Randoms.pickNumberInRange(0, Coin.values().length-1)];

            if(randomCoin.getAmount() <= money){
                coins.put(randomCoin, coins.getOrDefault(randomCoin,0) + 1);
                money -= randomCoin.getAmount();
            }
        }

        return coins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}
