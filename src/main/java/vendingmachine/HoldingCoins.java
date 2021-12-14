package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;

import static vendingmachine.Coin.*;

public class HoldingCoins extends Coins{
    public HoldingCoins(int amount) {
        breakIntoCoins(amount);
    }

    protected HoldingCoins(int coin500Count, int coin100Count, int coin50Count, int coin10Count) {
        coins.put(COIN_500, coin500Count);
        coins.put(COIN_100, coin100Count);
        coins.put(COIN_50, coin50Count);
        coins.put(COIN_10, coin10Count);
    }

    public Map<Coin, Integer> get() {
        return coins;
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

    private void removePickedAmount(List<Integer> coinAmounts, Integer randomAmount) {
        coinAmounts.remove(randomAmount);
    }

    private boolean isMoneyLeft(int inputAmount) {
        return inputAmount > ZERO;
    }
}
