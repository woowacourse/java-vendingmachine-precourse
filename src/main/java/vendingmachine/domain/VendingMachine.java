package vendingmachine.domain;

public class VendingMachine {

    private int holdingMoney;
    private CoinCase coinCase;

    public void setHoldingMoney(final int holdingMoney) {
        this.holdingMoney = holdingMoney;
        this.coinCase = new CoinCase();
    }

    public void initializeCoinCase() {
        coinCase.generateCoins(holdingMoney);
    }
}
