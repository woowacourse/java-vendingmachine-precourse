package vendingmachine.domain;

import java.util.LinkedHashMap;

import vendingmachine.view.input.MoneyInputView;
import vendingmachine.view.input.ProductInputView;

public class VendingMachine {

    public void start() {
        MoneyInputView moneyInputView = new MoneyInputView();
        Integer moneyForCoin = moneyInputView.inputMoneyForMakeCoin();
        RandomCoinMaker randomCoinMaker = RandomCoinMaker.getInstance();
        LinkedHashMap<Integer, Integer> coinMap = randomCoinMaker.makeCoin(moneyForCoin);

        ProductInputView productInputView = new ProductInputView();
        productInputView.inputProducts();

        Integer moneyForPurchase = moneyInputView.inputMoneyForPurchase();
    }
}