package vendingmachine.Domain;

import vendingmachine.Constant.OutputConstant;

import java.util.HashMap;
import java.util.Map;

public class HoldingCoins {
    private static HoldingCoins instance = new HoldingCoins();
    private static Map<Coin, Integer> coins;

    private HoldingCoins() {
        coins = new HashMap<>();
        for (Coin c : Coin.values()) {
            coins.put(c, 0);
        }
    }

    public static void addCoin(int amount) {
        Coin c = Coin.getCoinByAmount(amount);
        coins.put(c, coins.get(c) + 1);
    }

    public static String printCoinCount(Coin c) {
        return coins.get(c) + OutputConstant.COIN_COUNT;
    }
}
