package vendingmachine.controller;

import java.util.LinkedHashMap;

import vendingmachine.domain.Money;
import vendingmachine.domain.RandomCoinMaker;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private static final VendingMachineController instance = new VendingMachineController();

    private VendingMachineController() {
    }

    public static VendingMachineController getInstance() {
        return instance;
    }

    public void start() {
        InputView inputView = new InputView();
        int moneyForCoin = inputView.inputMoneyForMakeCoin();
        LinkedHashMap<Integer, Integer> vendingMachineCoin = RandomCoinMaker.getInstance().makeCoin(moneyForCoin);

        OutputView outputView = new OutputView();
        showCoinVendingMachineHas(outputView, vendingMachineCoin);

        inputView.inputProducts();
        storeMoney(inputView);
        inputView.inputProductForPurchase();
        showChange(outputView, vendingMachineCoin);
    }

    private void storeMoney(InputView inputView) {
        int moneyForPurchase = inputView.inputMoneyForPurchase();
        Money.getInstance().storeMoney(moneyForPurchase);
    }

    private void showCoinVendingMachineHas(OutputView outputView,LinkedHashMap<Integer, Integer> vendingMachineCoin) {
        outputView.showCoin(vendingMachineCoin);
    }

    private void showChange(OutputView outputView, LinkedHashMap<Integer, Integer> vendingMachineCoin) {
        outputView.showChange(vendingMachineCoin);
    }
}