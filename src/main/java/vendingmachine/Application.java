package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;

public class Application {
    public static void main(String[] args) {
        new InputMoneyController().inputVendingMachineMoney();
        new CoinController().makeChangeCoins();
    }
}
