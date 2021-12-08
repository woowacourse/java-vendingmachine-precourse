package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineChecker;
import vendingmachine.service.VendingMachineProcessor;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final VendingMachine vendingMachine;
    private final VendingMachineProcessor vendingMachineProcessor;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        vendingMachineProcessor = new VendingMachineProcessor(vendingMachine);
    }

    public void run() {
        VendingMachineChecker checker = VendingMachineChecker.OPEN;
        requestVendingMachineChange();
        OutputView.printVendingMachineChanges(vendingMachine);
        OutputView.breakLine();
        requestBeverageInfo();
        OutputView.breakLine();
        requestInsertMoney();
        OutputView.breakLine();
        while (checker == VendingMachineChecker.OPEN) {
            checker = requestInsertBuyBeverageName(checker);
            OutputView.breakLine();
        }
        OutputView.printInsertMoney(vendingMachine);
        OutputView.printVendingMachineReturnChanges(vendingMachine);
    }

    private VendingMachineChecker requestInsertBuyBeverageName(VendingMachineChecker checker) {
        try {
            OutputView.printInsertMoney(vendingMachine);
            String inputName = InputView.insertBuyBeverageName();
            checker = vendingMachineProcessor.purchaseBeverage(inputName);
        } catch (IllegalArgumentException e) {
            OutputView.breakLine();
            OutputView.printSystemMessage(e.getMessage());
            return requestInsertBuyBeverageName(checker);
        }
        return checker;
    }

    private void requestInsertMoney() {
        String insertMoney = InputView.insertInsertMoney();
        try {
            vendingMachine.insertMoney(insertMoney);
        } catch (IllegalArgumentException e) {
            OutputView.breakLine();
            OutputView.printSystemMessage(e.getMessage());
            requestInsertMoney();
        }
    }

    private void requestBeverageInfo() {
        String inputBeverage = InputView.insertBeverageInfo();
        try {
            vendingMachine.createBeverages(inputBeverage);
        } catch (IllegalArgumentException e) {
            OutputView.breakLine();
            OutputView.printSystemMessage(e.getMessage());
            requestBeverageInfo();
        }
    }

    private void requestVendingMachineChange() {
        String inputChanges = InputView.insertVendingMachineChange();
        try {
            vendingMachine.createChanges(inputChanges);
        } catch (IllegalArgumentException e) {
            OutputView.breakLine();
            OutputView.printSystemMessage(e.getMessage());
            requestVendingMachineChange();
        }
    }
}
