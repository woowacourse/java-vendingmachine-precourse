package vendingmachine;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.List;

public class VendingController {
    private static final InputView inputView = new InputView();
    private VendingMachine vendingMachine;

    public void settingMachine() {
        int inputMoneyOfVendingMachine = inputView.inputMoneyOfVendingMachine();
        List<Product> inputProduct = inputView.inputProduct();
        int inputMoneyToVendingMachine = inputView.inputMoneyToVendingMachine();
        vendingMachine = new VendingMachine(inputProduct, inputMoneyToVendingMachine, inputMoneyOfVendingMachine);
    }

    public void startBuying() {
        selectToBuy();

    }

    private void selectToBuy() {
        while (true) {
            try {
                if (vendingMachine.getMinPrice() > vendingMachine.getInputMoney()) {
                    return;
                }
                if (vendingMachine.getProductsCount() == 0) {
                    return;
                }
                vendingMachine.buyProduct(inputView.inputToSelectProduct());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
