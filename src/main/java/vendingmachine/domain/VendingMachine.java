package vendingmachine.domain;

import java.util.HashMap;

import vendingmachine.view.InputView;

public class VendingMachine {

    public void start() {
        InputView inputView = new InputView();
        Integer money = inputView.inputMoneyForMakeCoin();

        RandomCoinMaker randomCoinMaker = RandomCoinMaker.getInstance();
        HashMap<Integer, Integer> coinMap = randomCoinMaker.makeCoin(money);
    }
}