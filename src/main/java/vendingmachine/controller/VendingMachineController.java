package vendingmachine.controller;

import vendingmachine.domain.Validation;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final Validation validator;

    public VendingMachineController() {
        validator = new Validation();
    }

    public void on() {
        receiveVendingMachineBalance();
    }

    private void receiveVendingMachineBalance() {

        try {
            OutputView.requestVendingMachineBalance();
            String balanceInput = InputView.receiveInput();
            validator.isValidBalanceInput(balanceInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(validator.getErrorMessage());
            receiveVendingMachineBalance();
        }

    }
}
