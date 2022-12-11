package vendingmachine;

import Constants.Coin;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeCalculator {

    int vendingMachineMoney;
    Map<Coin, Integer> coinBox;
    Customer customer;

    public ChangeCalculator(int vendingMachineMoney, Map<Coin, Integer> coinBox, Customer customer) {
        this.vendingMachineMoney = vendingMachineMoney;
        this.coinBox = coinBox;
        this.customer = customer;
    }

    public Map<Coin, Integer> calculateResult() {
        Map<Coin, Integer> result = new HashMap<>();

        int remainingMoney = customer.getInputMoney();
        if (remainingMoney >= vendingMachineMoney) {
            return coinBox;
        }
        calculateMinimumCoinSize(result, remainingMoney);

        return result;
    }

    private void calculateMinimumCoinSize(Map<Coin, Integer> result, int remainingMoney) {
        List<Coin> sortedCoins = sortCoinsByTheirAmount(coinBox);

        for (Coin coin : sortedCoins) {
            int coinValue = coin.getAmount();
            int coinNumberInMachine = coinBox.get(coin);
            if (coinNumberInMachine == 0) {
                continue;
            }
            int returningCoinSize = remainingMoney / coinValue;
            if (returningCoinSize > coinNumberInMachine) {
                returningCoinSize = coinNumberInMachine;
            }
            result.put(coin, returningCoinSize);
            remainingMoney -= coinValue * returningCoinSize;
            if (remainingMoney == 0) {
                break;
            }
        }
    }
    private static List<Coin> sortCoinsByTheirAmount(Map<Coin, Integer> coinBox) {
        List<Coin> coinAmounts = new ArrayList<>(coinBox.keySet());
        Comparator<Coin> comp = (c1, c2) -> Integer.compare(c2.getAmount(), c1.getAmount());
        coinAmounts.sort(comp);
        return coinAmounts;
    }
}
