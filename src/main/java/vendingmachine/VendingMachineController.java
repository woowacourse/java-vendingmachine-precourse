package vendingmachine;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public static void run() {
        VendingMachine vendingMachine = new VendingMachine();
        initMoney(vendingMachine);
        initProducts(vendingMachine);
        OutputView.printCoins(vendingMachine.getCoinMap());
    }

    private static void initMoney(VendingMachine vendingMachine) {
        try {
            Integer money = InputView.readMoney();
            vendingMachine.initMoney(money);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initMoney(vendingMachine);
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


}
