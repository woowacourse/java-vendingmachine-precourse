package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.validator.HoldingMoneyValidator;
import vendingmachine.view.ErrorMessageOutputView;
import vendingmachine.view.InputView;

public class VendingMachineController {

    private final VendingMachine vendingMachine;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void execute() {
        enterHoldingMoney();
    }

    private void enterHoldingMoney() {
        try {
            int validHoldingMoneyInput = HoldingMoneyValidator.getValidHoldingMoney(InputView.inputHoldingMoney());
            vendingMachine.setHoldingMoney(validHoldingMoneyInput);
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            enterHoldingMoney();
        }
    }
}
