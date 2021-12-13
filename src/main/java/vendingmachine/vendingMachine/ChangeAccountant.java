package vendingmachine.vendingMachine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;

public class ChangeAccountant {
    private Coins changes = new Coins();
    private int amountToChange = 0;
    private Coins coinBalance = new Coins();

    public Coins change(int amountToChange, Coins coinBalance) {
        initialize(amountToChange, coinBalance);
        if (coinBalance.hasSmallerOrEqualAmount(amountToChange)) {
            updateAmountToChangeAfterExchange(coinBalance.getAmount());
            return new Coins(coinBalance);
        }
        Coin.getAlCoinUnitsFromLargestToSmallest().forEach(this::changeToEachCoin);
        return changes;
    }

    public int getRestAfterCalculation() {
        return amountToChange;
    }

    private void initialize(int amountToChange, Coins coinBalance) {
        changes = new Coins();
        this.amountToChange = amountToChange;
        this.coinBalance = coinBalance;
    }

    private void updateAmountToChangeAfterExchange(int amountExchangedForCoin) {
        amountToChange -= amountExchangedForCoin;
    }

    private void changeToEachCoin(Coin coinUnit) {
        int numberOfCoinToChange = accountWithinBalance(coinUnit, accountMaxWithinAmountByCoinUnit(coinUnit, amountToChange));
        changes.add(coinUnit, numberOfCoinToChange);
        updateAmountToChangeAfterExchange(coinUnit.getAmount(numberOfCoinToChange));
    }

    private int accountMaxWithinAmountByCoinUnit(Coin coinUnit, int amountToChange) {
        return amountToChange / coinUnit.getAmount();
    }

    private int accountWithinBalance(Coin coin, int numberOfCoinToChange) {
        int currentNumber = coinBalance.count(coin);
        return Math.min(numberOfCoinToChange, currentNumber);
    }
}
