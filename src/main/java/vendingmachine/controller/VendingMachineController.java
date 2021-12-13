package vendingmachine.controller;

import java.util.LinkedHashMap;

import vendingmachine.domain.Money;
import vendingmachine.domain.RandomCoinMaker;
import vendingmachine.view.input.MoneyInputView;
import vendingmachine.view.input.ProductInputView;
import vendingmachine.view.input.PurchaseInputView;
import vendingmachine.view.output.OutputView;

public class VendingMachineController {
    private static final VendingMachineController instance = new VendingMachineController();

    private VendingMachineController() {
    }

    public static VendingMachineController getInstance() {
        return instance;
    }

    public void start() {
        MoneyInputView moneyInputView = new MoneyInputView();
        int moneyForCoin = inputMoneyForMakeCoin(moneyInputView);

        LinkedHashMap<Integer, Integer> vendingMachineCoin = RandomCoinMaker.getInstance().makeCoin(moneyForCoin);

        OutputView outputView = new OutputView();
        showCoinVendingMachineHas(outputView, vendingMachineCoin);

        inputProductsToVendingMachine();
        storeMoney(moneyInputView);
        inputProductForPurchase();
        showChange(outputView, vendingMachineCoin);
    }

    private void inputProductsToVendingMachine() {
        ProductInputView productInputView = new ProductInputView();
        productInputView.inputProducts();
    }

    private void inputProductForPurchase() {
        PurchaseInputView purchaseInputView = new PurchaseInputView();
        purchaseInputView.inputProductForPurchase();
    }

    private int inputMoneyForMakeCoin(MoneyInputView moneyInputView) {
        return moneyInputView.inputMoneyForMakeCoin();
    }

    private void storeMoney(MoneyInputView moneyInputView) {
        int moneyForPurchase = moneyInputView.inputMoneyForPurchase();
        Money.getInstance().storeMoney(moneyForPurchase);
    }

    private void showCoinVendingMachineHas(OutputView outputView,LinkedHashMap<Integer, Integer> vendingMachineCoin) {
        outputView.showCoin(vendingMachineCoin);
    }

    private void showChange(OutputView outputView, LinkedHashMap<Integer, Integer> vendingMachineCoin) {
        outputView.showChange(vendingMachineCoin);
    }
}