package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.controller.CoinGeneratorInterface;
import vendingmachine.controller.classes.CoinGenerator;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public Map<Coin, Integer> generateRandomCoins() {
        CoinGeneratorInterface generator = new CoinGenerator();
        return generator.getRandomCoins(this.amount);
    }
}
