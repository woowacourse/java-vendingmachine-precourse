package vendingmachine;

import vendingmachine.message.ViewMessage;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public static void run() {
        VendingMachine vendingMachine = new VendingMachine();

        initVendingMachineMoney(vendingMachine);
        initProducts(vendingMachine);

        initInputMoney(vendingMachine);
        proceedPurchase(vendingMachine);
    }

    private static void initVendingMachineMoney(VendingMachine vendingMachine) {
        try {
            int holdMoneyAmount = InputView.readInteger(ViewMessage.INPUT_HOLDING_MONEY);
            Money holdingMoney = new Money(holdMoneyAmount);
            vendingMachine.initMoney(holdingMoney);
            OutputView.printHoldingCoins(vendingMachine.getCoinMap());
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initVendingMachineMoney(vendingMachine);
        }
    }

    private static void initProducts(VendingMachine vendingMachine) {
        try {
            String readProduct = InputView.readString(ViewMessage.INPUT_PRODUCT);
            ProductStore repository = new ProductStore();
            repository.initProductsByString(readProduct);
            vendingMachine.initProducts(repository);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initProducts(vendingMachine);
        }
    }

    private static void initInputMoney(VendingMachine vendingMachine) {
        try {
            int insertedMoneyAmount = InputView.readInteger(ViewMessage.INPUT_INSERTED_MONEY);
            Money inputMoney = new Money(insertedMoneyAmount);
            vendingMachine.initInputMoney(inputMoney);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initInputMoney(vendingMachine);
        }
    }

    private static void proceedPurchase(VendingMachine vendingMachine) {
        while (vendingMachine.canPurchaseSomething()) {
            OutputView.printLeftMoney(vendingMachine.getHoldingMoney());
            String product = InputView.readString(ViewMessage.INPUT_PURCHASE_PRODUCT);
            vendingMachine.purchaseProduct(product);
        }
        OutputView.printLeftMoney(vendingMachine.getHoldingMoney());
        OutputView.printChangeCoins(vendingMachine.getChange());
    }
}
