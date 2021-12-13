package vendingmachine;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String vendingMachineMoney = InputView.inputVendingMachineMoney();
        Coins coins = new Coins(Integer.parseInt(vendingMachineMoney));
        OutputView.printCoinCount(coins.getCoins());

        String productInfo = InputView.inputProductInfo();
        Products products = new Products(productInfo);

        InputView.inputUserMoney();
    }
}
