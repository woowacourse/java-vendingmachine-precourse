package vendingmachine.controller;

import vendingmachine.domain.Balance;
import vendingmachine.domain.Validation;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final Validation validator;
    private final Balance balance;

    public VendingMachineController() {
        validator = new Validation();
        balance = new Balance();
    }

    public void on() {
        receiveVendingMachineBalance();
        requestPrintBalanceCoins();
        receiveItemInformation();
    }

    private void receiveVendingMachineBalance() {

        try {
            OutputView.requestVendingMachineBalance();
            String balanceInput = InputView.receiveInput();
            validator.isValidBalanceInput(balanceInput);
            balance.calculateBalanceCoin(balanceInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(validator.getErrorMessage());
            receiveVendingMachineBalance();
        }

    }

    private void receiveItemInformation() {

        try {
            OutputView.requestItemInformation();
            String itemInput = InputView.receiveInput();
            validator.isValidItemInput(itemInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(validator.getErrorMessage());
            receiveItemInformation();
        }

    }

    private void requestPrintBalanceCoins() {
        OutputView.printBalanceCoins(balance.getBalanceCoin());
    }
}
