package vendingmachine.model;

import vendingmachine.Coin;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private int totalChange;
    private Map<Coin, Integer> coins;

    public VendingMachine(int totalChange) {
        this.totalChange = totalChange;
        this.coins = createRandomCoins(totalChange);
    }

    private Map<Coin, Integer> createRandomCoins(int money) {
        Map<Coin, Integer> coins = new HashMap<>();
        // TODO 동전 랜덤 생성
        return coins;
    }
}
