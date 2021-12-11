package vendingmachine.controller;

import vendingmachine.domain.PossessionMoney;
import vendingmachine.view.InputView;

public class VendingMachineController {

    public void run() {
        PossessionMoney possessionMoney = InputView.getPossessionMoney();
    }
}