package vendingmachine.domain;

import vendingmachine.constants.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinCount {
    private final Coin coin;
    private final int count;

    public CoinCount(Coin coin, int count) {
        this.coin = coin;
        this.count = count;
    }

    public static List<CoinCount> build(int money) {
        List<CoinCount> ret = new ArrayList<>();
        for (Coin c : Coin.getSortedCoins()) {
            ret.add(new CoinCount(c, money / c.getPrice()));
            money %= c.getPrice();
        }
        return ret;
    }

    public String getMessage() {
        return String.format("%d원 - %d개", coin.getPrice(), count);
    }

    public boolean isZero() {
        return count == 0;
    }

    public Coin getCoin() {
        return coin;
    }

    public int getCount() {
        return count;
    }
}