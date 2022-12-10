package vendingmachine;

import Constants.Coin;
import java.util.HashMap;
import java.util.Map;

public class ChangeCalculator {

    Map<Coin, Integer> coinBox;
    Customer customer;

    public ChangeCalculator(Map<Coin, Integer> coinBox, Customer customer) {
        this.coinBox = coinBox;
        this.customer = customer;
    }

    public Map<Coin, Integer> calculateResult() {
        Map<Coin, Integer> result = new HashMap<>();

        int remainingMoney = customer.getInputMoney();
        if (remainingMoney >= calculateSumOfChanges()) {
            return coinBox;
        }
        calculateMinimumCoinSize(result, remainingMoney);

        return result;
    }

    private int calculateSumOfChanges() {
        int sum = 0;
        for (Map.Entry<Coin, Integer> entry : coinBox.entrySet()) {
            sum += entry.getKey().getAmount() * entry.getValue();
        }
        return sum;
    }

    private void calculateMinimumCoinSize(Map<Coin, Integer> result, int remainingMoney) {
        for (Map.Entry<Coin, Integer> entry : coinBox.entrySet()) {
            int coinValue = entry.getKey().getAmount();
            int coinInMachine = entry.getValue();
            if (coinInMachine == 0) {
                continue;
            }
            int returningCoinSize = remainingMoney / coinValue;
            if (returningCoinSize > coinInMachine) {
                returningCoinSize = coinInMachine;
            }
            result.put(entry.getKey(), returningCoinSize);
            remainingMoney -= coinValue * returningCoinSize;
            if (remainingMoney == 0) {
                break;
            }
        }
    }
}
