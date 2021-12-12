package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private VendingMachine vendingMachine;

    public void run() {
        Changes changes = prepareChange();
        prepareMerchandise(changes);
        preparePurchaseAmount();
        buyMerchandise();
        OutputView.returnChanges(vendingMachine.calculateChangeToCustomer());
    }

    private void preparePurchaseAmount() {
        vendingMachine.putMoney(InputView.requireMoney());
    }

    private void prepareMerchandise(Changes changes) {
        try {
            vendingMachine = new VendingMachine(InputView.requireVendingMachineMerchandiseInfo(),
                changes);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            prepareMerchandise(changes);
            return;
        }
    }

    private Changes prepareChange() {
        Changes changes;
        try {
            changes = new Changes(InputView.requireChanges());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            changes = prepareChange();
            return changes;
        }
        OutputView.printChangesState(changes.changes());
        return changes;
    }

    private void buyMerchandise() {
        while (vendingMachine.canBuySomething() && !vendingMachine.soldOut()) {
            OutputView.printExistMoney(vendingMachine.money());
            buyTargetMerchandise();
        }
        OutputView.printExistMoney(vendingMachine.money());
    }

    private void buyTargetMerchandise() {
        try {
            vendingMachine.buyMerchandise(InputView.requireMerchandise());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            buyTargetMerchandise();
            return;
        }
    }
}
