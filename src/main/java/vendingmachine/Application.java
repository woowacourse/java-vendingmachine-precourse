package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;
import vendingmachine.controller.ProductController;

public class Application {
    public static void main(String[] args) {
        new InputMoneyController().inputVendingMachineMoney();
        new CoinController().makeChangeCoins();
        new ProductController().inputProduct();
    }
}
