package vendingmachine;

import vendingmachine.domain.CoinCount;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.List;

public class VendingController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void settingMachine() {
        int inputMoneyOfVendingMachine = inputView.inputMoneyOfVendingMachine();
        CoinCount coinCount = new CoinCount(inputMoneyOfVendingMachine);
        outputView.printVeningMachineCoin(coinCount);
        List<Product> inputProduct = inputView.inputProduct();
        int inputMoneyToVendingMachine = inputView.inputMoneyToVendingMachine();
        vendingMachine = new VendingMachine(coinCount, inputProduct, inputMoneyToVendingMachine);
    }

    public void startBuying() {
        selectToBuy();

    }

    private void selectToBuy() {
        outputView.printMoneyInputToVendingMachine(vendingMachine.getInputMoney());
        while (true) {
            try {
                if (vendingMachine.getMinPrice() > vendingMachine.getInputMoney()) {
                    return;
                }
                if (vendingMachine.getProductsCount() == 0) {
                    return;
                }
                vendingMachine.buyProduct(inputView.inputToSelectProduct());
                outputView.printMoneyInputToVendingMachine(vendingMachine.getInputMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
