package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static vendingmachine.Coin.*;

public class Coins {
    private static final int ZERO = 0;

    private final Map<Coin, Integer> coins = new HashMap<>();

    public Coins(int amount) {
        breakIntoCoins(amount);
    }

    protected Coins(int coin500Count, int coin100Count, int coin50Count, int coin10Count) {
        coins.put(COIN_500, coin500Count);
        coins.put(COIN_100, coin100Count);
        coins.put(COIN_50, coin50Count);
        coins.put(COIN_10, coin10Count);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Map<Coin, Integer> giveChange(int restAmount) {
        Map<Coin, Integer> change = new HashMap<>();

        for (Coin coin : coins.keySet()) {
            int coinCount = getCointCount(restAmount, coin);
            addChanges(change, coin, coinCount);

            restAmount = getRestMoney(restAmount, coin.getAmount(), coinCount);
        }

        return change;
    }

    private void addChanges(Map<Coin, Integer> change, Coin coin, int coinCount) {
        if (hasRestCoin(coin)) {
            change.put(coin, coinCount);
        }
    }

    private boolean hasRestCoin(Coin coin) {
        return coins.get(coin) != ZERO && coins.get(coin) != null;
    }

    private int getCointCount(int restAmount, Coin coin) {
        int coinCount = coin.changeIntoCoins(restAmount);

        if (!hasRestCoin(coin)) {
            coinCount = ZERO;
        }
        if (coinCount > coins.get(coin)) {
            coinCount = coins.get(coin);
        }

        return coinCount;
    }

    private void breakIntoCoins(int inputAmount) {
        List<Integer> coinAmounts = Coin.getAmounts();

        while (isMoneyLeft(inputAmount)) {
            int randomAmount = Randoms.pickNumberInList(coinAmounts);
            Coin coin = Coin.create(randomAmount);
            int coinCount = coin.changeIntoCoins(inputAmount);

            coins.put(coin, coinCount);

            removePickedAmount(coinAmounts, randomAmount);
            inputAmount = getRestMoney(inputAmount, randomAmount, coinCount);
        }
    }

    private int getRestMoney(Integer totalAmount, int coinAmount, int coinCount) {
        return totalAmount - coinAmount * coinCount;
    }

    private void removePickedAmount(List<Integer> coinAmounts, Integer randomAmount) {
        coinAmounts.remove(randomAmount);
    }

    private boolean isMoneyLeft(int inputAmount) {
        return inputAmount > ZERO;
    }

}
