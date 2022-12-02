package vendingmachine.model;

import vendingmachine.Coin;

import java.util.EnumMap;
import java.util.Map;

import static vendingmachine.Coin.COIN_10;

public class Balance {
    private int balance;
    private int inputCoins;

    private Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
    private Map<Coin, Integer> changeCoins = new EnumMap<>(Coin.class);

    public Balance(int balance) {
        this.balance = balance;
    }

    public Map<Coin, Integer> createCoin() {
        int tmp = balance;
        for (Coin coin : Coin.values()) {
            int num = coin.pickNumberOfCoins(tmp);
            if (coin.equals(COIN_10)) {
                num = tmp / COIN_10.get();
            }
            coins.put(coin, num);
            tmp -= num * coin.get();
            if (tmp < 0) {
                tmp = 0;
            }
        }
        return coins;
    }
    
}
