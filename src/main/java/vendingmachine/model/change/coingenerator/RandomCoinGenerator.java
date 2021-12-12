package vendingmachine.model.change.coingenerator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import vendingmachine.model.change.vo.Coin;

public class RandomCoinGenerator implements CoinGenerator {
    private static final int INITIAL_NUMBER = 0;
    private static final int OVER_MONEY_VALUE = 0;
    private static final int INCREASING_UNIT = 1;
    private static final List<Integer> COIN_AMOUNTS;

    static {
        COIN_AMOUNTS = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    private final Map<Coin, Integer> numbersByCoin = new LinkedHashMap<>();
    private int remainingMoneyToGenerateCoin;

    public RandomCoinGenerator(final int limitOfMoney) {
        this.remainingMoneyToGenerateCoin = limitOfMoney;
        initialize();
    }

    public Map<Coin, Integer> generate() {
        while (isNotOver()) {
            generateRandomCoin();
        }
        return numbersByCoin;
    }

    private void initialize() {
        Arrays.stream(Coin.values()).forEach(coin -> numbersByCoin.put(coin, INITIAL_NUMBER));
    }

    private boolean isNotOver() {
        return remainingMoneyToGenerateCoin != OVER_MONEY_VALUE;
    }

    private void generateRandomCoin() {
        int generatedCoinAmount = pickNumberInList(COIN_AMOUNTS);
        if (canGenerateCoinOf(generatedCoinAmount)) {
            Coin generatedCoin = Coin.of(generatedCoinAmount);
            int presentCoinNumber = numbersByCoin.get(generatedCoin);
            numbersByCoin.put(generatedCoin, presentCoinNumber + INCREASING_UNIT);
            subtractGeneratedMoney(generatedCoinAmount);
        }
    }

    private boolean canGenerateCoinOf(int generatedCoinAmount) {
        return generatedCoinAmount <= remainingMoneyToGenerateCoin;
    }

    private void subtractGeneratedMoney(int generatedMoneyValue) {
        remainingMoneyToGenerateCoin -= generatedMoneyValue;
    }
}
