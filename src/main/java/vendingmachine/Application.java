package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;
import vendingmachine.controller.ProductController;

public class Application {
    public static void main(String[] args) {
        InputMoneyController inputMoneyController = new InputMoneyController();
        inputMoneyController.inputVendingMachineMoney();
        new CoinController().makeChangeCoins();
        new ProductController().inputProduct();
        inputMoneyController.inputUserMoney();
    }
}
