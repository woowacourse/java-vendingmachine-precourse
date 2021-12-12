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

    private void changeToEachCoin(Coin coin) {
        int numberOfCoin = getNumberWithinBalance(coin, accountMaxChangeForCoin(coin, amountToChange));
        changes.add(coin, numberOfCoin);
        amountToChange -= numberOfCoin * coin.getAmount();
    }

    private int accountMaxChangeForCoin(Coin coin, int amountToChange) {
        if(amountToChange < coin.getAmount()) {
            return 0;
        }
        return amountToChange / coin.getAmount();
    }

    private int getNumberWithinBalance(Coin coin, int numberOfCoinToChange) {
        int currentNumber = coinBalance.count(coin);
        if(numberOfCoinToChange > currentNumber) {
            return currentNumber;
        }
        return numberOfCoinToChange;
    }
}
