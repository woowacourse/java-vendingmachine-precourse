package vendingmachine;

import vendingmachine.domain.CoinCountMap;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import java.util.List;

public class VendingController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void settingMachine() {
        CoinCountMap coinCountMap = inputView.inputMoneyOfVendingMachine();
        outputView.printVeningMachineCoin(coinCountMap);
        List<Product> inputProduct = inputView.inputProduct();
        int inputMoneyToVendingMachine = inputView.inputMoneyToVendingMachine();
        vendingMachine = new VendingMachine(coinCountMap, inputProduct, inputMoneyToVendingMachine);
    }

    public void startBuying() {
        selectToBuy();
        outputView.printLeftoverCoinCount(vendingMachine.getLeftoverCash()); // 돈을 넣으면 잔돈을 최대한 출력하는 기능을 구현해야 한다.
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
