package vendingmachine;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public static void run() {

        initProducts();
    }

    private static void initProducts() {
        try {
            String readProduct = InputView.readProduct();
            ProductRepository.initProductsByString(readProduct);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            initProducts();
        }
    }


}
