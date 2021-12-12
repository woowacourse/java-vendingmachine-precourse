package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.RandomCoinMaker;
import vendingmachine.view.input.MoneyInputView;
import vendingmachine.view.input.ProductInputView;
import vendingmachine.view.input.PurchaseInputView;
import vendingmachine.view.output.OutputView;

import java.util.LinkedHashMap;

public class VendingMachineController {

    public void start() {
        MoneyInputView moneyInputView = new MoneyInputView();
        Integer moneyForCoin = moneyInputView.inputMoneyForMakeCoin();
        LinkedHashMap<Integer, Integer> coinMap = RandomCoinMaker.getInstance().makeCoin(moneyForCoin);
        OutputView outputView = new OutputView();
        outputView.showCoin(coinMap);

        ProductInputView productInputView = new ProductInputView();
        productInputView.inputProducts();
        int moneyForPurchase = moneyInputView.inputMoneyForPurchase();
        Money.getInstance().storeMoney(moneyForPurchase);
        PurchaseInputView purchaseInputView = new PurchaseInputView();
        purchaseInputView.inputProductForPurchase();
        outputView.showChange(coinMap);
    }
}