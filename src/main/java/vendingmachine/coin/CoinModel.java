package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.coin.Coin.*;
import static vendingmachine.coin.Coin.COIN_10;

public class CoinModel {
    private int totalAmount;
    private final List<Coin> coins = Arrays.asList(COIN_500,COIN_100,COIN_50,COIN_10);
    private final List<Integer> coinsAmountList = Arrays.asList(COIN_500.getAmount(), COIN_100.getAmount(), COIN_50.getAmount(), COIN_10.getAmount());

    public CoinModel (int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void randomCoinStore() {
        int currentAmount = 0;
        while (currentAmount < totalAmount) {
            int coinPrice = randomCoin(totalAmount - currentAmount);
            currentAmount += coinPrice;
            Coin coin = getCoin(coinPrice);
            coin.addCoin();
        }
    }

    public int randomCoin(int range) {
        List<Integer> coinList = new ArrayList<>(coinsAmountList.subList(findFirstIndex(range),coinsAmountList.size()));
        return Randoms.pickNumberInList(coinList);
    }

    public int findFirstIndex(int balance) {
        return coinsAmountList.indexOf(coinsAmountList.stream()
                .filter(coinAmount -> coinAmount <= balance)
                .findFirst().orElse(COIN_10.getAmount()));
    }

    public Coin getCoin(int price) {
        return coins.stream()
                .filter(coin -> coin.getAmount() == price)
                .findAny()
                .orElse(COIN_10);
    }
}
