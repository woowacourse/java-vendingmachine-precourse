package vendingmachine;

import vendingmachine.domain.CoinCountMap;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.List;

public class VendingController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private VendingMachine vendingMachine;

    public void run() {
        settingMachine();
        startBuying();
    }

    private void settingMachine() {
        CoinCountMap coinCountMap = inputView.inputMoneyOfVendingMachine();
        outputView.printVeningMachineCoin(coinCountMap);
        List<Product> inputProduct = inputView.inputProduct();
        int inputMoneyToVendingMachine = inputView.inputMoneyToVendingMachine();
        vendingMachine = new VendingMachine(coinCountMap, inputProduct, inputMoneyToVendingMachine);
    }

    private void startBuying() {
        outputView.printMoneyInputToVendingMachine(vendingMachine.getInputMoney());
        while (isSelectToBuy(vendingMachine)) {
            selectToBuy();
        }
        outputView.printLeftoverCoinCount(vendingMachine.getLeftoverCash());
    }

    private void selectToBuy() {
        try {
            vendingMachine.buyProduct(inputView.inputToSelectProduct());
            outputView.printMoneyInputToVendingMachine(vendingMachine.getInputMoney());
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            selectToBuy();
        }
    }

    private boolean isSelectToBuy(VendingMachine vendingMachine) {
        if (vendingMachine.getMinPriceOfProducts() > vendingMachine.getInputMoney()) {
            return false;
        }
        if (vendingMachine.getProductsCount() == 0) {
            return false;
        }
        return true;
    }
}
