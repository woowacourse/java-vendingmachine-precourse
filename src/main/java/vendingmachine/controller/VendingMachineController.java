package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.validator.HoldingMoneyValidator;
import vendingmachine.view.ErrorMessageOutputView;
import vendingmachine.view.InputView;
import vendingmachine.view.SystemMessageOutputView;

public class VendingMachineController {

    private final VendingMachine vendingMachine;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void execute() {
        initializeHoldingMoney();
        vendingMachine.initializeCoinCase();
        SystemMessageOutputView.printHoldingCoins(vendingMachine.getHoldingCoins());
    }

    private void initializeHoldingMoney() {
        try {
            int validHoldingMoneyInput = HoldingMoneyValidator.getValidHoldingMoney(InputView.inputHoldingMoney());
            vendingMachine.setHoldingMoney(validHoldingMoneyInput);
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            initializeHoldingMoney();
        }
    }

    private void initializeProductsInfo() {
        try {
            int validHoldingMoneyInput = HoldingMoneyValidator.getValidHoldingMoney(InputView.inputHoldingMoney());
            vendingMachine.setHoldingMoney(validHoldingMoneyInput);
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            initializeHoldingMoney();
        }
    }
}
