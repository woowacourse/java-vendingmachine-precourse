package vendingmachine;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private ProductRepository repository;
    private Map<Coin, Integer> coinMap;
    private int leftMoney;

    public VendingMachine() {
        repository = new ProductRepository();
        coinMap = new EnumMap<>(Coin.class);
        leftMoney = 0;
    }

    public void initProducts(ProductRepository repository) {
        this.repository = repository;
    }

    public void initMoney(int money) {
        while (money >= Coin.COIN_10.getAmount()) {
            Coin pickedCoin = Coin.getRandomCoin();
            if (money < pickedCoin.getAmount()) {
                continue;
            }
            money -= pickedCoin.getAmount();
            coinMap.put(pickedCoin, coinMap.getOrDefault(pickedCoin, 0) + 1);
        }
        leftMoney += money;
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinMap;
    }
}
