package vendingmachine.domain;

import java.util.HashMap;

import vendingmachine.view.input.MoneyInputView;
import vendingmachine.view.input.ProductInputView;

public class VendingMachine {

    public void start() {
        MoneyInputView moneyInputView = new MoneyInputView();
        Integer money = moneyInputView.inputMoneyForMakeCoin();
        RandomCoinMaker randomCoinMaker = RandomCoinMaker.getInstance();
        HashMap<Integer, Integer> coinMap = randomCoinMaker.makeCoin(money);

        ProductInputView productInputView = new ProductInputView();
        productInputView.inputProducts();
    }
}