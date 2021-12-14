package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static vendingmachine.model.Coin.*;

public class HoldingCoins extends Coins{

    public HoldingCoins(int amount) {
        init();
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

    private void init() {
        Arrays.stream(values()).forEach(coin -> coins.put(coin, ZERO));
    }

    private void breakIntoCoins(int inputAmount) {
        List<Integer> coinAmounts = Coin.getAmounts();

        while (isMoneyLeft(inputAmount)) {
            Integer pickedAmount = pickRandomAmount(coinAmounts, inputAmount);
            Coin coin = createCoin(pickedAmount);

            addCoinToMap(coin);
            inputAmount = getRestMoney(inputAmount, pickedAmount);
        }
    }

    private Integer pickRandomAmount(List<Integer> coinAmounts, Integer inputAmount) {
        Integer pickedAmount = Randoms.pickNumberInList(coinAmounts);

        if (pickedAmount > inputAmount) {
            coinAmounts.remove(pickedAmount);
            pickedAmount = Randoms.pickNumberInList(coinAmounts);
        }

        return pickedAmount;
    }

    private void addCoinToMap(Coin coin) {
        coins.put(coin, coins.get(coin) + ONE);
    }

    private Coin createCoin(int randomAmount) {
        return Coin.create(randomAmount);
    }

    private boolean isMoneyLeft(int inputAmount) {
        return inputAmount > ZERO;
    }
}
