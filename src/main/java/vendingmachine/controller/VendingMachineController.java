package vendingmachine.controller;

import vendingmachine.domain.Balance;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.validation.Exception;
import vendingmachine.domain.validation.PurchaseValidator;
import vendingmachine.domain.validation.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final Exception exception;
    private final Validator validator;
    private final Balance balance;
    private final Items items;
    private Money money;
    private String userChoice;

    public VendingMachineController() {
        exception = new Exception();
        validator = new Validator(exception);
        balance = new Balance();
        items = new Items();
    }

    public void on() {
        receiveVendingMachineBalance();
        requestPrintBalanceCoins();
        receiveItemInformation();
        receiveInsertMoney();

        while (items.existsItemCanPurchase(money.getRemainMoney())) {
            sale();
        }

        balance.calculateChangeCoin(money.getRemainMoney());
        requestPrintChangeCoins();
    }

    private void receiveVendingMachineBalance() {

        try {
            OutputView.requestVendingMachineBalance();
            String balanceInput = InputView.receiveInput();
            validator.isValidBalanceInput(balanceInput);
            balance.calculateBalanceCoin(balanceInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(exception.getErrorMessage());
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
            OutputView.printErrorMessage(exception.getErrorMessage());
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
            OutputView.printErrorMessage(exception.getErrorMessage());
            receiveInsertMoney();
        }

    }

    private void receiveUserChoice() {
        PurchaseValidator purchaseValidator = new PurchaseValidator(exception);

        try {
            OutputView.printRemainMoney(money.getRemainMoney());
            OutputView.requestPurchaseItem();
            userChoice = InputView.receiveInput();
            purchaseValidator.checkCanPurchase(items, userChoice, money.getRemainMoney());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(exception.getErrorMessage());
            receiveUserChoice();
        }

    }

    private void sale() {
        receiveUserChoice();
        int price = items.sellItem(userChoice);
        money.use(price);
    }

    private void requestPrintChangeCoins() {
        OutputView.printChangeCoins(money.getRemainMoney(), balance.getChangeCoin());
    }
}
