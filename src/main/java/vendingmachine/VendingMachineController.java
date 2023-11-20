package vendingmachine;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public static void run() {
        VendingMachine vendingMachine = new VendingMachine();
        initVendingMachineMoney(vendingMachine);
        initProducts(vendingMachine);
        OutputView.printCoins(vendingMachine.getCoinMap());

        initInputMoney(vendingMachine);
    }

    private static void initVendingMachineMoney(VendingMachine vendingMachine) {
        try {
            Integer money = InputView.readHoldingMoney();
            vendingMachine.initMoney(money);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initVendingMachineMoney(vendingMachine);
        }
    }

    private static void initProducts(VendingMachine vendingMachine) {
        try {
            String readProduct = InputView.readProduct();
            ProductRepository repository = new ProductRepository();
            repository.initProductsByString(readProduct);
            vendingMachine.initProducts(repository);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initProducts(vendingMachine);
        }
    }

    private static void initInputMoney(VendingMachine vendingMachine) {
        try {
            int inputMoney = InputView.readInputMoney();
            vendingMachine.initInputMoney(inputMoney);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initInputMoney(vendingMachine);
        }
    }

    private static void proceedPurchase(VendingMachine vendingMachine, int inputMoney) {
        while (vendingMachine.canPurchaseSomething()) {
            OutputView.printLeftMoney(inputMoney);
            String product = InputView.readPurchaseProduct();
//            vendingMachine.purchaseProduct(product);
        }
    }
}
