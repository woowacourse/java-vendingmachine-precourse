package vendingmachine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;

public class ChangeAccountant {
    private Coins changes = new Coins();
    private int amountToChange = 0;
    private Coins coinBalance = new Coins();

    public Coins change(int amountToChange, Coins coinBalance) {
        initialize(amountToChange, coinBalance);
        Coin.getAllKindsOfCoinFromLargestToSmallest().forEach(this::changeToEachCoin);
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

    private void changeToEachCoin(Coin coinUnit) {
        int numberOfCoinToChange = accountWithinBalance(coinUnit, accountMaxWithinAmountByCoinUnit(coinUnit, amountToChange));
        changes.add(coinUnit, numberOfCoinToChange);
        amountToChange -= coinUnit.getAmount(numberOfCoinToChange);
    }

    private int accountMaxWithinAmountByCoinUnit(Coin coinUnit, int amountToChange) {
        return amountToChange / coinUnit.getAmount();
    }

    private int accountWithinBalance(Coin coin, int numberOfCoinToChange) {
        int currentNumber = coinBalance.count(coin);
        if (numberOfCoinToChange > currentNumber) {
            return currentNumber;
        }
        return numberOfCoinToChange;
    }
}
