package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {
    private static final int NO_MONEY = 0;

    private Map<Integer, Integer> coins = new HashMap<>();

    public Coins(int inputAmount) {
        breakIntoCoins(inputAmount);
    }

    private void breakIntoCoins(int inputAmount) {
        List<Integer> coinAmounts = Coin.getAmounts();

        while (hasMoney(inputAmount)) {
            Integer randomAmount = Randoms.pickNumberInList(coinAmounts);
            int coinCount = getCoinCount(randomAmount, inputAmount);

            addToChanges(randomAmount, coinCount);

            removePickedAmount(coinAmounts, randomAmount);
            inputAmount = deductInputAmount(randomAmount, coinCount);
        }

    }

    private int deductInputAmount(Integer randomAmount, int coinCount) {
        return randomAmount * coinCount;
    }

    private void removePickedAmount(List<Integer> coinAmounts, Integer randomAmount) {
        coinAmounts.remove(randomAmount);
    }

    private void addToChanges(Integer randomAmount, int coinCount) {
        coins.put(randomAmount, coinCount);
    }

    private int getCoinCount(int randomAmount, int inputAmount) {
        return Coin.create(randomAmount).changeIntoCoins(inputAmount);
    }

    private boolean hasMoney(int inputAmount) {
        return inputAmount > NO_MONEY;
    }

}
