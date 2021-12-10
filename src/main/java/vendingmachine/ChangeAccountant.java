package vendingmachine;

public class ChangeAccountant {
    private Coins changes;
    private int amountToChange;
    private Coins coinBalance;

    public Coins change(int amountToChange, Coins coinBalance) {
        initialize();
        this.amountToChange = amountToChange;
        this.coinBalance = coinBalance;

        Coin.getAllKindsCoinFromLargestToSmallest().forEach(this::changeToEachCoin);
        return changes;
    }

    public int getRestAfterCalculation() {
        return amountToChange;
    }

    private void initialize() {
        changes = new Coins();
        amountToChange = 0;
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
