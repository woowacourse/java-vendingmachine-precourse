package vendingmachine;

import vendingmachine.util.TypeConverter;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int vendingMachineMoney = TypeConverter.convertStringToInt(InputView.inputVendingMachineMoney());
        Coins coins = new Coins(vendingMachineMoney);
        OutputView.printCoinCount(coins.getCoins());

        String productInfo = InputView.inputProductInfo();
        Products products = new Products(productInfo);

        VendingMachine machine = new VendingMachine(coins, products);

        int userMoney = TypeConverter.convertStringToInt(InputView.inputUserMoney());

        machine.purchase(userMoney);
    }
}
