package vendingmachine.model.change.coingenerator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;

import vendingmachine.model.change.vo.Coin;

public class RandomCoinGenerator implements CoinGenerator {
    private static final int INITIAL_NUMBER = 0;
    private static final int OVER_MONEY_VALUE = 0;
    private static final int ADDING_VALUE_FOR_INCLUSION_OF_POSSIBLE_NUMBER = 1;

    private final Map<Coin, Integer> numbersByCoin = new LinkedHashMap<>();
    private int remainingMoneyToGenerateCoin;

    public RandomCoinGenerator(final int limitOfMoney) {
        this.remainingMoneyToGenerateCoin = limitOfMoney;
    }

    public Map<Coin, Integer> generate() {
        List<Coin> coins = Arrays.asList(Coin.values());
        initialize(coins);
        while (isNotOver()) {
            coins.forEach(this::generateCoinOf);
        }
        return numbersByCoin;
    }

    private void initialize(final List<Coin> coins) {
        coins.forEach(coin -> numbersByCoin.put(coin, INITIAL_NUMBER));
    }

    private boolean isNotOver() {
        return remainingMoneyToGenerateCoin != OVER_MONEY_VALUE;
    }

    private void generateCoinOf(final Coin coin) {
        int possibleNumberToGenerate = coin.getNumberOfPossibleGeneration(remainingMoneyToGenerateCoin);
        int generatedCoinNumber = generateRandomNumberOfCoin(possibleNumberToGenerate);
        int presentNumber = numbersByCoin.get(coin);
        numbersByCoin.put(coin, generatedCoinNumber + presentNumber);
        subtractGeneratedMoney(coin.getAmount() * generatedCoinNumber);
    }

    private int generateRandomNumberOfCoin(final int possibleNumber) {
        List<Integer> possibleNumbers = new ArrayList<>();
        IntStream.range(0, possibleNumber + ADDING_VALUE_FOR_INCLUSION_OF_POSSIBLE_NUMBER)
                .forEach(possibleNumbers::add);
        return pickNumberInList(possibleNumbers);
    }

    private void subtractGeneratedMoney(int generateMoney) {
        remainingMoneyToGenerateCoin -= generateMoney;
    }
}
