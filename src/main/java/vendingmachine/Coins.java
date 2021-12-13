package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {
    private static final int NO_MONEY = 0;

    private final Map<Coin, Integer> coins = new HashMap<>();

    public Coins(int amount) {
        breakIntoCoins(amount);
    }

    private void breakIntoCoins(int inputAmount) {
        List<Integer> coinAmounts = Coin.getAmounts();

        while (isMoneyLeft(inputAmount)) {
            int randomAmount = Randoms.pickNumberInList(coinAmounts);
            Coin coin = Coin.create(randomAmount);
            int coinCount = coin.changeIntoCoins(inputAmount);

            coins.put(coin, coinCount);

            removePickedAmount(coinAmounts, randomAmount);
            inputAmount = getRestMoney(inputAmount, coinCount);
        }
    }

    private int getRestMoney(Integer totalAmount, int coinCount) {
        return totalAmount % coinCount;
    }

    private void removePickedAmount(List<Integer> coinAmounts, Integer randomAmount) {
        coinAmounts.remove(randomAmount);
    }

    private boolean isMoneyLeft(int inputAmount) {
        return inputAmount > NO_MONEY;
    }

}
