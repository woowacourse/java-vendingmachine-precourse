package vendingmachine.Model;

import java.util.List;

public class Coins {
    private List<CoinPair> coins;

    public Coins(List<CoinPair> coinPairs) {
        this.coins = coinPairs;
    }

    public List<CoinPair> getCoins() {
        return coins;
    }
}
