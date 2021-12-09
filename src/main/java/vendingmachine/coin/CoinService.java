package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.coin.Coin.*;

public class CoinService {
    private final int amount;

    public CoinService(int amount) {
        this.amount = amount;
    }

    public void initCoins() {
        int currentAmount = 0;
        while (currentAmount < amount) {
            int coinPrice = pickRandomCoin(amount - currentAmount);
            currentAmount += coinPrice;
            Coin coin = getCoin(coinPrice);
            coin.plusCoin();
        }
    }

    public int pickRandomCoin(int balance) {
        List<Integer> coinList
                = Arrays.asList(COIN_500.getAmount(), COIN_100.getAmount(),
                COIN_50.getAmount(), COIN_10.getAmount());
        List<Integer> coinSubList
                = new ArrayList<>(coinList.subList(findFirstIndex(balance), coinList.size()));
        return Randoms.pickNumberInList(coinSubList);
    }

    /*
    잔액에 따른 pickNumberInList() 메소드의 첫번째 인자를 결정짓는 메소드.
     */
    public int findFirstIndex(int balance) {
        if (balance >= COIN_500.getAmount()) {
            return 0;
        }
        if (balance >= COIN_100.getAmount()) {
            return 1;
        }
        if (balance >= COIN_50.getAmount()) {
            return 2;
        }
        return 3;
    }

    public Coin getCoin(int price) {
        if (price == COIN_500.getAmount()) {
            return COIN_500;
        }
        if (price == COIN_100.getAmount()) {
            return COIN_100;
        }
        if (price == COIN_50.getAmount()) {
            return COIN_50;
        }
        return COIN_10;
    }

    public List<Integer> repayCoinsByBalance(int balance) {
        List<Coin> coins = Arrays.asList(COIN_500, COIN_100, COIN_50, COIN_10);
        List<Integer> repayCounts = new ArrayList<>();
        for (Coin coin : coins) {
            int counts = Math.min(coin.getCounts(), balance / coin.getAmount());
            repayCounts.add(counts);
            balance -= coin.getAmount() * counts;
        }
        return repayCounts;
    }
}
