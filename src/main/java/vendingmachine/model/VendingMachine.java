package vendingmachine.model;

import java.util.List;

import static vendingmachine.model.RandomCoins.makeRandomCoins;

public class VendingMachine {
    private Coins moneyBox;

    public VendingMachine(int totalMoney) {
        moneyBox = new Coins(makeRandomCoins(totalMoney));
    }

    public List<Integer> showCoinBox() {
        return moneyBox.coinsCount();
    }
}
