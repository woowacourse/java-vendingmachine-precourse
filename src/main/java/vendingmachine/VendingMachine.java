package vendingmachine;

import vendingmachine.view.InputView;

public class VendingMachine {
    private int currentMoney;

    public VendingMachine() {
    }

    public void inputInitialMoney() {
        this.currentMoney = InputView.inputInitialMoney();
    }

    public int getCurrentMoney() {
        return this.currentMoney;
    }
}
