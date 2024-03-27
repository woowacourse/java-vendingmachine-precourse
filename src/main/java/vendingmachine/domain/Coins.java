package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return this.coins;
    }

    public int getSumOfCoins() {
        return coins.entrySet().stream()
                .map(coin -> coin.getKey().getAmount() * coin.getValue())
                .reduce(0, Integer::sum);
    }

    public Coins calculateChange(int requestedChange) {
        Map<Coin, Integer> change = new HashMap<>();
        int remainingChange = requestedChange;

        int fiveHundredCount = Integer.min(coins.get(Coin.COIN_500), remainingChange/500);
        change.put(Coin.COIN_500, Integer.min(coins.get(Coin.COIN_500), remainingChange/500));
        remainingChange -= 500*fiveHundredCount;
        int hundredCount = Integer.min(coins.get(Coin.COIN_100), remainingChange/100);
        change.put(Coin.COIN_100, hundredCount);
        remainingChange -= 100*hundredCount;
        int fiftyCount = Integer.min(coins.get(Coin.COIN_50), remainingChange/50);
        change.put(Coin.COIN_50, fiftyCount);
        remainingChange -= 50*fiftyCount;
        int tenCount = Integer.min(coins.get(Coin.COIN_10), remainingChange/10);
        change.put(Coin.COIN_10, tenCount);

        return new Coins(change);
    }
}
