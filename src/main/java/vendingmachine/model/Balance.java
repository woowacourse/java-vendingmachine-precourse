package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Balance {
    private final int balance;
    List<Integer> numbers = new ArrayList<>();
    private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
    private final Map<Coin, Integer> changeCoins = new EnumMap<>(Coin.class);

    public Balance(int balance) {
        this.balance = balance;
        for (Coin coin : Coin.values()) {
            numbers.add(coin.get());
            coins.put(coin, 0);
        }
    }

    public Map<Coin, Integer> createCoin() {
        int tmp = balance;

        while (tmp > 0) {
            int randomCoinAmount = Randoms.pickNumberInList(numbers);
            if (tmp >= randomCoinAmount) {
                Coin key = Coin.getEqualCoin(randomCoinAmount);
                coins.put(key, coins.get(key) + 1);
                tmp = tmp - randomCoinAmount;
            }
        }
        return coins;
    }

    public Map<Coin, Integer> calculateChangeCoin(int change) {
        if (change > balance) {
            return coins;
        }
        for (Coin coin : Coin.values()) {
            int numberOfBalanceCoin = coins.get(coin);
            int neededCoins = change / coin.get();
            int inputCoins = Math.min(neededCoins, numberOfBalanceCoin);
            changeCoins.put(coin, inputCoins);
            change -= coin.get() * inputCoins;
        }
        return changeCoins;
    }
}
