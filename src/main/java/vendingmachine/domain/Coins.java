package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Coins {

    private static final List<Integer> coinAmounts = Collections.unmodifiableList(Coin.amounts());
    private final Map<Coin, Integer> counter;

    public Coins(int seedMoney) {
        counter = generateRandomCoins(seedMoney);
    }

    public Coins(Map<Coin, Integer> counter) {
        this.counter = counter;
    }

    public static Coins getGreedyChanges(int inputMoney, Coins remains) {
        Map<Coin, Integer> result = new TreeMap<>();
        while (remains.hasAnyCoinToChange(inputMoney)) {
            Coin coin = remains.getChangeableCoin(inputMoney);

            inputMoney -= coin.getAmount();
            remains.counter.put(coin, remains.counter.get(coin) - 1);

            result.put(coin, result.getOrDefault(coin, 0) + 1);
        }
        return new Coins(result);
    }

    private boolean hasAnyCoinToChange(int inputMoney) {
        // inputMoney보다 가치가 같거나 작은 코인이 존재하면 아직 동전을 더 교체할 수 있음
        return counter.keySet()
                .stream()
                .anyMatch(key -> counter.get(key) > 0 && inputMoney >= key.getAmount());
    }

    private Coin getChangeableCoin(int inputMoney) {
        return coinAmounts.stream()
                .filter(amount -> isChangeableAmount(inputMoney, amount))
                .map(Coin::getCoinWithValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No coin to change"));
    }

    private boolean isChangeableAmount(int inputMoney, Integer amount) {
        return this.counter.get(Coin.getCoinWithValue(amount)) > 0 && amount <= inputMoney;
    }

    private Map<Coin, Integer> generateRandomCoins(int seedMoney) {
        Map<Coin, Integer> coins = initCoinCountMap();

        while (seedMoney >= Coin.COIN_10.getAmount()) {
            int randomAmount = Randoms.pickNumberInList(coinAmounts);
            Coin matchedCoin = Coin.getCoinWithValue(randomAmount);
            if (isPossibleToAdd(seedMoney, randomAmount)) {
                coins.put(matchedCoin, coins.get(matchedCoin) + 1);
                seedMoney -= randomAmount;
            }
        }
        return coins;
    }

    private boolean isPossibleToAdd(int seedMoney, int randomAmount) {
        return seedMoney >= randomAmount;
    }

    private Map<Coin, Integer> initCoinCountMap() {
        Map<Coin, Integer> result = new TreeMap<>();
        for (Coin coin : Coin.values()) {
            result.put(coin, 0);
        }
        return result;
    }

    public int sum() {
        int sum = 0;
        for (Map.Entry<Coin, Integer> entry : counter.entrySet()) {
            sum += entry.getKey().getAmount() * entry.getValue();
        }
        return sum;
    }


    public Map<Coin, Integer> getCounter() {
        return counter;
    }
}
