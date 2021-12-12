package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.validator.HoldingMoneyValidator;
import vendingmachine.view.InputView;

public class VendingMachineController {

    private final VendingMachine vendingMachine;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void execute() {
        int validHoldingMoneyInput = HoldingMoneyValidator.getValidHoldingMoney(InputView.inputHoldingMoney());
        vendingMachine.setHoldingMoney(validHoldingMoneyInput);
    }
}
