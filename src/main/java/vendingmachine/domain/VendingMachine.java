package vendingmachine.domain;

import java.util.HashMap;

import vendingmachine.view.input.MoneyInputView;

public class VendingMachine {

    public void start() {
        MoneyInputView moneyInputView = new MoneyInputView();
        Integer money = moneyInputView.inputMoneyForMakeCoin();

        RandomCoinMaker randomCoinMaker = RandomCoinMaker.getInstance();
        HashMap<Integer, Integer> coinMap = randomCoinMaker.makeCoin(money);
    }
}