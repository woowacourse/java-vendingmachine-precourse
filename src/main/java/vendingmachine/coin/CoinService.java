package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vendingmachine.coin.Coin.*;

public class CoinService {
    private final int amount;
    private final List<Coin> coins = Arrays.asList(COIN_500, COIN_100, COIN_50, COIN_10);
    private final List<Integer> coinsAmountList
            = Arrays.asList(COIN_500.getAmount(), COIN_100.getAmount(),
            COIN_50.getAmount(), COIN_10.getAmount());

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
        List<Integer> coinSubList
                = new ArrayList<>(coinsAmountList.subList(findFirstIndex(balance), coinsAmountList.size()));
        return Randoms.pickNumberInList(coinSubList);
    }

    /*
    잔액에 따른 pickNumberInList() 메소드의 첫번째 인자를 결정짓는 메소드.
     */
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

    public List<Integer> repayCoinsByBalance(int balance) {
        List<Integer> repayCounts = new ArrayList<>();
        for (Coin coin : coins) {
            int counts = Math.min(coin.getCounts(), balance / coin.getAmount());
            repayCounts.add(counts);
            balance -= coin.getAmount() * counts;
        }
        return repayCounts;
    }
}
