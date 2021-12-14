package vendingmachine.controller;

import vendingmachine.domain.Balance;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.Validation;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final Validation validator;
    private final Balance balance;
    private final Items items;
    private Money money;

    public VendingMachineController() {
        validator = new Validation();
        balance = new Balance();
        items = new Items();
    }

    public void on() {
        receiveVendingMachineBalance();
        requestPrintBalanceCoins();
        receiveItemInformation();
        receiveInsertMoney();
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

    private void requestPrintBalanceCoins() {
        OutputView.printBalanceCoins(balance.getBalanceCoin());
    }

    private void receiveItemInformation() {

        try {
            OutputView.requestItemInformation();
            String itemInput = InputView.receiveInput();
            validator.isValidItemInput(itemInput);
            items.registerItem(itemInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(validator.getErrorMessage());
            receiveItemInformation();
        }

    }

    private void receiveInsertMoney() {

        try {
            OutputView.requestInsertMoney();
            String insertMoney = InputView.receiveInput();
            validator.isValidInsertMoneyInput(insertMoney);
            money = new Money(insertMoney);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(validator.getErrorMessage());
            receiveInsertMoney();
        }

    }

}
