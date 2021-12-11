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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void addCoin(Coin coin, int count) {
        totalAmount += coin.getAmount() * count;
        remainingCoin.replace(coin, remainingCoin.get(coin) + count);
    }

    public void removeCoin(Coin coin, int count) {
        if (count > this.getCoinCount(coin)) {
            throw new NotEnoughStockException(ErrorMessage.NOT_ENOUGH_STOCK.getCompleteMessage());
        }
        totalAmount -= coin.getAmount() * count;
        remainingCoin.replace(coin, remainingCoin.get(coin) - count);
    }

    public int getCoinCount(Coin coin) {
        return remainingCoin.get(coin);
    }

    public void moveCoin(Coin coin, int count, Coins destCoins) {
        this.removeCoin(coin, count);
        destCoins.addCoin(coin, count);
    }
}
