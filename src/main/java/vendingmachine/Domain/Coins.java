package vendingmachine.Domain;

import vendingmachine.Constant.OutputConstant;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
    private static Coins instance = new Coins();
    private static Map<Coin, Integer> holdingCoins;
    private static Map<Coin, Integer> change;

    private Coins() {
        holdingCoins = new LinkedHashMap<>();
        change = new LinkedHashMap<>();
        for (Coin c : Coin.values()) {
            holdingCoins.put(c, 0);
        }
    }

    public static void addToHoldingCoins(int amount) {
        Coin c = Coin.getCoinByAmount(amount);
        holdingCoins.put(c, holdingCoins.get(c) + 1);
    }

    public static void addToChange(Coin c, int count) {
        change.put(c, count);
    }

    public static int calculateNumberOfCoin(Coin c) {
        return Math.min(holdingCoins.get(c), InputAmount.calculateMaxNumber(c));
    }

    public static String printHoldingCoins() {
        return printCoins(holdingCoins);
    }

    public static String printChange() {
        return printCoins(change);
    }

    private static String printCoins(Map<Coin, Integer> coins) {
        StringBuilder result = new StringBuilder();
        for (Coin c : coins.keySet()) {
            result.append(printCoin(c, coins.get(c)));
        }
        return result.toString();
    }

    private static String printCoin(Coin c, int count) {
        StringBuilder result = new StringBuilder();
        result.append(c.printAmount());
        result.append(OutputConstant.COIN_STANDARD);
        result.append(count);
        result.append(OutputConstant.COIN_COUNT);
        result.append("\n");

        return result.toString();
    }

}
