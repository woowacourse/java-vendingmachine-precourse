package vendingmachine.domain;

import vendingmachine.view.InputView;

public class VendingMachine {

    private int totalMoney;

    public VendingMachine() {
        totalMoney = InputView.getVendingMachineTotalMoneyInput();
    }
}
