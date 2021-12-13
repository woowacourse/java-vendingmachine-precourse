package vendingmachine;

import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        String vendingMachineMoney = InputView.inputVendingMachineMoney();
        Coins coins = new Coins();
        coins.makeCoinsByMoney(Integer.parseInt(vendingMachineMoney));
    }
}
