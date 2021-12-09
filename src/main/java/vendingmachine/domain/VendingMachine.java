package vendingmachine.domain;

import java.util.HashMap;

import vendingmachine.view.input.CoinInputView;

public class VendingMachine {

    public void start() {
        CoinInputView coinInputView = new CoinInputView();
        Integer money = coinInputView.inputMoneyForMakeCoin();

        RandomCoinMaker randomCoinMaker = RandomCoinMaker.getInstance();
        HashMap<Integer, Integer> coinMap = randomCoinMaker.makeCoin(money);
    }
}