package vendingmachine;

import java.util.function.Supplier;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public static void run() {

//        ProductRepository.addProductByString(readValidInput(InputView::readProduct));


    }

    private static String readValidInput(Supplier<String> inputMethod) {
        try {
            return inputMethod.get();
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            return readValidInput(inputMethod);
        }
    }
}
