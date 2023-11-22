package vendingmachine.model;

import static vendingmachine.model.RandomCoins.makeRandomCoins;

public class VendingMachine {
    private Coins moneyBox;

    public VendingMachine(int totalMoney) {
        moneyBox = new Coins(makeRandomCoins(totalMoney));
    }
}
