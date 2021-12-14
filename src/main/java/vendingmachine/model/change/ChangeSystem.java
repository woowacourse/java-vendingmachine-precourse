package vendingmachine.model.change;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.model.change.coingenerator.CoinGenerator;
import vendingmachine.model.change.vo.Coin;

public class ChangeSystem {
    private final Map<Coin, Integer> possibleChangesToReturn;
    private int remainingInputMoney;

    public ChangeSystem(final CoinGenerator coinGenerator) {
        this.possibleChangesToReturn = coinGenerator.generate();
    }

    public Map<Integer, Integer> getOwningCoins() {
        Map<Integer, Integer> owningCoins = new LinkedHashMap<>();
        possibleChangesToReturn.keySet()
                .forEach(coin -> owningCoins.put(coin.getAmount(), possibleChangesToReturn.get(coin)));
        return owningCoins;
    }

    public Map<Integer, Integer> returnChanges(final int remainingInputMoney) {
        this.remainingInputMoney = remainingInputMoney;
        Map<Integer, Integer> returnedChanges = new LinkedHashMap<>();
        change(returnedChanges);
        returnedChanges = excludeZeroCoin(returnedChanges);
        return returnedChanges;
    }

    private void change(final Map<Integer, Integer> returnedChanges) {
        possibleChangesToReturn.keySet().stream()
                .filter(coin -> possibleChangesToReturn.get(coin) != 0)
                .forEach(coin -> change(coin, returnedChanges));
    }

    private void change(final Coin coin, final Map<Integer, Integer> returnedChanges) {
        int maxNumberOfChanging = coin.getNumberOfPossibleGeneration(remainingInputMoney);
        int numberOfActualOwningCoin = possibleChangesToReturn.get(coin);
        int numberOfReturnedCoin = Math.min(maxNumberOfChanging, numberOfActualOwningCoin);
        returnedChanges.put(coin.getAmount(), numberOfReturnedCoin);
        decreaseRemainingInputMoney(coin.getAmount() * numberOfReturnedCoin);
    }

    private void decreaseRemainingInputMoney(final int decreasingAmount) {
        remainingInputMoney -= decreasingAmount;
    }

    private Map<Integer, Integer> excludeZeroCoin(final Map<Integer, Integer> returnedChanges) {
        Map<Integer, Integer> zeroExcludedCoins = new LinkedHashMap<>();
        returnedChanges.keySet().stream()
                .filter(coin -> returnedChanges.get(coin) != 0)
                .forEach(coin -> zeroExcludedCoins.put(coin, returnedChanges.get(coin)));
        return zeroExcludedCoins;
    }
}
