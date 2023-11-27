package domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final HashMap<Coin, Integer> vendingMachine;

    public VendingMachine(){
        vendingMachine = new HashMap<>();
        init();
    }

    private void init(){
        for (Coin coin : Coin.values()) {
            vendingMachine.put(coin, 0);
        }
    }

    public void addCoins(Coin coin, int count) {
        vendingMachine.put(coin, vendingMachine.get(coin) + count);
    }

    public int findByCoin(Coin coin) {
        return vendingMachine.get(coin);
    }

    public Map<Coin, Integer> findAll() {
        return vendingMachine;
    }
}
