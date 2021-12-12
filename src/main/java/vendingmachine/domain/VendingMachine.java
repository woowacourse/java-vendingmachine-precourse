package vendingmachine.domain;

import java.util.HashMap;

public class VendingMachine {

    private int holdingMoney;
    private CoinCase coinCase;

    public VendingMachine() {
        this.holdingMoney = 0;
        this.coinCase = new CoinCase();
    }

    public void setHoldingMoney(final int holdingMoney) {
        this.holdingMoney = holdingMoney;
    }

    public void initializeCoinCase() {
        coinCase.generateCoins(holdingMoney);
    }

    public HashMap<Coin, Integer> getHoldingCoins() {
        return coinCase.getHoldingCoins();
    }
}
