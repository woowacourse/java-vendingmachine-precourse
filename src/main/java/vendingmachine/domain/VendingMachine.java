package vendingmachine.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final Map<Coin, Integer> coinCount = new HashMap<>();
    private final Collection<Product> products;
    private int inputMoney;

    public VendingMachine(Collection<Product> products, int inputMoney, int vendingMachineMoney) {
        this.products = products;
        this.inputMoney = inputMoney;
        createRandomCoinList(vendingMachineMoney);
    }

    private void createRandomCoinList(int vendingMachineMoney) {
        for (Coin coinName : Coin.values()) {
            coinCount.put(coinName, 0);
        }

        Integer randomCoin;
        while (vendingMachineMoney != 0) {
            randomCoin = Coin.getRandomAmount();
            if (randomCoin <= vendingMachineMoney) {
                vendingMachineMoney -= randomCoin;
                Coin randomCoinName = findCoinByValue(randomCoin);
                coinCount.replace(randomCoinName, coinCount.get(randomCoinName) + 1);
                System.out.println(vendingMachineMoney);
            }
        }
    }

    private Coin findCoinByValue(int coinValue) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == coinValue) {
                return coin;
            }
        }
        return null;
    }

}
