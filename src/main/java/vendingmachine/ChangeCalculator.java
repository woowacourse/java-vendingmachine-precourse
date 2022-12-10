package vendingmachine;

import Constants.Coin;
import java.util.HashMap;
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
