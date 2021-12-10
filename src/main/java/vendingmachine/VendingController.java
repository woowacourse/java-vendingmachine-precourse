package vendingmachine;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.Collection;

public class VendingController {
    private static final InputView inputView = new InputView();
    private VendingMachine vendingMachine;

    public void settingMachine() {

        int inputMoneyOfVendingMachine =  inputView.inputMoneyOfVendingMachine();
        Collection<Product> inputProduct =  inputView.inputProduct();
        int inputMoneyToVendingMachine = inputView.inputMoneyToVendingMachine();
        vendingMachine = new VendingMachine(inputProduct, inputMoneyToVendingMachine,inputMoneyOfVendingMachine);

    }
}
