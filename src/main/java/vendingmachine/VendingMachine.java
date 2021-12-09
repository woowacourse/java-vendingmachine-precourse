package vendingmachine;

import vendingmachine.view.InputView;

public class VendingMachine {

    public void start() {
        InputView inputView = new InputView();
        Integer money = inputView.inputMoneyForMakeCoin();
    }
}