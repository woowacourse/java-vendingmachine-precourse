package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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

        Map<Coin, Integer> sortedCoins = new TreeMap<>(Comparator.comparing(Coin::getAmount).reversed());
        sortedCoins.putAll(coins);

        return sortedCoins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}
