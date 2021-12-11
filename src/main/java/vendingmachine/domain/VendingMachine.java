package vendingmachine.domain;

import vendingmachine.view.input.MoneyInputView;
import vendingmachine.view.input.ProductInputView;
import vendingmachine.view.input.PurchaseInputView;
import vendingmachine.view.output.OutputView;

public class VendingMachine {

    public void start() {
        MoneyInputView moneyInputView = new MoneyInputView();
        Integer moneyForCoin = moneyInputView.inputMoneyForMakeCoin();
        RandomCoinMaker.getInstance().makeCoin(moneyForCoin);
        OutputView outputView = new OutputView();
        outputView.showCoin(RandomCoinMaker.getInstance().getCoinMap());

        ProductInputView productInputView = new ProductInputView();
        productInputView.inputProducts();
        int moneyForPurchase = moneyInputView.inputMoneyForPurchase();
        Money.getInstance().storeMoney(moneyForPurchase);
        PurchaseInputView purchaseInputView = new PurchaseInputView();
        purchaseInputView.inputProductForPurchase();
        outputView.showChange();
    }
}