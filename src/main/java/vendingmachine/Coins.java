package vendingmachine;

import vendingmachine.exception.NotEnoughStockException;

import java.util.HashMap;
import java.util.Map;

public class Coins {

    int totalAmount = 0;

    private Map<Coin, Integer> remainingCoin = new HashMap<Coin, Integer>(){{
        put(Coin.COIN_10, 0);
        put(Coin.COIN_50, 0);
        put(Coin.COIN_100, 0);
        put(Coin.COIN_500, 0);
    }};

    public Coins() {}

    public int getCoinCount(Coin coin) {
        return remainingCoin.get(coin);
    }

}
